package marvel.service;

import marvel.model.ComicApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ComicServiceImpl implements ComicService
{
	@Autowired
	AuthenticationGenerator authenticationGenerator;

	public ComicApiResponse getComics() {
		ComicApiResponse returnValue = null;
		String authenticationString = authenticationGenerator.getAuthenticationString();
		returnValue = this.makeCall(authenticationString);

		return returnValue;
	}

	/**
	 * @param requestString The request string to send to Marvel
	 * @return apiResponse
	 */
	private ComicApiResponse makeCall(String requestString) {
		RestTemplate restTemplate = new RestTemplate();
		ComicApiResponse comicResponse = restTemplate.getForObject("http://gateway.marvel.com/v1/public/comics?" + requestString, ComicApiResponse.class);
		return comicResponse;

	}
}

