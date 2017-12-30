package de.rge.tools.of.wizardry.spell.crawler.expected;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.Class;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Class.*;

public class ExpectedNoOfSpellsPerClassAndLevelForUltimateMagic implements ExpectedNoOfSpellsPerClassAndLevelForSource {
    private final Map<Class, Map<Integer, Integer>> expectedNoOfSpells = new HashMap<>();

    {
        // Invalid class and/or level
        Map<Integer, Integer> expectedSpellsForInvalid = new HashMap<>();
        expectedSpellsForInvalid.putIfAbsent(null, 0);
        expectedNoOfSpells.put(null, expectedSpellsForInvalid);
        // Bard
        Map<Integer, Integer> expectedSpellsForBard = new HashMap<>();
        expectedSpellsForBard.put(0, 0);
        expectedSpellsForBard.put(1, 14);
        expectedSpellsForBard.put(2, 22);
        expectedSpellsForBard.put(3, 12);
        expectedSpellsForBard.put(4, 11);
        expectedSpellsForBard.put(5, 5);
        expectedSpellsForBard.put(6, 3);
        expectedNoOfSpells.put(BARD, expectedSpellsForBard);
        // Cleric
        Map<Integer, Integer> expectedSpellsForCleric = new HashMap<>();
        expectedSpellsForCleric.put(0, 0);
        expectedSpellsForCleric.put(1, 10);
        expectedSpellsForCleric.put(2, 13);
        expectedSpellsForCleric.put(3, 8);
        expectedSpellsForCleric.put(4, 11);
        expectedSpellsForCleric.put(5, 12);
        expectedSpellsForCleric.put(6, 5);
        expectedSpellsForCleric.put(7, 5);
        expectedSpellsForCleric.put(8, 3);
        expectedSpellsForCleric.put(9, 8);
        expectedNoOfSpells.put(CLERIC, expectedSpellsForCleric);
        // Druid
        Map<Integer, Integer> expectedSpellsForDruid = new HashMap<>();
        expectedSpellsForDruid.put(0, 0);
        expectedSpellsForDruid.put(1, 7);
        expectedSpellsForDruid.put(2, 7);
        expectedSpellsForDruid.put(3, 10);
        expectedSpellsForDruid.put(4, 10);
        expectedSpellsForDruid.put(5, 4);
        expectedSpellsForDruid.put(6, 4);
        expectedSpellsForDruid.put(7, 2);
        expectedSpellsForDruid.put(8, 2);
        expectedSpellsForDruid.put(9, 3);
        expectedNoOfSpells.put(DRUID, expectedSpellsForDruid);
        // Paladin
        Map<Integer, Integer> expectedSpellsForPaladin = new HashMap<>();
        expectedSpellsForPaladin.put(1, 6);
        expectedSpellsForPaladin.put(2, 3);
        expectedSpellsForPaladin.put(3, 3);
        expectedSpellsForPaladin.put(4, 4);
        expectedNoOfSpells.put(PALADIN, expectedSpellsForPaladin);
        // Ranger
        Map<Integer, Integer> expectedSpellsForRanger = new HashMap<>();
        expectedSpellsForRanger.put(1, 6);
        expectedSpellsForRanger.put(2, 3);
        expectedSpellsForRanger.put(3, 3);
        expectedSpellsForRanger.put(4, 2);
        expectedNoOfSpells.put(RANGER, expectedSpellsForRanger);
        // Sorcerer
        Map<Integer, Integer> expectedSpellsForSorcerer = new HashMap<>();
        expectedSpellsForSorcerer.put(0, 0);
        expectedSpellsForSorcerer.put(1, 19);
        expectedSpellsForSorcerer.put(2, 25);
        expectedSpellsForSorcerer.put(3, 24);
        expectedSpellsForSorcerer.put(4, 23);
        expectedSpellsForSorcerer.put(5, 20);
        expectedSpellsForSorcerer.put(6, 15);
        expectedSpellsForSorcerer.put(7, 15);
        expectedSpellsForSorcerer.put(8, 5);
        expectedSpellsForSorcerer.put(9, 10);
        expectedNoOfSpells.put(SORCERER, expectedSpellsForSorcerer);
        // Wizard
        Map<Integer, Integer> expectedSpellsForWizard = new HashMap<>();
        expectedSpellsForWizard.put(0, 0);
        expectedSpellsForWizard.put(1, 19);
        expectedSpellsForWizard.put(2, 26);
        expectedSpellsForWizard.put(3, 24);
        expectedSpellsForWizard.put(4, 23);
        expectedSpellsForWizard.put(5, 20);
        expectedSpellsForWizard.put(6, 15);
        expectedSpellsForWizard.put(7, 15);
        expectedSpellsForWizard.put(8, 5);
        expectedSpellsForWizard.put(9, 10);
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
        expectedSpellsForAntipaladin.put(1, 3);
        expectedSpellsForAntipaladin.put(2, 4);
        expectedSpellsForAntipaladin.put(3, 2);
        expectedSpellsForAntipaladin.put(4, 2);
        expectedNoOfSpells.put(ANTIPALADIN, expectedSpellsForAntipaladin);
        // Alchemist
        Map<Integer, Integer> expectedSpellsForAlchemist = new HashMap<>();
        expectedSpellsForAlchemist.put(1, 4);
        expectedSpellsForAlchemist.put(2, 5);
        expectedSpellsForAlchemist.put(3, 7);
        expectedSpellsForAlchemist.put(4, 8);
        expectedSpellsForAlchemist.put(5, 4);
        expectedSpellsForAlchemist.put(6, 2);
        expectedNoOfSpells.put(ALCHEMIST, expectedSpellsForAlchemist);
        // Inquisitor
        Map<Integer, Integer> expectedSpellsForInquisitor = new HashMap<>();
        expectedSpellsForInquisitor.put(0, 0);
        expectedSpellsForInquisitor.put(1, 12);
        expectedSpellsForInquisitor.put(2, 7);
        expectedSpellsForInquisitor.put(3, 5);
        expectedSpellsForInquisitor.put(4, 7);
        expectedSpellsForInquisitor.put(5, 3);
        expectedSpellsForInquisitor.put(6, 1);
        expectedNoOfSpells.put(INQUISITOR, expectedSpellsForInquisitor);
        // Oracle
        Map<Integer, Integer> expectedSpellsForOracle = new HashMap<>();
        expectedSpellsForOracle.put(0, 0);
        expectedSpellsForOracle.put(1, 0);
        expectedSpellsForOracle.put(2, 0);
        expectedSpellsForOracle.put(3, 0);
        expectedSpellsForOracle.put(4, 1);
        expectedSpellsForOracle.put(5, 0);
        expectedSpellsForOracle.put(6, 0);
        expectedSpellsForOracle.put(7, 0);
        expectedSpellsForOracle.put(8, 0);
        expectedSpellsForOracle.put(9, 0);
        expectedNoOfSpells.put(ORACLE, expectedSpellsForOracle);
        // Summoner
        Map<Integer, Integer> expectedSpellsForSummoner = new HashMap<>();
        expectedSpellsForSummoner.put(0, 0);
        expectedSpellsForSummoner.put(1, 4);
        expectedSpellsForSummoner.put(2, 3);
        expectedSpellsForSummoner.put(3, 6);
        expectedSpellsForSummoner.put(4, 2);
        expectedSpellsForSummoner.put(5, 3);
        expectedSpellsForSummoner.put(6, 2);
        expectedNoOfSpells.put(SUMMONER, expectedSpellsForSummoner);
        // Witch
        Map<Integer, Integer> expectedSpellsForWitch = new HashMap<>();
        expectedSpellsForWitch.put(0, 0);
        expectedSpellsForWitch.put(1, 21);
        expectedSpellsForWitch.put(2, 19);
        expectedSpellsForWitch.put(3, 20);
        expectedSpellsForWitch.put(4, 15);
        expectedSpellsForWitch.put(5, 7);
        expectedSpellsForWitch.put(6, 6);
        expectedSpellsForWitch.put(7, 7);
        expectedSpellsForWitch.put(8, 2);
        expectedSpellsForWitch.put(9, 5);
        expectedNoOfSpells.put(WITCH, expectedSpellsForWitch);
        // Magus
        Map<Integer, Integer> expectedSpellsForMagus = new HashMap<>();
        expectedSpellsForMagus.put(0, 0);
        expectedSpellsForMagus.put(1, 2);
        expectedSpellsForMagus.put(2, 3);
        expectedSpellsForMagus.put(3, 4);
        expectedSpellsForMagus.put(4, 4);
        expectedSpellsForMagus.put(5, 5);
        expectedSpellsForMagus.put(6, 2);
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
