package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.stream.Collectors;

public class SchoolAndLevelParserImpl {
    private SchoolParserImpl schoolParser = new SchoolParserImpl();
    private LevelParserImpl levelParser = new LevelParserImpl();

    public void parseSchoolAndLevel(final Spell spell, Elements refParagraphs) {
        Elements relevantParagraphs = shiftToSchoolAndLevelParagraphs(refParagraphs);
        schoolParser.parseSchoolDetails(spell, relevantParagraphs);
        levelParser.parseLevelDetails(spell, relevantParagraphs);
    }

    private Elements shiftToSchoolAndLevelParagraphs(Elements refParagraphs) {
        return refParagraphs.stream()
                .map(Element::nextElementSibling)
                .collect(Collectors.toCollection(Elements::new));
    }

}
