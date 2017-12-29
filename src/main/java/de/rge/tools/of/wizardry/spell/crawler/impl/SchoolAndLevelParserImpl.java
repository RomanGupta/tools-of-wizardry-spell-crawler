package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.Connector.OR;

public class SchoolAndLevelParserImpl {
    private static final Logger log = LoggerFactory.getLogger(SchoolAndLevelParserImpl.class);

    private SchoolParserImpl schoolParser = new SchoolParserImpl();

    public void parseSchoolAndLevel(final Spell spell, Elements refParagraphs) {
        Element relevantParagraph = getRelevantParagraph(refParagraphs);
        if (null != relevantParagraph) {
            String[] detailsSchoolOrLevel = relevantParagraph.text().split(";");
            schoolParser.parseSchoolDetails(spell, detailsSchoolOrLevel[0]);
        } else {
            log.warn("no school found for {}", refParagraphs.first().text());
        }
    }

    private Element getRelevantParagraph(Elements refParagraphs) {
        return refParagraphs.stream()
                .map(Element::nextElementSibling)
                .filter(this::isValidSchoolAndLevelParagraph)
                .findFirst()
                .orElse(null);
    }

    private boolean isValidSchoolAndLevelParagraph(Element p) {
        return p.text().startsWith("School") && p.text().contains("Level");
    }

}
