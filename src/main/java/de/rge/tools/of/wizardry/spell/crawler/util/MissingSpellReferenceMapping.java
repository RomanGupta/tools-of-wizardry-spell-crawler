package de.rge.tools.of.wizardry.spell.crawler.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class MissingSpellReferenceMapping {
    private static final Logger log = LoggerFactory.getLogger(MissingSpellReferenceMapping.class);

    private static Map<URL, URL> SPELL_TO_SPELL_REFERENCE = new HashMap<>();

    static {
        // Core Rule Book
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/charmAnimal.html#charm-animal",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/charmPerson.html#charm-person");
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureCriticalWounds.html#cure-critical-wounds-mass",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureLightWounds.html#cure-light-wounds-mass");
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureModerateWounds.html#cure-moderate-wounds-mass",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureLightWounds.html#cure-light-wounds-mass");
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureSeriousWounds.html#cure-serious-wounds-mass",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/cureLightWounds.html#cure-light-wounds-mass");
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/inflictModerateWounds.html#inflict-moderate-wounds-mass",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/inflictLightWounds.html#inflict-light-wounds-mass");
        addMapping("http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/inflictSeriousWounds.html#inflict-serious-wounds-mass",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/inflictLightWounds.html#inflict-light-wounds-mass");
        // Advanced Class Guide
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/aggressiveThundercloud.html#aggressive-thundercloud-greater",
                "http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/aggressiveThundercloud.html");
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/sickeningEntanglement.html",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/entangle.html#entangle");
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/spellcrash.html",
                "http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/spellcrash.html#spellcrash-lesser");
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/stunningBarrier.html#stunning-barrier-greater",
                "http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/stunningBarrier.html");
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedClassGuide/spells/triggeredSuggestion.html",
                "http://paizo.com/pathfinderRPG/prd/coreRulebook/spells/suggestion.html#suggestion");
        // Advanced Player's Guide
        addMapping("http://paizo.com/pathfinderRPG/prd/advancedPlayersGuide/spells/suffocation.html#suffocation,-mass",
                "http://paizo.com/pathfinderRPG/prd/advancedPlayersGuide/spells/suffocation.html#suffocation");
        // Ultimate Magic
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/atavism.html#atavism,-mass",
                "http://paizo.com/pathfinderRPG/prd/advancedPlayersGuide/spells/suffocation.html#suffocation");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/forbidAction.html#forbid-action,-greater",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/forbidAction.html#forbid-action");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/icyPrison.html#icy-prison,-mass",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/icyPrison.html#icy-prison");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/interrogation.html#interrogation,-greater",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/interrogation.html#interrogation");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-ii",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-i");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-iii",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-ii");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-iv",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/monstrousPhysique.html#monstrous-physique-iii");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-ii",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-i");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-iii",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-ii");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-iv",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/undeadAnatomy.html#undead-anatomy-iii");
        addMapping("http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/verminShape.html#vermin-shape-ii",
                "http://paizo.com/pathfinderRPG/prd/ultimateMagic/spells/verminShape.html#vermin-shape-i-");
    }

    private static void addMapping(String spell, String spellReference) {
        try {
            SPELL_TO_SPELL_REFERENCE.put(new URL(spell), new URL(spellReference));
        } catch (MalformedURLException e) {
            log.error("url for spell {} or spell reference {} is malformed:\n{}", spell, spellReference, e);
        }
    }

    public static URL getReferenceUrl(URL spellURL) {
        return SPELL_TO_SPELL_REFERENCE.get(spellURL);
    }
}
