package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;

import java.net.URL;
import java.util.*;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool.*;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.*;

public class ExpectedNoOfSpellsPerSubschool {
    private static final Map<Source, Map<MagicSubschool, Integer>> expectedNoOfSpells = new HashMap<>();

    static {
        Map<MagicSubschool, Integer> coreRuleBook = new HashMap<>();
        coreRuleBook.put(null, 389);
        coreRuleBook.put(CALLING, 6);
        coreRuleBook.put(CREATION, 31);
        coreRuleBook.put(HEALING, 25);
        coreRuleBook.put(SUMMONING, 28);
        coreRuleBook.put(TELEPORTATION, 11);
        coreRuleBook.put(SCRYING, 4);
        coreRuleBook.put(CHARM, 6);
        coreRuleBook.put(COMPULSION, 54);
        coreRuleBook.put(FIGMENT, 10);
        coreRuleBook.put(GLAMER, 19);
        coreRuleBook.put(PATTERN, 4);
        coreRuleBook.put(PHANTASM, 5);
        coreRuleBook.put(SHADOW, 8);
        coreRuleBook.put(POLYMORPH, 23);
        expectedNoOfSpells.put(SPELLS_CORE_RULEBOOK, coreRuleBook);

        Map<MagicSubschool, Integer> advancedClassGuideMap = new HashMap<>();
        advancedClassGuideMap.put(null, 93);
        advancedClassGuideMap.put(CALLING, 0);
        advancedClassGuideMap.put(CREATION, 13);
        advancedClassGuideMap.put(HEALING, 2);
        advancedClassGuideMap.put(SUMMONING, 3);
        advancedClassGuideMap.put(TELEPORTATION, 1);
        advancedClassGuideMap.put(SCRYING, 0);
        advancedClassGuideMap.put(CHARM, 1);
        advancedClassGuideMap.put(COMPULSION, 6);
        advancedClassGuideMap.put(FIGMENT, 1);
        advancedClassGuideMap.put(GLAMER, 6);
        advancedClassGuideMap.put(PATTERN, 1);
        advancedClassGuideMap.put(PHANTASM, 0);
        advancedClassGuideMap.put(SHADOW, 2);
        advancedClassGuideMap.put(POLYMORPH, 3);
        expectedNoOfSpells.put(SPELLS_ADVANCED_CLASS_GUIDE, advancedClassGuideMap);

        Map<MagicSubschool, Integer> advancedPlayersGuideMap = new HashMap<>();
        advancedPlayersGuideMap.put(null, 183);
        advancedPlayersGuideMap.put(CALLING, 0);
        advancedPlayersGuideMap.put(CREATION, 20);
        advancedPlayersGuideMap.put(HEALING, 12);
        advancedPlayersGuideMap.put(SUMMONING, 2);
        advancedPlayersGuideMap.put(TELEPORTATION, 4);
        advancedPlayersGuideMap.put(SCRYING, 1);
        advancedPlayersGuideMap.put(CHARM, 1);
        advancedPlayersGuideMap.put(COMPULSION, 27);
        advancedPlayersGuideMap.put(FIGMENT, 0);
        advancedPlayersGuideMap.put(GLAMER, 4);
        advancedPlayersGuideMap.put(PATTERN, 1);
        advancedPlayersGuideMap.put(PHANTASM, 2);
        advancedPlayersGuideMap.put(SHADOW, 0);
        advancedPlayersGuideMap.put(POLYMORPH, 5);
        expectedNoOfSpells.put(SPELLS_ADVANCED_PLAYERS_GUIDE, advancedPlayersGuideMap);

        Map<MagicSubschool, Integer> ultimateMagicMap = new HashMap<>();
        ultimateMagicMap.put(null, 144);
        ultimateMagicMap.put(CALLING, 0);
        ultimateMagicMap.put(CREATION, 14);
        ultimateMagicMap.put(HEALING, 6);
        ultimateMagicMap.put(SUMMONING, 10);
        ultimateMagicMap.put(TELEPORTATION, 3);
        ultimateMagicMap.put(SCRYING, 2);
        ultimateMagicMap.put(CHARM, 0);
        ultimateMagicMap.put(COMPULSION, 25);
        ultimateMagicMap.put(FIGMENT, 2);
        ultimateMagicMap.put(GLAMER, 4);
        ultimateMagicMap.put(PATTERN, 1);
        ultimateMagicMap.put(PHANTASM, 1);
        ultimateMagicMap.put(SHADOW, 6);
        ultimateMagicMap.put(POLYMORPH, 13);
        expectedNoOfSpells.put(SPELLS_ULTIMATE_MAGIC, ultimateMagicMap);
    }

    public static int getExpectedNoOfSpells(Source source, MagicSubschool subschool) {
        return expectedNoOfSpells.get(source).get(subschool);
    }

    public static Map<MagicSubschool, List<URL>> prepareResults(Source source) {
        Map<MagicSubschool, List<URL>> results = new HashMap<>();
        expectedNoOfSpells.get(source).keySet().forEach(subschool -> results.putIfAbsent(subschool, new ArrayList<>()));
        return results;
    }
}
