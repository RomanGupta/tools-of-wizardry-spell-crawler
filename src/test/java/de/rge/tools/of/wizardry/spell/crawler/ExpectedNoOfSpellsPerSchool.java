package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;

import java.net.URL;
import java.util.*;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool.*;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool.TRANSMUTATION;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool.UNIVERSAL;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.*;

public class ExpectedNoOfSpellsPerSchool {
    private static final Map<Source, Map<MagicSchool, Integer>> expectedNoOfSpells = new HashMap<>();

    static {
        Map<MagicSchool, Integer> coreRuleBook = new HashMap<>();
        coreRuleBook.put(null, 0);
        coreRuleBook.put(ABJURATION, 73);
        coreRuleBook.put(CONJURATION, 103);
        coreRuleBook.put(DIVINATION, 50);
        coreRuleBook.put(ENCHANTMENT, 60);
        coreRuleBook.put(EVOCATION, 81);
        coreRuleBook.put(ILLUSION, 47);
        coreRuleBook.put(NECROMANCY, 61);
        coreRuleBook.put(TRANSMUTATION, 143);
        coreRuleBook.put(UNIVERSAL, 5);
        expectedNoOfSpells.put(SPELLS_CORE_RULEBOOK, coreRuleBook);

        Map<MagicSchool, Integer> advancedClassGuideMap = new HashMap<>();
        advancedClassGuideMap.put(null, 1);
        advancedClassGuideMap.put(ABJURATION, 18);
        advancedClassGuideMap.put(CONJURATION, 19);
        advancedClassGuideMap.put(DIVINATION, 9);
        advancedClassGuideMap.put(ENCHANTMENT, 8);
        advancedClassGuideMap.put(EVOCATION, 14);
        advancedClassGuideMap.put(ILLUSION, 10);
        advancedClassGuideMap.put(NECROMANCY, 15);
        advancedClassGuideMap.put(TRANSMUTATION, 38);
        advancedClassGuideMap.put(UNIVERSAL, 0);
        expectedNoOfSpells.put(SPELLS_ADVANCED_CLASS_GUIDE, advancedClassGuideMap);

        Map<MagicSchool, Integer> advancedPlayersGuideMap = new HashMap<>();
        advancedPlayersGuideMap.put(null, 0);
        advancedPlayersGuideMap.put(ABJURATION, 23);
        advancedPlayersGuideMap.put(CONJURATION, 39);
        advancedPlayersGuideMap.put(DIVINATION, 16);
        advancedPlayersGuideMap.put(ENCHANTMENT, 30);
        advancedPlayersGuideMap.put(EVOCATION, 44);
        advancedPlayersGuideMap.put(ILLUSION, 9);
        advancedPlayersGuideMap.put(NECROMANCY, 17);
        advancedPlayersGuideMap.put(TRANSMUTATION, 84);
        advancedPlayersGuideMap.put(UNIVERSAL, 0);
        expectedNoOfSpells.put(SPELLS_ADVANCED_PLAYERS_GUIDE, advancedPlayersGuideMap);

        Map<MagicSchool, Integer> ultimateMagicMap = new HashMap<>();
        ultimateMagicMap.put(null, 0);
        ultimateMagicMap.put(ABJURATION, 14);
        ultimateMagicMap.put(CONJURATION, 35);
        ultimateMagicMap.put(DIVINATION, 13);
        ultimateMagicMap.put(ENCHANTMENT, 28);
        ultimateMagicMap.put(EVOCATION, 32);
        ultimateMagicMap.put(ILLUSION, 14);
        ultimateMagicMap.put(NECROMANCY, 32);
        ultimateMagicMap.put(TRANSMUTATION, 63);
        ultimateMagicMap.put(UNIVERSAL, 0);
        expectedNoOfSpells.put(SPELLS_ULTIMATE_MAGIC, ultimateMagicMap);
    }

    public static int getExpectedNoOfSpells(Source source, MagicSchool school) {
        return expectedNoOfSpells.get(source).get(school);
    }

    public static Map<MagicSchool, List<URL>> prepareResults(Source source) {
        Map<MagicSchool, List<URL>> results = new HashMap<>();
        expectedNoOfSpells.get(source).keySet().forEach(school -> results.putIfAbsent(school, new ArrayList<>()));
        return results;
    }
}
