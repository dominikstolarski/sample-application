package pl.dominikstolarski.sampleApp;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UrlUtilsTest {

    @Test
    public void shouldReturnTrueForValidUrl() {
        // GIVEN
        String url = "http://onet.pl";

        // WHEN
        boolean isUrlValid = UrlUtils.isValidUrl(url);

        // THEN
        assertThat(isUrlValid).isTrue();
    }

    @Test
    public void shouldReturnUrlWithoutWWWPrefix() {
        // GIVEN
        String url1 = "http://onet.pl";
        String url2 = "https://onet.pl";
        String url3 = "http://www.onet.pl";
        String url4 = "https://www.onet.pl";

        // WHEN
        String preparedLink1 = UrlUtils.prepareLinkToSave(url1);
        String preparedLink2 = UrlUtils.prepareLinkToSave(url2);
        String preparedLink3 = UrlUtils.prepareLinkToSave(url3);
        String preparedLink4 = UrlUtils.prepareLinkToSave(url4);

        // THEN
        assertThat(!preparedLink1.contains("www."));
        assertThat(!preparedLink2.contains("www."));
        assertThat(!preparedLink3.contains("www."));
        assertThat(!preparedLink4.contains("www."));
    }

    @Test
    public void shouldReturnTopDomainNameWithoutPrefixes() {
        // GIVEN
        String rawUrl = "http://www.pogoda.onet.pl";

        // WHEN
        String preparedLinkToSave = UrlUtils.prepareLinkToSave(rawUrl);

        // THEN
        assertThat(preparedLinkToSave.equals("onet.pl"));
    }
}
