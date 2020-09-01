package marvel.configuration.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "marvel")
public class MarvelProperties {

  @Value("${public-api-key}")
  public String publicApiKey;

  @Value("${private-api-key}")
  public String privateApiKey;
}
