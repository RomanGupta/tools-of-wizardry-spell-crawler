package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class SchoolParserImpl {
    private static final Logger log = LoggerFactory.getLogger(SchoolParserImpl.class);

    public String parseSchool(Elements refParagraphs) {
        for(Element ref : refParagraphs) {
            String potentialSchool = parseSchool(ref.nextElementSibling());
            if(MagicSchool.isValidSchool(potentialSchool)) {
                return potentialSchool;
            }
        }
        log.warn("no school found for {}", refParagraphs.first().text());
        return null;
    }

    private String parseSchool(Element schoolParagraph) {
        List<String> words = Arrays.asList(schoolParagraph.text().split("\\s+"));
        if("School".equals(words.get(0))) {
            return cleanSchool(words.get(1));
        }
        return null;
    }

    private String cleanSchool(String potentialSchool) {
        return potentialSchool.replaceAll("[; ]", "").toLowerCase();
    }

}
