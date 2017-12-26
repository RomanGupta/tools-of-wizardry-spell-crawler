package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

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
        Spell spell = spellParser.parseSpell(spellUrl);
        log.info("spell name: {} for spell url {}", spell, spellUrl);
    }
}
