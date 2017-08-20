package pl.dominikstolarski.sampleApp;

import java.util.Map;

public class PrettyUrlPrinter {

    public static void printPretty(Map<String, Integer> urlsMap) {
        urlsMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
