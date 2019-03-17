package marvel.service;

import java.io.IOException;
import marvel.model.Character;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  Character getCharacter(String name) throws IOException;
}
