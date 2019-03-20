package marvel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.ArrayList;
import marvel.model.Character;
import marvel.model.CharacterFilter;
import marvel.service.Character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping(value = "/character", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCharacter(@RequestParam(name = "name") String character) throws IOException {
		ArrayList<Character> characters = characterService.getCharacter(character);
		ArrayList<Character> charactersWithFilteredProperties = new ArrayList<>();
		String returnString = "";

		ObjectMapper mapper = new ObjectMapper();
		FilterProvider filter = new SimpleFilterProvider().addFilter("character-filter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "resourceURI"));
//		filter.addFilter("characterFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "resourceURI"));
//		filter.addFilter(
//				"character-filter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "resourceURI"));
		mapper.setFilterProvider(filter);
		for (Character unfilteredCharacters : characters) {
			returnString += mapper.writer(filter).writeValueAsString(unfilteredCharacters);
		}

		return returnString;
	}

	@RequestMapping("/comics")
	public String getComic() {
		return "Here is your comic";
	}

}
