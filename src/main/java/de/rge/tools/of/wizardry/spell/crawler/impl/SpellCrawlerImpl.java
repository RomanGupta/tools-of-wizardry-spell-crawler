package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.UrlMarker;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class SpellCrawlerImpl implements SpellCrawler {
    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();
    private final URL sourceUrl;

    public SpellCrawlerImpl(URL sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public List<URL> determineAllSpellUrls(String startingLetterPattern) {
        Document htmlDocument = htmlDocumentUtil.read(sourceUrl);
        Elements links = htmlDocument.select("ul[id^=index-spells] a[href~=spells/" + startingLetterPattern + "]");
        return convertToUrls(links);
    }

    @Override
    public List<URL> convertToUrls(Elements links) {
        return links.stream()
                .map(this::extractLink)
                .map(this::mapToUrl)
                .filter(this::isValidSpellUrl)
                .distinct()
                .collect(Collectors.toList());
    }

    private String extractLink(Element link) {
        return link.attr("href");
    }

    private boolean isValidSpellUrl(URL link) {
        return !UrlMarker.isIgnored(link.toExternalForm());
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
