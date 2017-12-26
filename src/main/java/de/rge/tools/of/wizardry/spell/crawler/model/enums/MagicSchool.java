package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import java.util.Arrays;

public enum MagicSchool {
    ABJURATION,
    CONJURATION,
    DIVINATION,
    ENCHANTMENT,
    EVOCATION,
    ILLUSION,
    NECROMANCY,
    TRANSMUTATION,
    UNIVERSAL;

    public static boolean isValidSchool(String text) {
        if(null == text) {
            return false;
        }
        return Arrays.stream(values())
                .map(MagicSchool::name)
                .anyMatch(school -> school.equals(text.toUpperCase()));
    }
}
