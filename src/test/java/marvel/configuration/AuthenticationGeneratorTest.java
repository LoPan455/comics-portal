package marvel.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class AuthenticationGeneratorTest {

  @Autowired
  String marvelAuth;

  @Test
  void testAuthBean() {
    assert marvelAuth.contains("ts=");
  }

}
