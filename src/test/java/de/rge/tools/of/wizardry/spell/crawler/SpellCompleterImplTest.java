package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCompleterImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellContext;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Class.SORCERER;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Class.WIZARD;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.COLD;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.Connector.OR;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor.FIRE;
import static de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool.EVOCATION;
import static org.assertj.core.api.Assertions.assertThat;

public class SpellCompleterImplTest {

    private static final String SPELL_NAME_FIRE_SHIELD_ORIGIN = "Fire Shield (orig)";
    private static final String SPELL_NAME_FIRE_SHIELD = "Fire Shield";

    @Test
    public void completeSpellWithReferences_isComplete(){
        SpellContext target = createCompleteSpell(SPELL_NAME_FIRE_SHIELD_ORIGIN);
        new SpellCompleterImpl(target).completeSpellWithReferences();
        assertCompletedSpell(target.getSpell());
    }
    @Test
    public void completeSpellWithReferences_firstReference(){
        SpellContext spellReference = createCompleteSpell(SPELL_NAME_FIRE_SHIELD);
        SpellContext target = createSpellWithReferences(SPELL_NAME_FIRE_SHIELD_ORIGIN, spellReference);
        new SpellCompleterImpl(target).completeSpellWithReferences();
        assertCompletedSpell(target.getSpell());
    }

    @Test
    public void completeSpellWithReferences_secondReference(){
        SpellContext spellReference1 = new SpellContext(Collections.emptyList(), Collections.emptyList());
        SpellContext spellReference2 = createCompleteSpell(SPELL_NAME_FIRE_SHIELD);
        SpellContext target = createSpellWithReferences(SPELL_NAME_FIRE_SHIELD_ORIGIN, spellReference1, spellReference2);
        new SpellCompleterImpl(target).completeSpellWithReferences();
        assertCompletedSpell(target.getSpell());
    }

    @Test
    public void completeSpellWithReferences_referenceDepth2(){
        SpellContext spellReference2 = createCompleteSpell(SPELL_NAME_FIRE_SHIELD);
        SpellContext spellReference1 = createSpellWithReferences(null, spellReference2);
        SpellContext target = createSpellWithReferences(SPELL_NAME_FIRE_SHIELD_ORIGIN, spellReference1);
        new SpellCompleterImpl(target).completeSpellWithReferences();
        assertCompletedSpell(target.getSpell());
    }

    private SpellContext createCompleteSpell(String name) {
        SpellContext spellReference = new SpellContext(Collections.emptyList(), Collections.emptyList());
        spellReference.getSpell().setName(name);
        spellReference.getSpell().setSchool(EVOCATION);
        spellReference.getSpell().setDescriptors(Arrays.asList(FIRE, COLD));
        spellReference.getSpell().setDescriptorsConnector(OR);
        spellReference.getSpell().getLevelPerClass().put(SORCERER, 4);
        spellReference.getSpell().getLevelPerClass().put(WIZARD, 4);
        return spellReference;
    }

    private SpellContext createSpellWithReferences(String name, SpellContext... spellReferences) {
        SpellContext spellContext = new SpellContext(Collections.emptyList(), Arrays.asList(spellReferences));
        spellContext.getSpell().setName(name);
        return spellContext;
    }

    private void assertCompletedSpell(Spell spell) {
        assertThat(spell.getName()).isEqualTo(SPELL_NAME_FIRE_SHIELD_ORIGIN);
        assertThat(spell.getSchool()).isEqualTo(EVOCATION);
        assertThat(spell.getSubschool()).isEqualTo(null);
        assertThat(spell.getDescriptors()).containsExactly(FIRE, COLD);
        assertThat(spell.getDescriptorsConnector()).isEqualTo(OR);
        assertThat(spell.getLevelPerClass()).containsKeys(SORCERER, WIZARD);
        assertThat(spell.getLevelPerClass()).containsValues(4, 4);
    }
}
