package marvel.controller;

import marvel.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MarvelController
{

	@Autowired
	public CharacterService characterService;

	@RequestMapping("/")
	public String index()
	{
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/marvel")
	public String getHero() throws IOException {
		return characterService.getCharacter("Spider-Man");
	}

}
