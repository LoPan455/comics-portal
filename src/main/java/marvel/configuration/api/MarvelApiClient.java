package marvel.configuration.api;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import marvel.configuration.property.MarvelProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarvelApiClient {

  MarvelProperties properties;

  MarvelApiClient(MarvelProperties properties) {
    this.properties = properties;
  }

  @Bean
  public RestTemplate client() {
    RestTemplateBuilder builder = new RestTemplateBuilder();
    builder.rootUri(properties.baseUrl);
    return builder.build();
  }

  @Bean
  public String marvelAuth() {
    System.out.println(properties.privateApiKey);
    System.out.println(properties.publicApiKey);
    String timeStamp = getTimeStamp();
    String hash = "hash=" + getHash(timeStamp, properties.privateApiKey, properties.publicApiKey);
    String apiKey = "apikey=" + properties.publicApiKey;
    return String.join("&", "ts=" + timeStamp, apiKey, hash);
  }

  private String getTimeStamp() {
    Long timeStamp = System.currentTimeMillis();
    return timeStamp.toString();
  }

  private String getHash(String timeStamp, String privateApiKey, String publicApiKey) {
    String stringToHash = timeStamp + privateApiKey + publicApiKey;
    String hashedString = "";
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] digest = md.digest(stringToHash.getBytes());
      BigInteger number = new BigInteger(1, digest);
      hashedString = number.toString(16);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(e);
    }
    return hashedString;
  }

}
