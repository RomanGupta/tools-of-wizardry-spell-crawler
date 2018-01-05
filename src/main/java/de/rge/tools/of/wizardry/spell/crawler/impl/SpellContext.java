package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.jsoup.nodes.Element;

import java.util.Collections;
import java.util.List;

public class SpellContext {
    private final Spell spell;

    private final List<Element> spellParagraphs;

    private final List<SpellContext> spellReferences;

    public SpellContext(List<Element> spellParagraphs, List<SpellContext> spellReferences) {
        this.spell = new Spell();
        this.spellParagraphs = Collections.unmodifiableList(spellParagraphs);
        this.spellReferences = Collections.unmodifiableList(spellReferences);
    }

    public Spell getSpell() {
        return spell;
    }

    public List<Element> getSpellParagraphs() {
        return spellParagraphs;
    }

    public List<SpellContext> getSpellReferences() {
        return spellReferences;
    }

}
