package marvel.service;

import marvel.model.ApiResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface CharacterService
{
	String getCharacter(String name) throws IOException;
}
