package de.rge.tools.of.wizardry.spell.crawler;

import java.util.HashMap;
import java.util.Map;

import static de.rge.tools.of.wizardry.spell.crawler.UrlMarker.Marker.IGNORE;

public class UrlMarker {
    public enum Marker {IGNORE}

    private static final Map<String, Marker> URL_TO_MARKER = new HashMap<>();
    static {
        URL_TO_MARKER.put("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/greaterSpellName.html", IGNORE);
        URL_TO_MARKER.put("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/lesserSpellName.html", IGNORE);
        URL_TO_MARKER.put("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/massSpellName.html", IGNORE);
    }

    public static boolean isIgnored(String url) {
        return IGNORE.equals(URL_TO_MARKER.get(url));
    }
}
