package de.rge.tools.of.wizardry.spell.crawler.expected;

import de.rge.tools.of.wizardry.spell.crawler.model.enums.Class;

import java.net.URL;
import java.util.List;
import java.util.Map;

public interface ExpectedNoOfSpellsPerClassAndLevelForSource {
    int getExpectedNoOfSpells(Class clazz, Integer level);

    Map<Class, Map<Integer, List<URL>>> prepareResults();
}
