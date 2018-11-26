package marvel.service;

import marvel.model.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService
{
	ApiResponse getCharacter(String name);
}
