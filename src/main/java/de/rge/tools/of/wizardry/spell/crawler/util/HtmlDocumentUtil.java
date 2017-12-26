package de.rge.tools.of.wizardry.spell.crawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class HtmlDocumentUtil {
    public Document read(URL url) {
        try {
            return Jsoup.connect(url.toExternalForm()).get();
        } catch(IOException ioe) {
            throw new IllegalArgumentException("error while opening html document for " + url);
        }
    }
}
