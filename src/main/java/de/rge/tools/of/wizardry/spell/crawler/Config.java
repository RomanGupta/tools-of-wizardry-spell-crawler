package de.rge.tools.of.wizardry.spell.crawler;

public enum Config {
    BASE_PACKAGE("/de/rge/tools/of/wizardry/spell/crawler/"),
    CONFIG_PROPERTIES(BASE_PACKAGE.getValue() + "config.properties");

    private String value;

    Config(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
