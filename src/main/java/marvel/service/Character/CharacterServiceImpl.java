package marvel.service.Character;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import marvel.model.Character;
import marvel.service.AuthenticationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class CharacterServiceImpl implements CharacterService
{
	@Autowired
	AuthenticationGenerator authenticationGenerator;

	ObjectMapper mapper = new ObjectMapper();

	/**
	 * @param name This is the description
	 * @return CharacterImpl returns an instantiated CharacterImpl object
	 */
	@Override
	public ArrayList<Character> getCharacter(String name) throws IOException {

		String authenticationString = authenticationGenerator.getAuthenticationString();
		// TODO Make a query parameter map to pass query params into a return a properly formatted query string
		String parametersString = "name=" + name;
		String requestString = "?" + authenticationString.join("&", authenticationString, parametersString);

		String response = this.makeCall(requestString);

		return extractCharacter(response);

	}

	/**
	 * @param requestString The request string to send to Marvel
	 * @return apiResponse
	 */
	private String makeCall(String requestString) {
		RestTemplate restTemplate = new RestTemplate();
		String apiResponse = restTemplate.getForObject("http://gateway.marvel.com/v1/public/characters" + requestString, String.class);
		return apiResponse;
	}


	private ArrayList<Character> extractCharacter(String apiResponse) throws IOException {
		JsonNode resultsNode = mapper.readTree(apiResponse).get("data").get("results");
		ArrayList<Character> characters = new ArrayList<>();

		for (JsonNode result : resultsNode) {
			Character character = new Character();
			character.setMarvelApiId(result.get("id").toString());
			character.setName(result.get("name").textValue());
			character.setDescription(result.get("description").textValue());
			character.setResourceURI(result.get("resourceURI").textValue());
			characters.add(character);
		}

		return characters;

	}
}
