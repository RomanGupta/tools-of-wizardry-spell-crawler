package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import java.util.Arrays;

public enum Class {
    // Core Rule Book
    BARBARIAN,
    BARD,
    CLERIC,
    DRUID,
    FIGHTER,
    MONK,
    PALADIN,
    RANGER,
    ROGUE,
    SORCERER,
    WIZARD,
    // Advanced Class Guide
    ARCANIST,
    BLOODRAGER,
    BRAWLER,
    HUNTER,
    INVESTIGATOR,
    SHAMAN,
    SKALD,
    SLAYER,
    SWASHBUCKLER,
    WARPRIEST,
    // Advanced Players Guide
    ANTIPALADIN,
    ALCHEMIST,
    CAVALIER,
    INQUISITOR,
    ORACLE,
    SUMMONER,
    WITCH,
    // Ultimate Magic
    MAGUS;

    public static Class convert(String text) {
        if(null != text) {
            return Arrays.stream(values())
                    .filter(clazz -> clazz.name().equals(text.toUpperCase()))
                    .findAny()
                    .orElse(null);
        }
        return null;

    }
}
