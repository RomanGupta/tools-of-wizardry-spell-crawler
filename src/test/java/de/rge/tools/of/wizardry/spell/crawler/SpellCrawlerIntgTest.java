package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static de.rge.tools.of.wizardry.spell.crawler.model.enums.Source.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SpellCrawlerIntgTest {

    @Parameters
    public static Iterable<Object[]> params() {
        return Arrays.asList(new Object[][]{
                        // -- Core Rule Book
                        {SPELLS_CORE_RULEBOOK, "[a]", 30},
                        {SPELLS_CORE_RULEBOOK, "[b]", 28},
                        {SPELLS_CORE_RULEBOOK, "[c]", 59},
                        {SPELLS_CORE_RULEBOOK, "[d]", 55},
                        {SPELLS_CORE_RULEBOOK, "[e]", 22},
                        {SPELLS_CORE_RULEBOOK, "[f]", 36},
                        {SPELLS_CORE_RULEBOOK, "[g]", 23},
                        {SPELLS_CORE_RULEBOOK, "[h]", 29},
                        {SPELLS_CORE_RULEBOOK, "[i]", 28},
                        {SPELLS_CORE_RULEBOOK, "[j]", 1},
                        {SPELLS_CORE_RULEBOOK, "[k]", 3},
                        {SPELLS_CORE_RULEBOOK, "[l]", 10},
                        {SPELLS_CORE_RULEBOOK, "[m]", 45},
                        {SPELLS_CORE_RULEBOOK, "[n]", 3},
                        {SPELLS_CORE_RULEBOOK, "[o]", 7},
                        {SPELLS_CORE_RULEBOOK, "[p]", 47},
                        {SPELLS_CORE_RULEBOOK, "[q]", 1},
                        {SPELLS_CORE_RULEBOOK, "[r]", 33},
                        {SPELLS_CORE_RULEBOOK, "[s]", 104},
                        {SPELLS_CORE_RULEBOOK, "[t]", 24},
                        {SPELLS_CORE_RULEBOOK, "[u]", 6},
                        {SPELLS_CORE_RULEBOOK, "[v]", 5},
                        {SPELLS_CORE_RULEBOOK, "[w]", 22},
                        {SPELLS_CORE_RULEBOOK, "[x]", 0},
                        {SPELLS_CORE_RULEBOOK, "[y]", 0},
                        {SPELLS_CORE_RULEBOOK, "[z]", 2},
                        // -- Advanced Class Guide
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[a]", 15},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[b]", 14},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[c]", 8},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[d]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[e]", 5},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[f]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[g]", 3},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[h]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[i]", 2},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[j]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[k]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[l]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[m]", 12},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[n]", 2},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[o]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[p]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[q]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[r]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[s]", 20},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[t]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[u]", 3},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[v]", 1},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[w]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[x]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[y]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[z]", 0},
                        // -- Advanced Players Guide
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[a]", 16},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[b]", 23},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[c]", 25},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[d]", 16},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[e]", 13},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[f]", 22},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[g]", 10},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[h]", 11},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[i]", 6},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[j]", 1},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[k]", 3},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[l]", 5},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[m]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[n]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[o]", 2},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[p]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[q]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[r]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[s]", 36},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[t]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[u]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[v]", 6},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[w]", 10},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[x]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[y]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[z]", 0},
                        // -- Ultimate Magic
                        {SPELLS_ULTIMATE_MAGIC, "[a]", 19},
                        {SPELLS_ULTIMATE_MAGIC, "[b]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[c]", 23},
                        {SPELLS_ULTIMATE_MAGIC, "[d]", 15},
                        {SPELLS_ULTIMATE_MAGIC, "[e]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[f]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[g]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[h]", 7},
                        {SPELLS_ULTIMATE_MAGIC, "[i]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[j]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[k]", 4},
                        {SPELLS_ULTIMATE_MAGIC, "[l]", 6},
                        {SPELLS_ULTIMATE_MAGIC, "[m]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[n]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[o]", 5},
                        {SPELLS_ULTIMATE_MAGIC, "[p]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[q]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[r]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[s]", 34},
                        {SPELLS_ULTIMATE_MAGIC, "[t]", 6},
                        {SPELLS_ULTIMATE_MAGIC, "[u]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[v]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[w]", 7},
                        {SPELLS_ULTIMATE_MAGIC, "[x]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[y]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[z]", 0}
                }
        );
    }

    private final Source source;
    private final String startingLetterPattern;
    private final int expectedNoOfSpells;

    private SpellCrawler sut = new SpellCrawlerImpl();

    public SpellCrawlerIntgTest(Source source, String startingLetterPattern, int expectedNoOfSpells) {
        this.source = source;
        this.startingLetterPattern = startingLetterPattern;
        this.expectedNoOfSpells = expectedNoOfSpells;
    }

    @Test
    public void determineAllSpellUrls_coreRuleBook_startingLettersAToZ() {
        assertThat(sut.determineAllSpellUrls(source, startingLetterPattern))
                .as(source.name() + " at " + startingLetterPattern)
                .hasSize(expectedNoOfSpells);
    }

}
