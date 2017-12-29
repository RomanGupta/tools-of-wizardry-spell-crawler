package de.rge.tools.of.wizardry.spell.crawler.expected;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.Class;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.*;

public class ExpectedNoOfSpellsPerClassAndLevel {
    private static final Map<Source, ExpectedNoOfSpellsPerClassAndLevelForSource> expectedNoOfSpells = new HashMap<>();

    static {
        expectedNoOfSpells.put(SPELLS_CORE_RULEBOOK, new ExpectedNoOfSpellsPerClassAndLevelForCoreRuleBook());
        expectedNoOfSpells.put(SPELLS_ADVANCED_CLASS_GUIDE, new ExpectedNoOfSpellsPerClassAndLevelForAdvancedClassGuide());
        expectedNoOfSpells.put(SPELLS_ADVANCED_PLAYERS_GUIDE, new ExpectedNoOfSpellsPerClassAndLevelForAdvancedPlayersGuide());
        expectedNoOfSpells.put(SPELLS_ULTIMATE_MAGIC, new ExpectedNoOfSpellsPerClassAndLevelForUltimateMagic());
    }

    public static int getExpectedNoOfSpells(Source source, Class clazz, Integer level) {
        return expectedNoOfSpells.get(source).getExpectedNoOfSpells(clazz, level);
    }

    public static Map<Class, Map<Integer, List<URL>>> prepareResults(Source source) {
        return expectedNoOfSpells.get(source).prepareResults();
    }
}
