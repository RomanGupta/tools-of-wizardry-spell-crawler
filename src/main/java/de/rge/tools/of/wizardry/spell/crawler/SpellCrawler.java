package de.rge.tools.of.wizardry.spell.crawler;

import java.net.URL;
import java.util.List;

public interface SpellCrawler {
    List<URL> determineAllSpellUrls(String startingLetterPattern);
}
