package marvel.service.Comic;

import com.fasterxml.jackson.databind.JsonNode;
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
	public Character getCharacter(String name) throws IOException {
		String response = null;
		String authenticationString = authenticationGenerator.getAuthenticationString();

		// TODO Make a query parameter map to pass query params into a return a properly formatted query string

		String parametersString = "name=" + name;
		String requestString = "?" + authenticationString.join("&", authenticationString, parametersString);

		response = this.makeCall(requestString);

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


	private Character extractCharacter(String apiResponse) throws IOException {
		JsonNode characterNode = mapper.readTree(apiResponse).get("data").get("results").get(0);

		Character character = new Character();
		character.setMarvelApiId(characterNode.get("id").toString());
		character.setName(characterNode.get("name").textValue());
		character.setDescription(characterNode.get("description").textValue());
		character.setResourceURI(characterNode.get("resourceURI").textValue());

		return character;

	}
}
