package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class SpellParserIntgTest {
    private static final Logger log = LoggerFactory.getLogger(SpellParserIntgTest.class);

    private static final ExpectedNoOfSpellsPerSchool EXPECTED_NO_OF_SPELLS_PER_SCHOOL = new ExpectedNoOfSpellsPerSchool();
    @Parameterized.Parameters
    public static Iterable<Object[]> params() {
        return EXPECTED_NO_OF_SPELLS_PER_SCHOOL.getSources().stream()
                .map(source -> new Object[] {source})
                .collect(Collectors.toList());
    }

    private final Source source;
    private final Map<MagicSchool, List<URL>> schoolResults;

    private SpellParser sut = new SpellParserImpl();

    private SpellCrawler spellCrawler = new SpellCrawlerImpl();

    public SpellParserIntgTest(Source source) {
        this.source = source;
        this.schoolResults = EXPECTED_NO_OF_SPELLS_PER_SCHOOL.prepareResults(source);
    }

    @Test
    public void parseSpell_schoolDistribution() {
        List<URL> spellUrls = spellCrawler.determineAllSpellUrls(source, "[A-Z]");
        spellUrls.forEach(this::parseSpell);
        assertNoOfExpectedSpells();
    }

    private void parseSpell(URL spellUrl) {
        try {
            Spell spell = sut.parseSpell(spellUrl);
            log.info("spell url {} was successfully processed.", spellUrl);
            addResult(spellUrl, spell);
        } catch (Exception ex) {
            log.error("error while parsing spell {}: {}", spellUrl, ex);
            addResult(spellUrl, null);
        }
    }

    private void addResult(URL spellUrl, Spell spell) {
        schoolResults.get(nullSafe(spell)).add(spellUrl);
    }

    private MagicSchool nullSafe(Spell spell) {
        return spell == null ? null : spell.getSchool();
    }


    private void assertNoOfExpectedSpells() {
        SoftAssertions softAsserter = new SoftAssertions();
        schoolResults.forEach((school, list) -> assertNoOfExpectedSpells(softAsserter, school, list));
        softAsserter.assertAll();
    }

    private void assertNoOfExpectedSpells(SoftAssertions softAsserter, MagicSchool school, List<URL> spellUrls) {
        softAsserter.assertThat(spellUrls)
                .as("source: " + source + "\tschool: " + school)
                .hasSize(EXPECTED_NO_OF_SPELLS_PER_SCHOOL.getExpectedNoOfSpells(source, school));
    }
}
