package marvel.controller;

import marvel.model.CharacterApiResponse;
import marvel.model.ComicApiResponse;
import marvel.service.CharacterService;
import marvel.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarvelController
{

	@Autowired
	public CharacterService characterService;

	@Autowired
	public ComicService comicService;

	@RequestMapping("/")
	public String index()
	{
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/marvel")
	public CharacterApiResponse getHero()
	{
		return characterService.getCharacter("Spider-Man");
	}

	@RequestMapping("/comics")
	public ComicApiResponse getComics() {
		return comicService.getComics();
	}
}
