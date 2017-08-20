package pl.dominikstolarski.sampleApp;

import org.jsoup.nodes.Document;
import org.junit.Test;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

public class HtmlParserTest {

    @Test
    public void shouldReturnDocumentWithPageSourceForGivenUrlWithHttpPrefix() throws IOException {
        // GIVEN
        HtmlParser htmlParser = new HtmlParser("http://google.pl");

        // WHEN
        Document document = htmlParser.getPageSource();

        // THEN
        assertThat(document).isNotNull();
    }

    @Test
    public void shouldReturnDocumentWithPageSourceForGivenUrlWithHttpsPrefix() throws IOException {
        // GIVEN
        HtmlParser htmlParser = new HtmlParser("https://google.pl");

        // WHEN
        Document document = htmlParser.getPageSource();

        // THEN
        assertThat(document).isNotNull();
    }
    @Test
    public void shouldReturnDocumentWithPageSourceForGivenUrlWithWwwPrefix() throws IOException {
        // GIVEN
        HtmlParser htmlParser = new HtmlParser("www.google.pl");

        // WHEN
        Document document = htmlParser.getPageSource();

        // THEN
        assertThat(document).isNotNull();
    }
}
