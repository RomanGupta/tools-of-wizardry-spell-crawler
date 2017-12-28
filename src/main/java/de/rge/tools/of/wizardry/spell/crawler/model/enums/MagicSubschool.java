package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import java.util.Arrays;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool.*;

public enum MagicSubschool {
    CALLING(CONJURATION),
    CREATION(CONJURATION),
    HEALING(CONJURATION),
    SUMMONING(CONJURATION),
    TELEPORTATION(CONJURATION),
    SCRYING(DIVINATION),
    CHARM(ENCHANTMENT),
    COMPULSION(ENCHANTMENT),
    FIGMENT(ILLUSION),
    GLAMER(ILLUSION),
    PATTERN(ILLUSION),
    PHANTASM(ILLUSION),
    SHADOW(ILLUSION),
    POLYMORPH(TRANSMUTATION);

    private MagicSchool superSchool;

    MagicSubschool(MagicSchool superSchool) {
        this.superSchool = superSchool;
    }

    public static MagicSubschool convert(String text) {
        if(null != text) {
            return Arrays.stream(values())
                    .filter(subschool -> subschool.name().equals(text.toUpperCase()))
                    .findAny()
                    .orElse(null);
        }
        return null;

    }

    public static boolean isValidSubschool(String text) {
        return null != convert(text);
    }
}
