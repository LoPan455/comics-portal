package marvel.controller;

import marvel.marvelobjects.Hero;
import marvel.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController
{

	private final CharacterService characterService;

	@Autowired
	public HelloController(CharacterService characterService){
		this.characterService = characterService;
	}

	@RequestMapping("/")
	public String index()
	{
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/marvel")
	public Hero getHero()
	{
		return characterService.getHero("Spider-Man");
	}
}
