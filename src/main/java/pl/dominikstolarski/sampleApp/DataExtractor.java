package pl.dominikstolarski.sampleApp;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.HashMap;
import java.util.Map;

public class DataExtractor {

    private Map<String, Integer> uniqueDomainsMap = new HashMap<>();

    public Map<String, Integer> prepareUniqueDomainsMap(Document document) {
        Elements links = document.select("a[href]");

        links.stream().forEach(element -> {
            String rawLinkFromElement = element.attr("href");
            if (UrlUtils.isValidUrl(rawLinkFromElement)) {

                String linkToSave = UrlUtils.prepareLinkToSave(rawLinkFromElement);

                if (isUnique(linkToSave)) {
                    uniqueDomainsMap.put(linkToSave, 1);
                } else {
                    int linkOccurences = uniqueDomainsMap.get(linkToSave);
                    uniqueDomainsMap.put(linkToSave, linkOccurences + 1);
                }
            }
        });
        return uniqueDomainsMap;
    }

    public boolean isUnique(String link) {
        if (!uniqueDomainsMap.isEmpty()) {
            return !uniqueDomainsMap.containsKey(link);
        }
        return true;
    }

    public Map<String, Integer> getUniqueDomainsMap() {
        return uniqueDomainsMap;
    }
}
