package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;

import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String... args) {
        try {
            SpellCrawler spellCrawler = new SpellCrawlerImpl();
            List<URL> spellUrls = spellCrawler.determineAllSpellUrls("[a-z]");
            spellUrls.forEach(System.out::println);
            System.out.println(spellUrls.size());
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
}
