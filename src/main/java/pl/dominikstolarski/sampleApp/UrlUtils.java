package pl.dominikstolarski.sampleApp;

import com.google.common.net.InternetDomainName;
import java.net.URI;
import java.util.regex.Pattern;

public class UrlUtils {

    public static String urlRegex = "^(https?://)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static Pattern pattern = Pattern.compile(urlRegex);

    public static boolean isValidUrl(String url) {
        return pattern.matcher(url).matches();
    }

    public static String prepareLinkToSave(String rawLink) {
        URI uri = URI.create(rawLink);
        InternetDomainName internetDomainName = InternetDomainName.from(uri.getHost());
        return internetDomainName.topPrivateDomain().toString().replace("www.", "");
    }
}
