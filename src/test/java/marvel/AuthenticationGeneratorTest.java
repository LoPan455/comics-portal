package marvel;

import marvel.service.AuthenticationString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationGeneratorTest
{

	@Autowired
	AuthenticationString authenticationString;

	@Test
	public void testTimeStampGivesValidReturn() {
	}

	@Test
	public void testGetAuthStringReturnsAValidValue()	{
		String authString = authenticationString.getAuthenticationString();
		assertThat(authString.contains("ts="));
	}
}
