package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.api.SpellParser;
import de.rge.tools.of.wizardry.spell.crawler.model.Spell;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class SpellParserImpl implements SpellParser {
    private static final Logger log = LoggerFactory.getLogger(SpellParserImpl.class);

    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();

    @Override
    public Spell parseSpell(URL spellUrl) {
        Document htmlDocument = htmlDocumentUtil.read(spellUrl);
        return parseSpell(htmlDocument);
    }

    private Spell parseSpell(Document htmlDocument) {
        Spell spell = new Spell();
        spell.setName(parseName(htmlDocument));
        return spell;
    }

    private String parseName(Document htmlDocument) {
        Elements titles = htmlDocument.select("h1");
        if (1 != titles.size()) {
            log.warn("number of titles is not equal to 1 for {}", htmlDocument.baseUri());
        }
        return titles.first().text();
    }
}
