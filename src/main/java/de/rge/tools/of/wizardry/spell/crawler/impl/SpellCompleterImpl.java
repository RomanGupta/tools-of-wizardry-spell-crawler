package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.model.Spell;

import java.util.List;

public class SpellCompleterImpl {
    private SpellContext target;

    public SpellCompleterImpl(SpellContext target) {
        this.target = target;
    }

    public void completeSpellWithReferences() {
        completeSpellWith(target.getSpellReferences());
    }

    private void completeSpellWith(List<SpellContext> spellReferences) {
        for (SpellContext spellReference : spellReferences) {
            if (target.getSpell().isComplete()) {
                break;
            }
            completeSpellWith(spellReference);
            completeSpellWith(spellReference.getSpellReferences());
        }
    }

    private void completeSpellWith(SpellContext spellReference) {
        // never set the name
        completeSchoolDetails(spellReference.getSpell());
        completeLevelDetails(spellReference.getSpell());
    }

    private void completeSchoolDetails(Spell spellReference) {
        Spell spell = target.getSpell();
        if(null == spell.getSchool()) {
            spell.setSchool(spellReference.getSchool());
            spell.setSubschool(spellReference.getSubschool());
            spell.setDescriptors(spellReference.getDescriptors());
            spell.setDescriptorsConnector(spellReference.getDescriptorsConnector());
        }
    }

    private void completeLevelDetails(Spell spellReference) {
        Spell spell = target.getSpell();
        if(spell.getLevelPerClass().isEmpty()) {
            spellReference.getLevelPerClass().forEach(spell::addLevelPerClass);
        }
    }
}
