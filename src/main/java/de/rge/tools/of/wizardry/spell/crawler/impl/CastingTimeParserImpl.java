package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CastingTimeParserImpl {
    private static final Logger log = LoggerFactory.getLogger(CastingTimeParserImpl.class);

    private static final Pattern CASTING_TIME_PATTERN = Pattern.compile("^Casting Time\\s+([A-Za-z0-9 ]+)");

    public void parseCastingTime(final SpellContext spellContext) {
        Matcher matcher = findCastingTimeLine(spellContext.getSpellParagraphs());
        if(null != matcher) {
            parseCastingTime(matcher, spellContext.getSpell());
        }
    }

    private Matcher findCastingTimeLine(List<Element> spellParagraphs) {
        return spellParagraphs.stream()
                .map(Element::text)
                .map(CASTING_TIME_PATTERN::matcher)
                .filter(Matcher::find)
                .findFirst()
                .orElse(null);
    }

    private void parseCastingTime(Matcher matcher, Spell spell) {
        String potentialCastingTime = matcher.group(1);
        if (null != potentialCastingTime) {
            spell.setCastingTime(potentialCastingTime);
        } else {
            throw new IllegalArgumentException("Couldn't parse casting time from " + matcher.group(1));
        }
    }
}
