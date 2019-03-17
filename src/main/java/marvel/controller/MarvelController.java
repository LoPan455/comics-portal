package marvel.controller;

import marvel.model.Character;
import marvel.service.Comic.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/marvel")
public class MarvelController
{

	@Autowired
	public CharacterService characterService;

	@RequestMapping("/")
	public String index()
	{
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/character")
	public Character getCharacter(@RequestParam(name = "name") String character) throws IOException {
		return characterService.getCharacter(character);
	}

	@RequestMapping("/comics")
	public String getComic() {
		return "Here is your comic";
	}

}
