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
import java.util.List;

public class SpellParserImpl implements SpellParser {
    private static final Logger log = LoggerFactory.getLogger(SpellParserImpl.class);

    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();

    private SchoolParserImpl schoolParser = new SchoolParserImpl();

    @Override
    public Spell parseSpell(URL spellUrl) {
        Document htmlDocument = htmlDocumentUtil.read(spellUrl);
        Elements refParagraphs = getPrioritizedRefParagraphs(htmlDocument, spellUrl.getRef());
        return parseSpell(refParagraphs);
    }

    private Elements getPrioritizedRefParagraphs(Document htmlDocument, String targetReference) {
        Elements refParagraphs = htmlDocument.select("p[class^=stat-block-title]");
        if (null != targetReference) {
            prioritizeTargetReference(refParagraphs, targetReference);
        }
        return refParagraphs;
    }

    private void prioritizeTargetReference(final Elements refParagraphs, String targetReference) {
        int index = indexOf(refParagraphs.eachAttr("id"), targetReference);
        if (index >= 0) {
            Element targetRefParagraph = refParagraphs.remove(index);
            refParagraphs.add(0, targetRefParagraph);
        }
    }

    private int indexOf(List<String> ids, String targetReference) {
        for (String heuristicReference : widenReferenceMatches(targetReference)) {
            int index = ids.indexOf(heuristicReference);
            if (index >= 0) {
                return index;
            }
        }
        log.warn("Insufficient target reference or id: Can't find '" + targetReference + "' in " + ids);
        return -1;
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
        if(targetReference.contains(potentialTypo)) {
            heuristicReferences.add(targetReference.replace(potentialTypo, replacement));
        }
    }

    private Spell parseSpell(Elements refParagraphs) {
        Spell spell = new Spell();
        spell.setName(parseName(refParagraphs));
        spell.setSchool(schoolParser.parseSchool(refParagraphs));
        return spell;
    }

    private String parseName(Elements referencePoints) {
        return referencePoints.first().text();
    }

}
