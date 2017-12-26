package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;

import java.net.URL;
import java.util.List;

public class Main {
    private SpellCrawler spellCrawler = new SpellCrawlerImpl();

    public static void main(String... args) {
        try {
            new Main().run();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public void run() {
        List<URL> spellUrls = spellCrawler.determineAllSpellUrls("[a-z]");
        spellUrls.forEach(System.out::println);
        System.out.println(spellUrls.size());
    }
}
