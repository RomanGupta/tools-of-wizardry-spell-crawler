package de.rge.tools.of.wizardry.spell.crawler.api;

import java.net.URL;
import java.util.List;

public interface SpellCrawler {
    List<URL> determineAllSpellUrls(String startingLetterPattern);
}
