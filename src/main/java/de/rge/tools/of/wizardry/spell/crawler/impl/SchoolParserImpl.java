package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SchoolParserImpl {
    private static final Logger log = LoggerFactory.getLogger(SchoolParserImpl.class);

    public MagicSchool parseSchool(Elements refParagraphs) {
        for (Element ref : refParagraphs) {
            MagicSchool potentialSchool = parseSchool(ref.nextElementSibling());
            if (null != potentialSchool) {
                return potentialSchool;
            }
        }
        log.warn("no school found for {}", refParagraphs.first().text());
        return null;
    }

    private MagicSchool parseSchool(Element schoolParagraph) {
        String[] detailsSchoolOrLevel = schoolParagraph.text().split(";");
        String[] schoolDetails = detailsSchoolOrLevel[0].split("\\s+");
        MagicSchool potentialSchool = MagicSchool.convert(schoolDetails[1]);
        if ("School".equals(schoolDetails[0]) && null != potentialSchool) {
            return potentialSchool;
        }
        return null;
    }
}
