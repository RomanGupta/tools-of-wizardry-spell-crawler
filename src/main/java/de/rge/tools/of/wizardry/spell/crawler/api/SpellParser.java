package de.rge.tools.of.wizardry.spell.crawler.api;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;

import java.net.URL;

public interface SpellParser {
    Spell parseSpell(URL spellUrl);
}
