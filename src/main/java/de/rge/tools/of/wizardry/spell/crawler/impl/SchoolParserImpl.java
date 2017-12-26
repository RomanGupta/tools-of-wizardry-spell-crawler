package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SchoolParserImpl {
    private static final Logger log = LoggerFactory.getLogger(SchoolParserImpl.class);

    private static final Pattern SCHOOL_PATTERN = Pattern.compile(assembleSchoolPattern());

    public String parseSchool(Document htmlDocument) {
        Elements schoolTitles = findSchoolTitles(htmlDocument);
        String potentialSchool = schoolTitles.first().nextElementSibling().text();
        if(MagicSchool.isValidSchool(potentialSchool)) {
            return potentialSchool;
        }
        String parentContent = schoolTitles.first().parent().text();
        return parseSchool(parentContent);
    }

    private Elements findSchoolTitles(Document htmlDocument) {
        Elements schoolTitles = htmlDocument.select("b:matchesOwn(^School$)");
        if(schoolTitles.isEmpty()) {
            throw new IllegalArgumentException("found no schoolTitles for " + htmlDocument.baseUri());
        } else if (schoolTitles.size() > 1) {
            log.warn("number of schoolTitles greater than 1 for {}", htmlDocument.baseUri());
        }
        return schoolTitles;
    }

    private String parseSchool(String content) {
        Matcher matcher = SCHOOL_PATTERN.matcher(content);
        if(matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static String assembleSchoolPattern() {
        return Arrays.stream(MagicSchool.values())
                .map(MagicSchool::name)
                .map(String::toLowerCase)
                .collect(Collectors.joining("|", "(", ")"));
    }
}
