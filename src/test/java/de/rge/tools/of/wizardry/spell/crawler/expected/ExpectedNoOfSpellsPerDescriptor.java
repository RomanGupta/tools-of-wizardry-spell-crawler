package de.rge.tools.of.wizardry.spell.crawler.expected;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.*;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.Connector.AND;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.Connector.OR;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.*;

public class ExpectedNoOfSpellsPerDescriptor {
    private static final Map<Source, Map<MagicDescriptor, Integer>> expectedNoOfSpells = new HashMap<>();

    static {
        Map<MagicDescriptor, Integer> coreRuleBook = new HashMap<>();
        coreRuleBook.put(null, 400);
        coreRuleBook.put(ACID, 3);
        coreRuleBook.put(AIR, 7);
        coreRuleBook.put(CHAOTIC, 6);
        coreRuleBook.put(COLD, 9);
        coreRuleBook.put(DARKNESS, 2);
        coreRuleBook.put(DEATH, 8);
        coreRuleBook.put(EARTH, 10);
        coreRuleBook.put(ELECTRICITY, 5);
        coreRuleBook.put(EVIL, 16);
        coreRuleBook.put(FEAR, 8);
        coreRuleBook.put(FIRE, 17);
        coreRuleBook.put(FORCE, 19);
        coreRuleBook.put(GOOD, 10);
        coreRuleBook.put(LANGUAGE_DEPENDENT, 9);
        coreRuleBook.put(LAWFUL, 6);
        coreRuleBook.put(LIGHT, 8);
        coreRuleBook.put(MIND_AFFECTING, 75);
        coreRuleBook.put(SONIC, 13);
        coreRuleBook.put(WATER, 3);
        coreRuleBook.put(CURSE, 0);
        coreRuleBook.put(DISEASE, 0);
        coreRuleBook.put(EMOTION, 0);
        coreRuleBook.put(PAIN, 0);
        coreRuleBook.put(POISON, 0);
        coreRuleBook.put(SHADOW, 0);
        coreRuleBook.put(SEE_TEXT, 16);
        expectedNoOfSpells.put(SPELLS_CORE_RULEBOOK, coreRuleBook);

        Map<MagicDescriptor, Integer> advancedClassGuideMap = new HashMap<>();
        advancedClassGuideMap.put(null, 83);
        advancedClassGuideMap.put(ACID, 1);
        advancedClassGuideMap.put(AIR, 2);
        advancedClassGuideMap.put(CHAOTIC, 0);
        advancedClassGuideMap.put(COLD, 3);
        advancedClassGuideMap.put(DARKNESS, 1);
        advancedClassGuideMap.put(DEATH, 3);
        advancedClassGuideMap.put(EARTH, 4);
        advancedClassGuideMap.put(ELECTRICITY, 3);
        advancedClassGuideMap.put(EVIL, 1);
        advancedClassGuideMap.put(FEAR, 2);
        advancedClassGuideMap.put(FIRE, 2);
        advancedClassGuideMap.put(FORCE, 1);
        advancedClassGuideMap.put(GOOD, 2);
        advancedClassGuideMap.put(LANGUAGE_DEPENDENT, 3);
        advancedClassGuideMap.put(LAWFUL, 0);
        advancedClassGuideMap.put(LIGHT, 2);
        advancedClassGuideMap.put(MIND_AFFECTING, 12);
        advancedClassGuideMap.put(SONIC, 5);
        advancedClassGuideMap.put(WATER, 4);
        advancedClassGuideMap.put(CURSE, 3);
        advancedClassGuideMap.put(DISEASE, 0);
        advancedClassGuideMap.put(EMOTION, 2);
        advancedClassGuideMap.put(PAIN, 0);
        advancedClassGuideMap.put(POISON, 5);
        advancedClassGuideMap.put(SHADOW, 2);
        advancedClassGuideMap.put(SEE_TEXT, 3);
        expectedNoOfSpells.put(SPELLS_ADVANCED_CLASS_GUIDE, advancedClassGuideMap);

        Map<MagicDescriptor, Integer> advancedPlayersGuideMap = new HashMap<>();
        advancedPlayersGuideMap.put(null, 151);
        advancedPlayersGuideMap.put(ACID, 6);
        advancedPlayersGuideMap.put(AIR, 7);
        advancedPlayersGuideMap.put(CHAOTIC, 3);
        advancedPlayersGuideMap.put(COLD, 5);
        advancedPlayersGuideMap.put(DARKNESS, 1);
        advancedPlayersGuideMap.put(DEATH, 0);
        advancedPlayersGuideMap.put(EARTH, 10);
        advancedPlayersGuideMap.put(ELECTRICITY, 7);
        advancedPlayersGuideMap.put(EVIL, 8);
        advancedPlayersGuideMap.put(FEAR, 4);
        advancedPlayersGuideMap.put(FIRE, 21);
        advancedPlayersGuideMap.put(FORCE, 5);
        advancedPlayersGuideMap.put(GOOD, 10);
        advancedPlayersGuideMap.put(LANGUAGE_DEPENDENT, 6);
        advancedPlayersGuideMap.put(LAWFUL, 3);
        advancedPlayersGuideMap.put(LIGHT, 6);
        advancedPlayersGuideMap.put(MIND_AFFECTING, 38);
        advancedPlayersGuideMap.put(SONIC, 9);
        advancedPlayersGuideMap.put(WATER, 11);
        advancedPlayersGuideMap.put(CURSE, 0);
        advancedPlayersGuideMap.put(DISEASE, 0);
        advancedPlayersGuideMap.put(EMOTION, 0);
        advancedPlayersGuideMap.put(PAIN, 0);
        advancedPlayersGuideMap.put(POISON, 0);
        advancedPlayersGuideMap.put(SHADOW, 0);
        advancedPlayersGuideMap.put(SEE_TEXT, 0);
        expectedNoOfSpells.put(SPELLS_ADVANCED_PLAYERS_GUIDE, advancedPlayersGuideMap);

        Map<MagicDescriptor, Integer> ultimateMagicMap = new HashMap<>();
        ultimateMagicMap.put(null, 106);
        ultimateMagicMap.put(ACID, 9);
        ultimateMagicMap.put(AIR, 2);
        ultimateMagicMap.put(CHAOTIC, 0);
        ultimateMagicMap.put(COLD, 12);
        ultimateMagicMap.put(DARKNESS, 3);
        ultimateMagicMap.put(DEATH, 1);
        ultimateMagicMap.put(EARTH, 1);
        ultimateMagicMap.put(ELECTRICITY, 3);
        ultimateMagicMap.put(EVIL, 18);
        ultimateMagicMap.put(FEAR, 4);
        ultimateMagicMap.put(FIRE, 4);
        ultimateMagicMap.put(FORCE, 5);
        ultimateMagicMap.put(GOOD, 7);
        ultimateMagicMap.put(LANGUAGE_DEPENDENT, 3);
        ultimateMagicMap.put(LAWFUL, 2);
        ultimateMagicMap.put(LIGHT, 1);
        ultimateMagicMap.put(MIND_AFFECTING, 32);
        ultimateMagicMap.put(SONIC, 12);
        ultimateMagicMap.put(WATER, 3);
        ultimateMagicMap.put(CURSE, 7);
        ultimateMagicMap.put(DISEASE, 7);
        ultimateMagicMap.put(EMOTION, 22);
        ultimateMagicMap.put(PAIN, 9);
        ultimateMagicMap.put(POISON, 4);
        ultimateMagicMap.put(SHADOW, 6);
        ultimateMagicMap.put(SEE_TEXT, 1);
        expectedNoOfSpells.put(SPELLS_ULTIMATE_MAGIC, ultimateMagicMap);
    }

    private static final Map<Source, Map<MagicDescriptor.Connector, Integer>> expectedNoOfSpellsPerConnector = new HashMap<>();

    static {
        Map<MagicDescriptor.Connector, Integer> coreRuleBook = new HashMap<>();
        coreRuleBook.put(null, 0);
        coreRuleBook.put(AND, 622);
        coreRuleBook.put(OR, 1);
        expectedNoOfSpellsPerConnector.put(SPELLS_CORE_RULEBOOK, coreRuleBook);

        Map<MagicDescriptor.Connector, Integer> advancedClassGuideMap = new HashMap<>();
        advancedClassGuideMap.put(null, 1);
        advancedClassGuideMap.put(AND, 131);
        advancedClassGuideMap.put(OR, 0);
        expectedNoOfSpellsPerConnector.put(SPELLS_ADVANCED_CLASS_GUIDE, advancedClassGuideMap);

        Map<MagicDescriptor.Connector, Integer> advancedPlayersGuideMap = new HashMap<>();
        advancedPlayersGuideMap.put(null, 0);
        advancedPlayersGuideMap.put(AND, 253);
        advancedPlayersGuideMap.put(OR, 9);
        expectedNoOfSpellsPerConnector.put(SPELLS_ADVANCED_PLAYERS_GUIDE, advancedPlayersGuideMap);

        Map<MagicDescriptor.Connector, Integer> ultimateMagicMap = new HashMap<>();
        ultimateMagicMap.put(null, 0);
        ultimateMagicMap.put(AND, 231);
        ultimateMagicMap.put(OR, 0);
        expectedNoOfSpellsPerConnector.put(SPELLS_ULTIMATE_MAGIC, ultimateMagicMap);
    }

    public static int getExpectedNoOfSpells(Source source, MagicDescriptor school) {
        return expectedNoOfSpells.get(source).get(school);
    }

    public static int getExpectedNoOfSpellsPerConnector(Source source, MagicDescriptor.Connector school) {
        return expectedNoOfSpellsPerConnector.get(source).get(school);
    }

    public static Map<MagicDescriptor, List<URL>> prepareResults(Source source) {
        Map<MagicDescriptor, List<URL>> results = new HashMap<>();
        expectedNoOfSpells.get(source).keySet().forEach(descriptor -> results.putIfAbsent(descriptor, new ArrayList<>()));
        return results;
    }

    public static Map<MagicDescriptor.Connector, List<URL>> prepareResultsPerConnector(Source source) {
        Map<MagicDescriptor.Connector, List<URL>> results = new HashMap<>();
        expectedNoOfSpellsPerConnector.get(source).keySet().forEach(connector -> results.putIfAbsent(connector, new ArrayList<>()));
        return results;
    }
}
