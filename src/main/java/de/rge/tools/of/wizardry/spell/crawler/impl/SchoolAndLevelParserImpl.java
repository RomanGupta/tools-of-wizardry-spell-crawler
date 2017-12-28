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

    private static final Pattern SCHOOL_DETAILS_PATTERN = Pattern.compile("^School\\s+(\\w+)\\s*(\\(\\w+\\))?\\s*(\\[[A-Za-z\\-, ]+\\])?");

    public void parseSchoolAndLevel(final Spell spell, Elements refParagraphs) {
        Element relevantParagraph = getRelevantParagraph(refParagraphs);
        if (null != relevantParagraph) {
            String[] detailsSchoolOrLevel = relevantParagraph.text().split(";");
            parseSchoolDetails(spell, detailsSchoolOrLevel[0]);
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

    private MagicSchool parseSchoolDetails(final Spell spell, String schoolPhrase) {
        Matcher matcher = SCHOOL_DETAILS_PATTERN.matcher(schoolPhrase);
        if (matcher.find()) {
            MagicSchool potentialSchool = MagicSchool.convert(matcher.group(1));
            if (null != potentialSchool) {
                spell.setSchool(potentialSchool);
            } else {
                throw new IllegalArgumentException("Couldn't parse school from " + matcher.group(1));
            }
            parseOptionalSchoolDetails(spell, matcher);
        }
        return null;
    }

    private void parseOptionalSchoolDetails(final Spell spell, Matcher matcher) {
        parseSubschool(spell, matcher);
        parseDescriptors(spell, matcher);
    }

    private void parseSubschool(Spell spell, Matcher matcher) {
        String subschoolMatch = matcher.group(2);
        if (null != subschoolMatch) {
            MagicSubschool potentialSubschool = MagicSubschool.convert(stripBrackets(subschoolMatch));
            if(null != potentialSubschool) {
                spell.setSubschool(potentialSubschool);
            } else {
                log.warn("Couldn't parse subschool from {}", matcher.group(2));
            }
        }
    }

    private void parseDescriptors(Spell spell, Matcher matcher) {
        String descriptorsMatch = matcher.group(3);
        if (null != descriptorsMatch) {
            if(descriptorsMatch.contains("or ")) {
                descriptorsMatch = descriptorsMatch.replaceAll("[, ]\\s*or ", ", ");
                spell.setDescriptorsConnector(OR);
            }
            spell.setDescriptors(convertDescriptors(descriptorsMatch));
        }
    }

    private List<MagicDescriptor> convertDescriptors(String descriptorsMatch) {
        return Arrays.stream(stripBrackets(descriptorsMatch).split(",\\s*"))
                .map(this::convertDescriptor)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private MagicDescriptor convertDescriptor(String descriptorMatch) {
            MagicDescriptor potentialDescriptor = MagicDescriptor.convert(descriptorMatch);
            if(null != potentialDescriptor) {
                return potentialDescriptor;
            }
            log.warn("Couldn't parse descriptor from {}", descriptorMatch);
            return null;
    }

    private String stripBrackets(String potentialSubschool) {
        return potentialSubschool.substring(1, potentialSubschool.length() - 1);
    }
}
