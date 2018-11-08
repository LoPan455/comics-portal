package marvel.service;

import marvel.marvelobjects.Hero;
import marvel.marvelobjects.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterFromApi implements CharacterService
{
	private AuthenticationString authenticationString;

	@Autowired
	public CharacterFromApi(AuthenticationString authenticationString){
		this.authenticationString = authenticationString;
	}

	/**
	 *
	 * @param heroName This is the description
	 * @return Hero returns an instantiated Hero object
	 */
	@Override
	public Hero getHero(String heroName) {
		String authenticationString = this.authenticationString.getAuthenticationString();
		String parametersString = "name=" + heroName;
		String requestString = "?" + authenticationString.join("&", authenticationString, parametersString);
		return this.makeCall(requestString);
	}

	private Hero makeCall(String requestString) {
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse apiResponse =  restTemplate.getForObject("http://gateway.marvel.com/v1/public/characters" + requestString, ApiResponse.class);
		Hero hero = apiResponse.getData().getResults()[0];

		return hero;

	}

	/**
	 *
	 * @param heroNames An array of names to pass to the Marvel API
	 * @return Hero[] An array of instantiated Hero object
	 */
	@Override
	@Bean
	public Hero[] getHeroes(String[] heroNames) {
		int length = heroNames.length;
		Hero[] heroes = new Hero[length];
		for (String heroName : heroNames) {
			//heroes.add(this.getHero(heroName));
		}
		return heroes;
	}
}
