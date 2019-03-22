package marvel.service.Character;

import java.io.IOException;
import java.util.ArrayList;
import marvel.model.Character;
import marvel.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {

  ArrayList<Character> getCharacter(String name) throws IOException;
}
