package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;

import java.net.URL;
import java.util.List;

public class Main {
    private SpellCrawler spellCrawler = new SpellCrawlerImpl();

    private SpellParser spellParser = new SpellParserImpl();

    public static void main(String... args) {
        try {
            new Main().run();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    private void run() {
        List<URL> spellUrls = spellCrawler.determineAllSpellUrls("[a-z]");
        spellUrls.forEach(this::printSpell);
    }

    private void printSpell(URL spellUrl) {
        String spellName = spellParser.parseName(spellUrl);
        System.out.println(spellName + "\t" + spellUrl);
    }
}
