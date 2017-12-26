package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.Spell;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

public class SpellParserImpl implements SpellParser {
    private static final Logger log = LoggerFactory.getLogger(SpellParserImpl.class);

    @Override
    public Spell parseSpell(URL spellUrl) {
        try {
            Document htmlDocument = Jsoup.connect(spellUrl.toExternalForm()).get();
            return parseSpell(htmlDocument);
        } catch(IOException ioe) {
            throw new IllegalArgumentException("error while opening html document for " + spellUrl);
        }

    }

    private Spell parseSpell(Document htmlDocument) {
        Spell spell = new Spell();
        spell.setName(parseName(htmlDocument));
        return spell;
    }

    private String parseName(Document htmlDocument) {
            Elements titles = htmlDocument.select("h1");
            if(1 != titles.size()) {
                log.warn("number of titles is not equal to 1 for {}", htmlDocument.baseUri());
            }
            return titles.first().text();
    }
}
