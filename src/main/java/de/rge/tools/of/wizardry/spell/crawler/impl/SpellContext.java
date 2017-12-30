package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.jsoup.nodes.Element;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SpellContext {
    private final Spell spell;

    private final Map<URL, Spell> parsedSpells;

    private final List<Element> spellParagraphs;

    private final List<URL> spellReferences;

    SpellContext(Map<URL, Spell> parsedSpells, List<Element> spellParagraphs, List<URL> spellReferences) {
        this.spell = new Spell();
        this.parsedSpells = parsedSpells;
        this.spellParagraphs = Collections.unmodifiableList(spellParagraphs);
        this.spellReferences = spellReferences;
    }

    public Spell getSpell() {
        return spell;
    }

    public Spell getParsedSpell(URL spellUrl) {
        return parsedSpells.get(spellUrl);
    }

    public void addParsedSpell(URL spellUrl, Spell spell) {
        parsedSpells.putIfAbsent(spellUrl, spell);
    }

    public List<Element> getSpellParagraphs() {
        return spellParagraphs;
    }
}
