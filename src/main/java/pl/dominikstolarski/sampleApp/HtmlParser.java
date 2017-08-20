package pl.dominikstolarski.sampleApp;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class HtmlParser {

    private Document documentFromSource;
    private String url;

    public HtmlParser(String url){
        if(!url.startsWith("http")){
            url = "http://"+url;
        }
        this.url = url;
    }

    public Document getPageSource() throws IOException {
        Connection connection = Jsoup.connect(url);
        documentFromSource = connection.get();
        return documentFromSource;
    }
}
