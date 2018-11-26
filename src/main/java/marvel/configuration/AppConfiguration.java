package marvel.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration
{
	@Value("${public-api-key}")
	private String publicApiKey;

	@Value("${private-api-key}")
	private String privateApiKey;
}
