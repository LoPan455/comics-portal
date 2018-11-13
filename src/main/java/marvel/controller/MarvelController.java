package marvel.controller;

import marvel.model.CharacterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MarvelController
{

	private final Character character;

	@Autowired
	public MarvelController(Character character){
		this.character = character;
	}

	@RequestMapping("/")
	public String index()
	{
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/marvel")
	public CharacterImpl getHero()
	{
		return character.getHero("Spider-Man");
	}
}
