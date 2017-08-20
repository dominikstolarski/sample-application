package pl.dominikstolarski.sampleApp;

import org.junit.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class DataExtractorTest {

    @Test
    public void shouldReturnTrueForGivenUrl() {
        // GIVEN
        String url1 = "http://wp.pl";
        String ulr2 = "http://onet.pl";
        DataExtractor dataExtractor = new DataExtractor();
        Map<String, Integer> uniqueDomainsMap = dataExtractor.getUniqueDomainsMap();
        uniqueDomainsMap.put(url1,1);

        // WHEN
        boolean isAddressUnique = dataExtractor.isUnique(ulr2);

        // THEN
        assertThat(isAddressUnique).isTrue();
        assertThat(uniqueDomainsMap.containsValue(url1));
        assertThat(!uniqueDomainsMap.isEmpty());
    }

    @Test
    public void shouldReturnFalseForGivenUrl() {
        // GIVEN
        String url = "http://wp.pl";
        DataExtractor dataExtractor = new DataExtractor();
        Map<String, Integer> uniqueDomainsMap = dataExtractor.getUniqueDomainsMap();
        uniqueDomainsMap.put(url,1);

        // WHEN
        boolean isAddressUnique = dataExtractor.isUnique(url);

        // THEN
        assertThat(isAddressUnique).isFalse();
    }
}
