package de.rge.tools.of.wizardry.spell.crawler.model.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MagicDescriptor {
    // Core Rule Book
    ACID,
    AIR,
    CHAOTIC,
    COLD,
    DARKNESS,
    DEATH,
    EARTH,
    ELECTRICITY,
    EVIL,
    FEAR,
    FIRE,
    FORCE,
    GOOD,
    LANGUAGE_DEPENDENT,
    LAWFUL,
    LIGHT,
    MIND_AFFECTING,
    SONIC,
    WATER,
    // Ultimate Magic
    CURSE,
    DISEASE,
    EMOTION,
    PAIN,
    POISON,
    SHADOW,
    // see text
    SEE_TEXT;

    public enum Connector {
        AND, OR;

        public static List<Connector> getValueListWithNull() {
            List<Connector> connectors = new ArrayList<>(Arrays.asList(values()));
            connectors.add(0, null);
            return connectors;
        }
    }


    public static MagicDescriptor convert(String text) {
        if(null != text) {
            String polished = text.toUpperCase().replaceAll("[- ]", "_");
            return Arrays.stream(values())
                    .filter(descriptor -> matchesDescriptor(descriptor, polished))
                    .findAny()
                    .orElse(null);
        }
        return null;

    }

    private static boolean matchesDescriptor(MagicDescriptor descriptor, String polished) {
        return descriptor.name().equals(polished) || (descriptor.equals(SEE_TEXT) && polished.startsWith(SEE_TEXT.name()));
    }

    public static boolean isValidDescriptor(String text) {
        return null != convert(text);
    }

    public static List<MagicDescriptor> getValueListWithNull() {
        List<MagicDescriptor> magicDescriptors = new ArrayList<>(Arrays.asList(values()));
        magicDescriptors.add(0, null);
        return magicDescriptors;
    }
}
