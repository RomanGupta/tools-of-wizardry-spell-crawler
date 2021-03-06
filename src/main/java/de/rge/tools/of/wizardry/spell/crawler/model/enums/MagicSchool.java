package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static MagicSchool convert(String text) {
        if (null != text) {
            return Arrays.stream(values())
                    .filter(school -> school.name().equals(text.toUpperCase()))
                    .findAny()
                    .orElse(null);
        }
        return null;

    }
}
