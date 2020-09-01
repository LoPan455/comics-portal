package marvel.configuration.api;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import marvel.configuration.property.MarvelProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MarvelApiClient {

  String publicApiKey;
  String privateApiKey;

  public MarvelApiClient(MarvelProperties properties) {
    this.publicApiKey = properties.publicApiKey;
    this.privateApiKey = properties.publicApiKey;
  }

  @Bean
  public RestTemplate marvelApiClient() {
    RestTemplateBuilder builder = new RestTemplateBuilder();
    builder.rootUri("https://gateway.marvel.com/v1/public");
    return builder.build();
  }


  @Bean
  public String auth() {
    String timeStamp = getTimeStamp();
    String hash = "hash=" + getHash(timeStamp, privateApiKey, publicApiKey);
    String apiKey = "apikey=" + publicApiKey;
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
