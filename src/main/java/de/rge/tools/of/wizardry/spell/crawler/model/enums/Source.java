package de.rge.tools.of.wizardry.spell.crawler.model.enums;

public enum Source {
    SPELLS_CORE_RULEBOOK("spellsCoreRulebookUrl"),
    SPELLS_ADVANCED_CLASS_GUIDE("spellsAdvancedClassGuide"),
    SPELLS_ADVANCED_PLAYERS_GUIDE("spellsAdvancedPlayersGuide"),
    SPELLS_ULTIMATE_MAGIC("spellsUltimateMagic");

    private String urlKey;

    Source(String urlKey) {
        this.urlKey = urlKey;
    }

    public String getUrlKey() {
        return urlKey;
    }
}
