package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private SpellCrawler spellCrawler = new SpellCrawlerImpl();

    private SpellParser spellParser = new SpellParserImpl();

    private Map<MagicSchool, List<URL>> schoolsForSpells = new HashMap<>();
    private Map<MagicSubschool, List<URL>> subschoolsForSpells = new HashMap<>();


    public static void main(String... args) {
            new Main().run();
    }

    private void run() {
        List<URL> spellUrls = spellCrawler.determineAllSpellUrls(Source.SPELLS_ULTIMATE_MAGIC, "[A-Z]");
        System.out.println("found " + spellUrls.size() + " spells");
        spellUrls.forEach(this::printSpell);
        subschoolsForSpells.forEach((k, v) -> System.out.println(k + ":\n" + v));
    }

    private void printSpell(URL spellUrl) {
        Spell spell = parseSpell(spellUrl);
        if (null != spell) {
            log.info("spell url: {}", spellUrl);
            log.info("spell name: {}", spell.getName());
            log.info("spell school: {}", spell.getSchool());
            log.info("spell subschool: {}", spell.getSubschool());
            log.info("spell descriptors: {}", spell.getDescriptors());
            log.info("spell descriptors connector: {}", spell.getDescriptorsConnector());

            subschoolsForSpells.putIfAbsent(spell.getSubschool(), new ArrayList<>());
            subschoolsForSpells.get(spell.getSubschool()).add(spellUrl);
        }
    }

    private Spell parseSpell(URL spellUrl) {
        try {
            return spellParser.parseSpell(spellUrl);
        } catch (Exception ex) {
            log.error("Couldn't parse spell for {}", spellUrl, ex);
        }
        return null;
    }
}
