package marvel.configuration;

import marvel.service.AuthenticationGenerator;
import marvel.service.AuthenticationString;
import marvel.service.CharacterService;
import marvel.service.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration
{
	@Value("${public-api-key}")
	private String publicApiKey;

	@Value("${private-api-key}")
	private String privateApiKey;
}
