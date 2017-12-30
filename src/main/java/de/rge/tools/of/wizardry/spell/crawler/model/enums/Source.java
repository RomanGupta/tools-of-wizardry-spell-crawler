package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import de.rge.tools.of.wizardry.spell.crawler.Config;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

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

    public URL readSourceUrl() {
        try (InputStream is = getClass().getResourceAsStream(Config.CONFIG_PROPERTIES.getValue())) {
            Properties props = new Properties();
            props.load(is);
            return new URL(props.getProperty(this.getUrlKey()));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("error while reading properties", ioe);
        }
    }

}
