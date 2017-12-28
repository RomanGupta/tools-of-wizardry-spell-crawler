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
public class SpellCrawlerTest {

    @Parameters
    public static Iterable<Object[]> params() {
        return Arrays.asList(new Object[][]{
                        // -- Core Rule Book
                        {SPELLS_CORE_RULEBOOK, "[A]", 30},
                        {SPELLS_CORE_RULEBOOK, "[B]", 28},
                        {SPELLS_CORE_RULEBOOK, "[C]", 59},
                        {SPELLS_CORE_RULEBOOK, "[D]", 55},
                        {SPELLS_CORE_RULEBOOK, "[E]", 22},
                        {SPELLS_CORE_RULEBOOK, "[F]", 36},
                        {SPELLS_CORE_RULEBOOK, "[G]", 23},
                        {SPELLS_CORE_RULEBOOK, "[H]", 29},
                        {SPELLS_CORE_RULEBOOK, "[I]", 28},
                        {SPELLS_CORE_RULEBOOK, "[J]", 1},
                        {SPELLS_CORE_RULEBOOK, "[K]", 3},
                        {SPELLS_CORE_RULEBOOK, "[L]", 10},
                        {SPELLS_CORE_RULEBOOK, "[M]", 45},
                        {SPELLS_CORE_RULEBOOK, "[N]", 3},
                        {SPELLS_CORE_RULEBOOK, "[O]", 7},
                        {SPELLS_CORE_RULEBOOK, "[P]", 47},
                        {SPELLS_CORE_RULEBOOK, "[Q]", 1},
                        {SPELLS_CORE_RULEBOOK, "[R]", 33},
                        {SPELLS_CORE_RULEBOOK, "[S]", 104},
                        {SPELLS_CORE_RULEBOOK, "[T]", 24},
                        {SPELLS_CORE_RULEBOOK, "[U]", 6},
                        {SPELLS_CORE_RULEBOOK, "[V]", 5},
                        {SPELLS_CORE_RULEBOOK, "[W]", 22},
                        {SPELLS_CORE_RULEBOOK, "[X]", 0},
                        {SPELLS_CORE_RULEBOOK, "[Y]", 0},
                        {SPELLS_CORE_RULEBOOK, "[Z]", 2},
                        // -- Advanced Class Guide
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[A]", 15},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[B]", 14},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[C]", 8},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[D]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[E]", 5},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[F]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[G]", 3},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[H]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[I]", 2},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[J]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[K]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[L]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[M]", 12},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[N]", 2},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[O]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[P]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[Q]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[R]", 4},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[S]", 20},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[T]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[U]", 3},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[V]", 1},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[W]", 7},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[X]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[Y]", 0},
                        {SPELLS_ADVANCED_CLASS_GUIDE, "[Z]", 0},
                        // -- Advanced Players Guide
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[A]", 16},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[B]", 23},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[C]", 25},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[D]", 16},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[E]", 13},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[F]", 22},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[G]", 10},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[H]", 11},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[I]", 6},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[J]", 1},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[K]", 3},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[L]", 5},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[M]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[N]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[O]", 2},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[P]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[Q]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[R]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[S]", 36},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[T]", 15},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[U]", 4},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[V]", 6},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[W]", 10},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[X]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[Y]", 0},
                        {SPELLS_ADVANCED_PLAYERS_GUIDE, "[Z]", 0},
                        // -- Ultimate Magic
                        {SPELLS_ULTIMATE_MAGIC, "[A]", 19},
                        {SPELLS_ULTIMATE_MAGIC, "[B]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[C]", 23},
                        {SPELLS_ULTIMATE_MAGIC, "[D]", 15},
                        {SPELLS_ULTIMATE_MAGIC, "[E]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[F]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[G]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[H]", 7},
                        {SPELLS_ULTIMATE_MAGIC, "[I]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[J]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[K]", 4},
                        {SPELLS_ULTIMATE_MAGIC, "[L]", 6},
                        {SPELLS_ULTIMATE_MAGIC, "[M]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[N]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[O]", 5},
                        {SPELLS_ULTIMATE_MAGIC, "[P]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[Q]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[R]", 13},
                        {SPELLS_ULTIMATE_MAGIC, "[S]", 34},
                        {SPELLS_ULTIMATE_MAGIC, "[T]", 6},
                        {SPELLS_ULTIMATE_MAGIC, "[U]", 12},
                        {SPELLS_ULTIMATE_MAGIC, "[V]", 9},
                        {SPELLS_ULTIMATE_MAGIC, "[W]", 7},
                        {SPELLS_ULTIMATE_MAGIC, "[X]", 0},
                        {SPELLS_ULTIMATE_MAGIC, "[Y]", 1},
                        {SPELLS_ULTIMATE_MAGIC, "[Z]", 0}
                }
        );
    }

    private final Source source;
    private final String startingLetterPattern;
    private final int expectedNoOfSpells;

    private SpellCrawler sut = new SpellCrawlerImpl();

    public SpellCrawlerTest(Source source, String startingLetterPattern, int expectedNoOfSpells) {
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
