package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.jsoup.nodes.Element;

import java.util.List;

public class SchoolAndLevelParserImpl {
    private SchoolParserImpl schoolParser = new SchoolParserImpl();
    private LevelParserImpl levelParser = new LevelParserImpl();

    public void parseSchoolAndLevel(final Spell spell, List<Element> spellParagraphs) {
        schoolParser.parseSchoolDetails(spell, spellParagraphs);
        levelParser.parseLevelDetails(spell, spellParagraphs);
    }
}
