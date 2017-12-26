package de.rge.tools.of.wizardry.spell.crawler.impl;

import de.rge.tools.of.wizardry.spell.crawler.Config;
import de.rge.tools.of.wizardry.spell.crawler.api.SpellCrawler;
import de.rge.tools.of.wizardry.spell.crawler.util.HtmlDocumentUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SpellCrawlerImpl implements SpellCrawler {
    private HtmlDocumentUtil htmlDocumentUtil = new HtmlDocumentUtil();

    private URL baseUrl;
    private Pattern urlPattern;

    @Override
    public List<URL> determineAllSpellUrls(String startingLetterPattern) {
            init(startingLetterPattern);
            Document htmlDocument = htmlDocumentUtil.read(baseUrl);
            Elements links = htmlDocument.select("a[href]");
            return links.stream()
                    .map(this::extractLink)
                    .filter(this::isValidSpellUrl)
                    .map(this::mapToUrl)
                    .collect(Collectors.toList());
    }

    private void init(String startingLetterPattern) {
        baseUrl = initBaseUrl();
        urlPattern = initUrlPattern(startingLetterPattern);
    }

    private URL initBaseUrl() {
        try(InputStream is = getClass().getResourceAsStream(Config.CONFIG_PROPERTIES.getValue())) {
            Properties props = new Properties();
            props.load(is);
            return new URL(props.getProperty(Config.KEY_BASE_URL.getValue()));
        } catch(IOException ioe) {
            throw new IllegalArgumentException("error while reading properties", ioe);
        }
    }

    private Pattern initUrlPattern(String startingLetterPattern) {
        return Pattern.compile(baseUrl + startingLetterPattern + "/[a-z0-9\\\\-]+/?");

    }

    private String extractLink(Element link) {
        return link.attr("href");
    }

    private boolean isValidSpellUrl(String link) {
        return urlPattern.matcher(link)
                .matches();
    }

    private URL mapToUrl(String link){
        try {
            return new URL(link);
        } catch(MalformedURLException mURLe) {
            throw new IllegalArgumentException("error while mapping to URL for :" + link, mURLe);
        }
    }
}
