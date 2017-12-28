package de.rge.tools.of.wizardry.spell.crawler.api;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;

import java.net.URL;
import java.util.List;

public interface SpellCrawler {
    List<URL> determineAllSpellUrls(Source source, String startingLetterPattern);
}
