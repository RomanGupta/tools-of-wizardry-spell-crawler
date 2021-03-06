package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import de.rge.tools.of.wizardry.spell.crawler.util.MissingSpellReferenceMapping;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class SpellParserImpl implements SpellParser {
    private static final Logger log = LoggerFactory.getLogger(SpellParserImpl.class);
    private static final String TITLE_SELECTOR = "p[class^=stat-block-title]";

    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();

    private SchoolParserImpl schoolParser = new SchoolParserImpl();
    private LevelParserImpl levelParser = new LevelParserImpl();
    private CastingTimeParserImpl castingTimeParser = new CastingTimeParserImpl();

    private Map<URL, SpellContext> parsedSpells = new HashMap<>();

    // memorize places where you have been so you don't get stuck in an recursive endless loop
    private List<URL> urlMemory;

    @Override
    public Spell parseSpell(URL spellUrl) {
        urlMemory = new ArrayList<>(Collections.singletonList(spellUrl));
        return parseSpellContext(spellUrl).getSpell();
    }

    private SpellContext parseSpellContext(URL spellUrl) {
        log.info("parsing spell context for spell url: {}", spellUrl);
        if (!parsedSpells.containsKey(spellUrl)) {
            List<Element> spellParagraphs = determineSpellParagraphs(spellUrl);
            SpellContext spellReference = parseSpellReference(spellParagraphs, spellUrl);
            parsedSpells.put(spellUrl, parseSpellContext(new SpellContext(spellParagraphs,
                    null == spellReference ? Collections.emptyList() : Collections.singletonList(spellReference))));
        }
        return parsedSpells.get(spellUrl);
    }

    private List<Element> determineSpellParagraphs(URL spellUrl) {
        Document htmlDocument = htmlDocumentUtil.read(spellUrl);
        Elements titleParagraphs = htmlDocument.select(TITLE_SELECTOR);
        Element primaryTitle = determinePrimary(titleParagraphs, spellUrl.getRef());
        return collectSpellParagraphs(primaryTitle);
    }

    private Element determinePrimary(final Elements titleParagraphs, String targetReference) {
        if (1 == titleParagraphs.size() || null == targetReference) {
            return titleParagraphs.first();
        }
        return titleParagraphs.stream()
                .filter(element -> isTitleWith(targetReference, element))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Couldn't determine primary title with reference: " + targetReference));
    }

    private boolean isTitleWith(String targetReference, Element element) {
        return widenIdMatches(targetReference).contains(element.attr("id"));
    }

    private List<String> widenIdMatches(String targetReference) {
        // eventually, there are typos within the targetReference or the id
        // we try other, possible references with what we know from our experience
        List<String> heuristicIds = new ArrayList<>();
        heuristicIds.add(targetReference);
        addHeuristicId(heuristicIds, targetReference, ",", "");
        addHeuristicId(heuristicIds, targetReference, "-lesser", ",-lesser");
        addHeuristicId(heuristicIds, targetReference, "-greater", ",-greater");
        addHeuristicId(heuristicIds, targetReference, "-mass", ",-mass");
        return heuristicIds;
    }

    private void addHeuristicId(final List<String> heuristicReferences, String targetReference,
                                String potentialTypo, String replacement) {
        if (targetReference.contains(potentialTypo)) {
            heuristicReferences.add(targetReference.replace(potentialTypo, replacement));
        }
    }

    private List<Element> collectSpellParagraphs(Element primaryTitle) {
        List<Element> spellParagraphs = new ArrayList<>();
        spellParagraphs.add(primaryTitle);

        Elements siblings = primaryTitle.siblingElements();
        for (int siblingIndex = primaryTitle.elementSiblingIndex(); siblingIndex < siblings.size(); siblingIndex++) {
            Element sibling = siblings.get(siblingIndex);
            if (sibling.hasClass("stat-block-title")) {
                break;
            }
            if (sibling.is("p")) {
                spellParagraphs.add(sibling);
            }
        }
        return spellParagraphs;
    }

    private SpellContext parseSpellReference(List<Element> spellParagraphs, URL spellUrl) {
        log.info("parsing spell references for spell url: {}", spellUrl);
        List<URL> spellReferences = collectAllLinks(spellParagraphs, spellUrl);
        return spellReferences.stream()
                .filter(this::isValidSpellUrl)
                .map(this::parseSpellContext)
                .findFirst()
                .orElse(null);
    }

    private List<URL> collectAllLinks(List<Element> spellParagraphs, URL spellUrl) {
        URL spellReferenceURL = MissingSpellReferenceMapping.getReferenceUrl(spellUrl);
        if(null != spellReferenceURL) {
            return Collections.singletonList(spellReferenceURL);
        }
        Elements links = spellParagraphs.stream()
                .flatMap(element -> element.select("a[href]").stream())
                .collect(Collectors.toCollection(Elements::new));
        return new SpellCrawlerImpl(spellUrl).convertToUrls(links);
    }

    private boolean isValidSpellUrl(URL url) {
        return url.toExternalForm().contains("/spells/") && isNotRecursiveReference(url);
    }

    private boolean isNotRecursiveReference(URL url) {
        if (urlMemory.contains(url)) {
            return false;
        }
        urlMemory.add(url);
        return true;
    }

    private SpellContext parseSpellContext(SpellContext spellContext) {
        spellContext.getSpell().setName(parseName(spellContext.getSpellParagraphs()));
        schoolParser.parseSchoolDetails(spellContext);
        levelParser.parseLevelDetails(spellContext);
        castingTimeParser.parseCastingTime(spellContext);
        new SpellCompleterImpl(spellContext).completeSpellWithReferences();
        return spellContext;
    }

    private String parseName(List<Element> spellParagraphs) {
        return spellParagraphs.get(0).text();
    }

}
