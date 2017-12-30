package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpellParserImpl implements SpellParser {
    private static final Logger log = LoggerFactory.getLogger(SpellParserImpl.class);
    private static final String TITLE_SELECTOR = "p[class^=stat-block-title]";

    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();

    private SchoolParserImpl schoolParser = new SchoolParserImpl();
    private LevelParserImpl levelParser = new LevelParserImpl();

    private Map<URL, Spell> parsedSpells = new HashMap<>();

    @Override
    public Spell parseSpell(URL spellUrl) {
        if (!parsedSpells.containsKey(spellUrl)) {
            Document htmlDocument = htmlDocumentUtil.read(spellUrl);
            List<Element> spellParagraphs = determineSpellParagraphs(htmlDocument, spellUrl.getRef());
            List<URL> spellReferences = parseSpellReferences(spellParagraphs, spellUrl);
            parsedSpells.put(spellUrl, parseSpell(new SpellContext(parsedSpells, spellParagraphs, spellReferences)));
        }
        return parsedSpells.get(spellUrl);
    }

    private List<Element> determineSpellParagraphs(Document htmlDocument, String targetReference) {
        Elements titleParagraphs = htmlDocument.select(TITLE_SELECTOR);
        Element primaryTitle = determinePrimary(titleParagraphs, targetReference);
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
        return widenReferenceMatches(targetReference).contains(element.attr("id"));
    }

    private List<String> widenReferenceMatches(String targetReference) {
        // eventually, there are typos within the targetReference or the id
        // we try other, possible references with what we know from our experience
        List<String> heuristicReferences = new ArrayList<>();
        heuristicReferences.add(targetReference);
        addHeuristicReference(heuristicReferences, targetReference, ",", "");
        addHeuristicReference(heuristicReferences, targetReference, "-lesser", ",-lesser");
        addHeuristicReference(heuristicReferences, targetReference, "-greater", ",-greater");
        addHeuristicReference(heuristicReferences, targetReference, "-mass", ",-mass");
        return heuristicReferences;
    }

    private void addHeuristicReference(final List<String> heuristicReferences, String targetReference,
                                       String potentialTypo, String replacement) {
        if (targetReference.contains(potentialTypo)) {
            heuristicReferences.add(targetReference.replace(potentialTypo, replacement));
        }
    }

    private List<Element> collectSpellParagraphs(Element primaryTitle) {
        List<Element> spellParagraphs = new ArrayList<>();
        spellParagraphs.add(primaryTitle);

        Elements siblings = primaryTitle.siblingElements();
        for(int siblingIndex = primaryTitle.elementSiblingIndex(); siblingIndex < siblings.size(); siblingIndex++) {
            Element sibling = siblings.get(siblingIndex);
            if(sibling.hasClass("stat-block-title")) {
                break;
            }
            if(sibling.is("p")) {
                spellParagraphs.add(sibling);
            }
        }
        return spellParagraphs;
    }

    private List<URL> parseSpellReferences(List<Element> spellParagraphs, URL spellUrl) {
        Elements spellLinks = spellParagraphs.stream()
                .flatMap(element -> element.select("a[href~=(^#|spells/)]").stream())
                .collect(Collectors.toCollection(Elements::new));
        return new SpellCrawlerImpl(spellUrl).convertToUrls(spellLinks);
    }

    private Spell parseSpell(SpellContext spellContext) {
        spellContext.getSpell().setName(parseName(spellContext.getSpellParagraphs()));
        schoolParser.parseSchoolDetails(spellContext.getSpell(), spellContext.getSpellParagraphs());
        levelParser.parseLevelDetails(spellContext.getSpell(), spellContext.getSpellParagraphs());
        return spellContext.getSpell();
    }

    private String parseName(List<Element> spellParagraphs) {
        return spellParagraphs.get(0).text();
    }

}
