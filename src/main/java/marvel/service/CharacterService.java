package marvel.service;

import marvel.marvelobjects.Hero;
import org.springframework.context.annotation.Bean;

public interface CharacterService
{
	Hero getHero(String heroName);

	@Bean
	Hero[] getHeroes(String[] heroNames);
}
