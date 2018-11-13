package marvel.service;

import marvel.model.ApiResponse;
import marvel.model.Character;
import org.springframework.web.client.RestTemplate;

public class CharacterServiceImpl implements CharacterService
{

	/**
	 *
	 * @param name This is the description
	 * @return CharacterImpl returns an instantiated CharacterImpl object
	 */
	@Override
	public Character getCharacter(String name) {
		String authenticationString = this.authenticationString.getAuthenticationString();
		String parametersString = "name=" + name;
		String requestString = "?" + authenticationString.join("&", authenticationString, parametersString);
		return this.makeCall(requestString);
	}

	/**
	 *
	 * @param requestString
	 * @return
	 */
	private Character makeCall(String requestString) {
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse apiResponse =  restTemplate.getForObject("http://gateway.marvel.com/v1/public/characters" + requestString, ApiResponse.class);
		Character character = apiResponse.getData().getResults()[0];

		return character;

	}
}
