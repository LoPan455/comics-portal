package marvel.service;

import org.springframework.context.annotation.Bean;

public interface AuthenticationGenerator
{
	@Bean
	String getAuthenticationString();
}
