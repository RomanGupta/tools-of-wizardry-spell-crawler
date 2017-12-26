package de.rge.tools.of.wizardry.spell.crawler;

import java.net.URL;

public interface SpellParser {
    Spell parseSpell(URL spellUrl);
}
