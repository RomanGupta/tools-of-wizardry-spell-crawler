package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.SPELLS_ULTIMATE_MAGIC;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private SpellCrawler spellCrawler = new SpellCrawlerImpl(SPELLS_ULTIMATE_MAGIC.readSourceUrl());

    private SpellParser spellParser = new SpellParserImpl();

    private Map<String, List<URL>> castingTimesForSpells = new HashMap<>();


    public static void main(String... args) {
            new Main().run();
    }

    private void run() {
        List<URL> spellUrls = spellCrawler.determineAllSpellUrls("[a-z]");
        System.out.println("found " + spellUrls.size() + " spells");
        spellUrls.forEach(this::printSpell);
        castingTimesForSpells.forEach((k, v) -> System.out.println(k + ":\n" + v));
    }

    private void printSpell(URL spellUrl) {
        Spell spell = parseSpell(spellUrl);
        if (null != spell) {
//            log.info("spell url: {}", spellUrl);
//            log.info("spell name: {}", spell.getName());
//            log.info("spell school: {}", spell.getSchool());
//            log.info("spell subschool: {}", spell.getSubschool());
//            log.info("spell descriptors: {}", spell.getDescriptors());
//            log.info("spell descriptors connector: {}", spell.getDescriptorsConnector());
//            log.info("spell level per class: {}", spell.getLevelPerClass());

            castingTimesForSpells.putIfAbsent(spell.getCastingTime(), new ArrayList<>());
            castingTimesForSpells.get(spell.getCastingTime()).add(spellUrl);
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
