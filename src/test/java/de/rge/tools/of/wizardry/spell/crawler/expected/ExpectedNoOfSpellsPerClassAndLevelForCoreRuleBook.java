package de.rge.tools.of.wizardry.spell.crawler.expected;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.Class;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Class.*;

public class ExpectedNoOfSpellsPerClassAndLevelForCoreRuleBook implements ExpectedNoOfSpellsPerClassAndLevelForSource {
    private final Map<Class, Map<Integer, Integer>> expectedNoOfSpells = new HashMap<>();

    {
        // Invalid class and/or level
        Map<Integer, Integer> expectedSpellsForInvalid = new HashMap<>();
        expectedSpellsForInvalid.putIfAbsent(null, 0);
        expectedNoOfSpells.put(null, expectedSpellsForInvalid);
        // Bard
        Map<Integer, Integer> expectedSpellsForBard = new HashMap<>();
        expectedSpellsForBard.put(0, 16);
        expectedSpellsForBard.put(1, 26);
        expectedSpellsForBard.put(2, 35);
        expectedSpellsForBard.put(3, 30);
        expectedSpellsForBard.put(4, 21);
        expectedSpellsForBard.put(5, 16);
        expectedSpellsForBard.put(6, 20);
        expectedNoOfSpells.put(BARD, expectedSpellsForBard);
        // Cleric
        Map<Integer, Integer> expectedSpellsForCleric = new HashMap<>();
        expectedSpellsForCleric.put(0, 12);
        expectedSpellsForCleric.put(1, 31);
        expectedSpellsForCleric.put(2, 32);
        expectedSpellsForCleric.put(3, 34);
        expectedSpellsForCleric.put(4, 27);
        expectedSpellsForCleric.put(5, 28);
        expectedSpellsForCleric.put(6, 26);
        expectedSpellsForCleric.put(7, 18);
        expectedSpellsForCleric.put(8, 17);
        expectedSpellsForCleric.put(9, 11);
        expectedNoOfSpells.put(CLERIC, expectedSpellsForCleric);
        // Druid
        Map<Integer, Integer> expectedSpellsForDruid = new HashMap<>();
        expectedSpellsForDruid.put(0, 13);
        expectedSpellsForDruid.put(1, 20);
        expectedSpellsForDruid.put(2, 26);
        expectedSpellsForDruid.put(3, 22);
        expectedSpellsForDruid.put(4, 17);
        expectedSpellsForDruid.put(5, 19);
        expectedSpellsForDruid.put(6, 18);
        expectedSpellsForDruid.put(7, 13);
        expectedSpellsForDruid.put(8, 11);
        expectedSpellsForDruid.put(9, 10);
        expectedNoOfSpells.put(DRUID, expectedSpellsForDruid);
        // Paladin
        Map<Integer, Integer> expectedSpellsForPaladin = new HashMap<>();
        expectedSpellsForPaladin.put(1, 16);
        expectedSpellsForPaladin.put(2, 9);
        expectedSpellsForPaladin.put(3, 11);
        expectedSpellsForPaladin.put(4, 9);
        expectedNoOfSpells.put(PALADIN, expectedSpellsForPaladin);
        // Ranger
        Map<Integer, Integer> expectedSpellsForRanger = new HashMap<>();
        expectedSpellsForRanger.put(1, 19);
        expectedSpellsForRanger.put(2, 12);
        expectedSpellsForRanger.put(3, 13);
        expectedSpellsForRanger.put(4, 7);
        expectedNoOfSpells.put(RANGER, expectedSpellsForRanger);
        // Sorcerer
        Map<Integer, Integer> expectedSpellsForSorcerer = new HashMap<>();
        expectedSpellsForSorcerer.put(0, 20);
        expectedSpellsForSorcerer.put(1, 42);
        expectedSpellsForSorcerer.put(2, 51);
        expectedSpellsForSorcerer.put(3, 46);
        expectedSpellsForSorcerer.put(4, 41);
        expectedSpellsForSorcerer.put(5, 47);
        expectedSpellsForSorcerer.put(6, 46);
        expectedSpellsForSorcerer.put(7, 40);
        expectedSpellsForSorcerer.put(8, 37);
        expectedSpellsForSorcerer.put(9, 24);
        expectedNoOfSpells.put(SORCERER, expectedSpellsForSorcerer);
        // Wizard
        Map<Integer, Integer> expectedSpellsForWizard = new HashMap<>();
        expectedSpellsForWizard.put(0, 20);
        expectedSpellsForWizard.put(1, 42);
        expectedSpellsForWizard.put(2, 51);
        expectedSpellsForWizard.put(3, 46);
        expectedSpellsForWizard.put(4, 42);
        expectedSpellsForWizard.put(5, 47);
        expectedSpellsForWizard.put(6, 47);
        expectedSpellsForWizard.put(7, 40);
        expectedSpellsForWizard.put(8, 37);
        expectedSpellsForWizard.put(9, 24);
        expectedNoOfSpells.put(WIZARD, expectedSpellsForWizard);
        // Arcanist
        Map<Integer, Integer> expectedSpellsForArcanist = new HashMap<>();
        expectedSpellsForArcanist.put(0, 0);
        expectedSpellsForArcanist.put(1, 0);
        expectedSpellsForArcanist.put(2, 0);
        expectedSpellsForArcanist.put(3, 0);
        expectedSpellsForArcanist.put(4, 0);
        expectedSpellsForArcanist.put(5, 0);
        expectedSpellsForArcanist.put(6, 0);
        expectedSpellsForArcanist.put(7, 0);
        expectedSpellsForArcanist.put(8, 0);
        expectedSpellsForArcanist.put(9, 0);
        expectedNoOfSpells.put(ARCANIST, expectedSpellsForArcanist);
        // Bloodrager
        Map<Integer, Integer> expectedSpellsForBloodrager = new HashMap<>();
        expectedSpellsForBloodrager.put(1, 0);
        expectedSpellsForBloodrager.put(2, 0);
        expectedSpellsForBloodrager.put(3, 0);
        expectedSpellsForBloodrager.put(4, 0);
        expectedNoOfSpells.put(BLOODRAGER, expectedSpellsForBloodrager);
        // Hunter
        Map<Integer, Integer> expectedSpellsForHunter = new HashMap<>();
        expectedSpellsForHunter.put(0, 0);
        expectedSpellsForHunter.put(1, 0);
        expectedSpellsForHunter.put(2, 0);
        expectedSpellsForHunter.put(3, 0);
        expectedSpellsForHunter.put(4, 0);
        expectedSpellsForHunter.put(5, 0);
        expectedSpellsForHunter.put(6, 0);
        expectedNoOfSpells.put(HUNTER, expectedSpellsForHunter);
        // Investigator
        Map<Integer, Integer> expectedSpellsForInvestigator = new HashMap<>();
        expectedSpellsForInvestigator.put(1, 0);
        expectedSpellsForInvestigator.put(2, 0);
        expectedSpellsForInvestigator.put(3, 0);
        expectedSpellsForInvestigator.put(4, 0);
        expectedSpellsForInvestigator.put(5, 0);
        expectedSpellsForInvestigator.put(6, 0);
        expectedNoOfSpells.put(INVESTIGATOR, expectedSpellsForInvestigator);
        // Shaman
        Map<Integer, Integer> expectedSpellsForShaman = new HashMap<>();
        expectedSpellsForShaman.put(0, 0);
        expectedSpellsForShaman.put(1, 0);
        expectedSpellsForShaman.put(2, 0);
        expectedSpellsForShaman.put(3, 0);
        expectedSpellsForShaman.put(4, 0);
        expectedSpellsForShaman.put(5, 0);
        expectedSpellsForShaman.put(6, 0);
        expectedSpellsForShaman.put(7, 0);
        expectedSpellsForShaman.put(8, 0);
        expectedSpellsForShaman.put(9, 0);
        expectedNoOfSpells.put(SHAMAN, expectedSpellsForShaman);
        // Skald
        Map<Integer, Integer> expectedSpellsForSkald = new HashMap<>();
        expectedSpellsForSkald.put(0, 0);
        expectedSpellsForSkald.put(1, 0);
        expectedSpellsForSkald.put(2, 0);
        expectedSpellsForSkald.put(3, 0);
        expectedSpellsForSkald.put(4, 0);
        expectedSpellsForSkald.put(5, 0);
        expectedSpellsForSkald.put(6, 0);
        expectedNoOfSpells.put(SKALD, expectedSpellsForSkald);
        // Warpriest
        Map<Integer, Integer> expectedSpellsForWarpriest = new HashMap<>();
        expectedSpellsForWarpriest.put(0, 0);
        expectedSpellsForWarpriest.put(1, 0);
        expectedSpellsForWarpriest.put(2, 0);
        expectedSpellsForWarpriest.put(3, 0);
        expectedSpellsForWarpriest.put(4, 0);
        expectedSpellsForWarpriest.put(5, 0);
        expectedSpellsForWarpriest.put(6, 0);
        expectedNoOfSpells.put(WARPRIEST, expectedSpellsForWarpriest);
        // Antipaladin
        Map<Integer, Integer> expectedSpellsForAntipaladin = new HashMap<>();
        expectedSpellsForAntipaladin.put(1, 0);
        expectedSpellsForAntipaladin.put(2, 0);
        expectedSpellsForAntipaladin.put(3, 0);
        expectedSpellsForAntipaladin.put(4, 0);
        expectedNoOfSpells.put(ANTIPALADIN, expectedSpellsForAntipaladin);
        // Alchemist
        Map<Integer, Integer> expectedSpellsForAlchemist = new HashMap<>();
        expectedSpellsForAlchemist.put(1, 0);
        expectedSpellsForAlchemist.put(2, 0);
        expectedSpellsForAlchemist.put(3, 0);
        expectedSpellsForAlchemist.put(4, 0);
        expectedSpellsForAlchemist.put(5, 0);
        expectedSpellsForAlchemist.put(6, 0);
        expectedNoOfSpells.put(ALCHEMIST, expectedSpellsForAlchemist);
        // Inquisitor
        Map<Integer, Integer> expectedSpellsForInquisitor = new HashMap<>();
        expectedSpellsForInquisitor.put(0, 0);
        expectedSpellsForInquisitor.put(1, 0);
        expectedSpellsForInquisitor.put(2, 0);
        expectedSpellsForInquisitor.put(3, 0);
        expectedSpellsForInquisitor.put(4, 0);
        expectedSpellsForInquisitor.put(5, 0);
        expectedSpellsForInquisitor.put(6, 0);
        expectedNoOfSpells.put(INQUISITOR, expectedSpellsForInquisitor);
        // Oracle
        Map<Integer, Integer> expectedSpellsForOracle = new HashMap<>();
        expectedSpellsForOracle.put(0, 0);
        expectedSpellsForOracle.put(1, 0);
        expectedSpellsForOracle.put(2, 0);
        expectedSpellsForOracle.put(3, 0);
        expectedSpellsForOracle.put(4, 0);
        expectedSpellsForOracle.put(5, 0);
        expectedSpellsForOracle.put(6, 0);
        expectedSpellsForOracle.put(7, 0);
        expectedSpellsForOracle.put(8, 0);
        expectedSpellsForOracle.put(9, 0);
        expectedNoOfSpells.put(ORACLE, expectedSpellsForOracle);
        // Summoner
        Map<Integer, Integer> expectedSpellsForSummoner = new HashMap<>();
        expectedSpellsForSummoner.put(0, 0);
        expectedSpellsForSummoner.put(1, 0);
        expectedSpellsForSummoner.put(2, 0);
        expectedSpellsForSummoner.put(3, 0);
        expectedSpellsForSummoner.put(4, 0);
        expectedSpellsForSummoner.put(5, 0);
        expectedSpellsForSummoner.put(6, 0);
        expectedNoOfSpells.put(SUMMONER, expectedSpellsForSummoner);
        // Witch
        Map<Integer, Integer> expectedSpellsForWitch = new HashMap<>();
        expectedSpellsForWitch.put(0, 0);
        expectedSpellsForWitch.put(1, 0);
        expectedSpellsForWitch.put(2, 0);
        expectedSpellsForWitch.put(3, 0);
        expectedSpellsForWitch.put(4, 0);
        expectedSpellsForWitch.put(5, 0);
        expectedSpellsForWitch.put(6, 0);
        expectedSpellsForWitch.put(7, 0);
        expectedSpellsForWitch.put(8, 0);
        expectedSpellsForWitch.put(9, 0);
        expectedNoOfSpells.put(WITCH, expectedSpellsForWitch);
        // Magus
        Map<Integer, Integer> expectedSpellsForMagus = new HashMap<>();
        expectedSpellsForMagus.put(0, 0);
        expectedSpellsForMagus.put(1, 0);
        expectedSpellsForMagus.put(2, 0);
        expectedSpellsForMagus.put(3, 0);
        expectedSpellsForMagus.put(4, 0);
        expectedSpellsForMagus.put(5, 0);
        expectedSpellsForMagus.put(6, 0);
        expectedNoOfSpells.put(MAGUS, expectedSpellsForMagus);
    }

    public int getExpectedNoOfSpells(Class clazz, Integer level) {
        return expectedNoOfSpells.get(clazz).get(level);
    }

    public Map<Class, Map<Integer, List<URL>>> prepareResults() {
        Map<Class, Map<Integer, List<URL>>> results = new HashMap<>();
        expectedNoOfSpells.keySet().forEach(clazz -> results.putIfAbsent(clazz, prepareResults(clazz)));
        return results;
    }

    private Map<Integer, List<URL>> prepareResults(Class clazz) {
        Map<Integer, List<URL>> results = new HashMap<>();
        expectedNoOfSpells.get(clazz).keySet().forEach(level -> results.putIfAbsent(level, new ArrayList<>()));
        return results;
    }
}