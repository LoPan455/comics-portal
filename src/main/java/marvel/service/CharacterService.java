package marvel.service;

import marvel.model.CharacterApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService
{
	CharacterApiResponse getCharacter(String name);

}