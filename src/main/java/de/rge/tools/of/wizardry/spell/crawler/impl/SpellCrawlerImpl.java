package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.Config;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.model.enums.Source;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class SpellCrawlerImpl implements SpellCrawler {
    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();
    private URL sourceUrl;

    @Override
    public List<URL> determineAllSpellUrls(Source source, String startingLetterPattern) {
        sourceUrl = readSourceUrl(source);
        Document htmlDocument = htmlDocumentUtil.read(sourceUrl);
        Elements links = htmlDocument.select("ul[title~=" + startingLetterPattern + " Spells] a[href]");
        return links.stream()
                .map(this::extractLink)
                .filter(this::isValidSpellUrl)
                .map(this::mapToUrl)
                .collect(Collectors.toList());
    }

    private URL readSourceUrl(Source source) {
        try (InputStream is = getClass().getResourceAsStream(Config.CONFIG_PROPERTIES.getValue())) {
            Properties props = new Properties();
            props.load(is);
            return new URL(props.getProperty(source.getUrlKey()));
        } catch (IOException ioe) {
            throw new IllegalArgumentException("error while reading properties", ioe);
        }
    }

    private String extractLink(Element link) {
        return link.attr("href");
    }

    private boolean isValidSpellUrl(String link) {
        return link.contains("spells/");
    }

    private URL mapToUrl(String link) {
        try {
            return sourceUrl
                    .toURI()
                    .resolve(link)
                    .toURL();
        } catch (URISyntaxException | MalformedURLException ex) {
            throw new IllegalArgumentException("error while mapping to URI or URL for : " + sourceUrl + " and " + link, ex);
        }
    }
}
