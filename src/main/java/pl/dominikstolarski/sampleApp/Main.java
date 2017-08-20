package pl.dominikstolarski.sampleApp;

import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;
import static pl.dominikstolarski.sampleApp.PrettyUrlPrinter.printPretty;

public class Main {

    public static void main(String[] args) {

        Document document;
        Map<String, Integer> uniqueDomainsMap;
        String url;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter URL: (for exit enter 'x')");
            url = scanner.next();

            if (url.equals("x")) {
                break;
            }

            try {
                document = new HtmlParser(url).getPageSource();
            } catch (UnknownHostException e) {
                System.err.println("Cannot connect. URL you entered is invalid or website is unavailable.");
                continue;
            } catch (IOException e) {
                System.err.println("Cannot retrieve data from requested URL.");
                continue;
            }

            uniqueDomainsMap = new DataExtractor().prepareUniqueDomainsMap(document);
            printPretty(uniqueDomainsMap);
        }
    }
}