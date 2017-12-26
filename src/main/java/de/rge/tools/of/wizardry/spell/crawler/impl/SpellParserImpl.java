package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.SpellParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class SpellParserImpl implements SpellParser {
    @Override
    public String parseName(URL spellUrl) {
        try {
            Document htmlDocument = Jsoup.connect(spellUrl.toExternalForm()).get();
            Elements titles = htmlDocument.select("h1");
            if(1 != titles.size()) {
                System.out.println("no of titles is not equal to 1 for " + spellUrl);
            }
            return titles.first().text();
        } catch(IOException ioe) {
            throw new IllegalArgumentException("error while opening html document for " + spellUrl);
        }
    }
}
