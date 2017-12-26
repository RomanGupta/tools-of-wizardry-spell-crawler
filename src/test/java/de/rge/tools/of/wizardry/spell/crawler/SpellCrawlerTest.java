package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class SpellCrawlerTest {

    @Parameters
    public static Iterable<Object[]> params() {
        return Arrays.asList(new Object[][]{
                        {"[a]", 160},
                        {"[b]", 165},
                        {"[c]", 201},
                        {"[d]", 184},
                        {"[e]", 90},
                        {"[f]", 145},
                        {"[g]", 70},
                        {"[h]", 105},
                        {"[i]", 93},
                        {"[j]", 10},
                        {"[k]", 18},
                        {"[l]", 73},
                        {"[m]", 137},
                        {"[n]", 25},
                        {"[o]", 32},
                        {"[p]", 149},
                        {"[q]", 8},
                        {"[r]", 123},
                        {"[s]", 399},
                        {"[t]", 134},
                        {"[u]", 47},
                        {"[v]", 47},
                        {"[w]", 92},
                        {"[x]", 0},
                        {"[y]", 1},
                        {"[z]", 4}
                }
        );
    }

    private final String startingLetterPattern;
    private final int expectedNoOfSpells;

    private SpellCrawler sut = new SpellCrawlerImpl();

    public SpellCrawlerTest(String startingLetterPattern, int expectedNoOfSpells) {
        this.startingLetterPattern = startingLetterPattern;
        this.expectedNoOfSpells = expectedNoOfSpells;
    }

    @Test
    public void determineAllSpellUrls_startingLettersAToZ() {
        assertThat(sut.determineAllSpellUrls(startingLetterPattern)).hasSize(expectedNoOfSpells);
    }

}
