package marvel.service;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationGenerator
{
	String getAuthenticationString();
}
