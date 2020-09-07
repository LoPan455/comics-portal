package marvel.configuration.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "marvel")
@Configuration
public class MarvelProperties {

  public String publicApiKey;

  public String privateApiKey;

  public String baseUrl;

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public String getPublicApiKey() {
    return publicApiKey;
  }

  public void setPublicApiKey(String publicApiKey) {
    this.publicApiKey = publicApiKey;
  }

  public String getPrivateApiKey() {
    return privateApiKey;
  }

  public void setPrivateApiKey(String privateApiKey) {
    this.privateApiKey = privateApiKey;
  }
}
