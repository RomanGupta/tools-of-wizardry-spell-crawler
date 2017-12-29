package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Class;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LevelParserImpl {
    private static final Pattern LEVEL_DETAILS_PATTERN = Pattern.compile("Level:?\\s+([A-Za-z/]+\\s+\\d(,\\s*[A-Za-z/]+\\s+\\d)*)");

    public void parseLevelDetails(final Spell spell, Elements relevantParagraphs) {
        Matcher matcher = findLevelLine(relevantParagraphs);
        for (String classAndLevelPair : matcher.group(1).split(",\\s+")) {
            addClassPerLevel(spell, classAndLevelPair);
        }
    }

    private Matcher findLevelLine(Elements relevantParagraphs) {
        return relevantParagraphs.stream()
                .map(Element::text)
                .map(LEVEL_DETAILS_PATTERN::matcher)
                .filter(Matcher::find)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Couldn't parse class and level details " +
                        "from any paragraph: " + relevantParagraphs));
    }

    private void addClassPerLevel(final Spell spell, String classAndLevelPair) {
        String[] classAndLevel = classAndLevelPair.split("\\s+");
        int level = Integer.parseInt(classAndLevel[1]);
        for (String clazz : classAndLevel[0].split("/")) {
            addClassPerLevel(spell, clazz, level);
        }
    }

    private void addClassPerLevel(final Spell spell, String clazz, int level) {
        Class potentialClass = Class.convert(clazz);
        if (null != potentialClass) {
            spell.addLevelPerClass(potentialClass, level);
        } else {
            throw new IllegalArgumentException("Couldn't parse class from " + clazz);
        }
    }

}
