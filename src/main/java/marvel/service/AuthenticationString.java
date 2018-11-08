package marvel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthenticationString implements AuthenticationGenerator
{
	@Value("${public-api-key}")
	private String publicApiKey;

	@Value("${private-api-key}")
	private String privateApiKey;

	@Override
	@Bean
	public String getAuthenticationString()
	{
		String timeStamp = this.getTimeStamp();
		String hash = "hash=" + this.getHash(timeStamp, this.privateApiKey, this.publicApiKey);
		String apiKey = "apikey=" + this.publicApiKey;

		return String.join("&", "ts=" + timeStamp, apiKey, hash);
	}

	private String getTimeStamp()
	{
		Long timeStamp = System.currentTimeMillis();
		return timeStamp.toString();
	}

	private String getHash(String timeStamp, String privateApiKey, String publicApiKey)
	{
		String stringToHash = timeStamp + privateApiKey + publicApiKey;
		String hashedString = "";
		try
		{

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] digest = md.digest(stringToHash.getBytes());

			BigInteger number = new BigInteger(1, digest);

			hashedString = number.toString(16);

		}
		catch (NoSuchAlgorithmException e)
		{
			System.out.println(e);
		}

		return hashedString;
	}

}

