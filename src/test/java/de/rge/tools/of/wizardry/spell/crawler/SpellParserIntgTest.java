package de.rge.tools.of.wizardry.spell.crawler;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellCrawlerImpl;
import de.rge.tools.of.wizardry.spell.crawler.impl.SpellParserImpl;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicDescriptor;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSchool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.MagicSubschool;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RunWith(Parameterized.class)
public class SpellParserIntgTest {
    private static final Logger log = LoggerFactory.getLogger(SpellParserIntgTest.class);

    @Parameterized.Parameters
    public static Iterable<Object[]> params() {
        return Arrays.stream(Source.values())
                .map(source -> new Object[] {source})
                .collect(Collectors.toList());
    }

    private final Source source;
    private final Map<MagicSchool, List<URL>> schoolResults;
    private final Map<MagicSubschool, List<URL>> subschoolResults;
    private final Map<MagicDescriptor, List<URL>> descriptorResults;
    private final Map<MagicDescriptor.Connector, List<URL>> descriptorConnectorResults;
    private final SoftAssertions softAsserter;

    private SpellParser sut = new SpellParserImpl();

    private SpellCrawler spellCrawler = new SpellCrawlerImpl();

    public SpellParserIntgTest(Source source) {
        this.source = source;
        this.schoolResults = ExpectedNoOfSpellsPerSchool.prepareResults(source);
        this.subschoolResults = ExpectedNoOfSpellsPerSubschool.prepareResults(source);
        this.descriptorResults = ExpectedNoOfSpellsPerDescriptor.prepareResults(source);
        this.descriptorConnectorResults = ExpectedNoOfSpellsPerDescriptor.prepareResultsPerConnector(source);
        this.softAsserter = new SoftAssertions();
    }

    @Test
    public void parseSpell_allData() {
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
        schoolResults.get(accessNullSafe(spell, Spell::getSchool)).add(spellUrl);
        subschoolResults.get(accessNullSafe(spell, Spell::getSubschool)).add(spellUrl);
        addListResult(descriptorResults, spellUrl, spell, Spell::getDescriptors);
        descriptorConnectorResults.get(accessNullSafe(spell, Spell::getDescriptorsConnector)).add(spellUrl);
    }

    private <T> T accessNullSafe(Spell spell, Function<Spell, T> getter) {
        return null == spell? null : getter.apply(spell);
    }

    private <T> void addListResult(final Map<T, List<URL>> results, URL spellUrl, Spell spell,  Function<Spell, List<T>> getter) {
        if(null == spell || getter.apply(spell).isEmpty()) {
            results.get(null).add(spellUrl);
        } else {
            getter.apply(spell).forEach(listRecord -> results.get(listRecord).add(spellUrl));
        }
    }


    private void assertNoOfExpectedSpells() {
        MagicSchool.getValueListWithNull().forEach(this::assertNoOfExpectedSpells);
        MagicSubschool.getValueListWithNull().forEach(this::assertNoOfExpectedSpells);
        MagicDescriptor.getValueListWithNull().forEach(this::assertNoOfExpectedSpells);
        MagicDescriptor.Connector.getValueListWithNull().forEach((this::assertNoOfExpectedSpells));
        softAsserter.assertAll();
    }

    private void assertNoOfExpectedSpells(MagicSchool school) {
        softAsserter.assertThat(schoolResults.get(school))
                .as("source: " + source + "\tschool: " + school)
                .hasSize(ExpectedNoOfSpellsPerSchool.getExpectedNoOfSpells(source, school));
    }

    private void assertNoOfExpectedSpells(MagicSubschool subschool) {
        softAsserter.assertThat(subschoolResults.get(subschool))
                .as("source: " + source + "\tsubschool: " + subschool)
                .hasSize(ExpectedNoOfSpellsPerSubschool.getExpectedNoOfSpells(source, subschool));
    }

    private void assertNoOfExpectedSpells(MagicDescriptor descriptor) {
        softAsserter.assertThat(descriptorResults.get(descriptor))
                .as("source: " + source + "\tdescriptor: " + descriptor)
                .hasSize(ExpectedNoOfSpellsPerDescriptor.getExpectedNoOfSpells(source, descriptor));
    }

    private void assertNoOfExpectedSpells(MagicDescriptor.Connector connector) {
        softAsserter.assertThat(descriptorConnectorResults.get(connector))
                .as("source: " + source + "\tconnector: " + connector)
                .hasSize(ExpectedNoOfSpellsPerDescriptor.getExpectedNoOfSpellsPerConnector(source, connector));
    }
}
