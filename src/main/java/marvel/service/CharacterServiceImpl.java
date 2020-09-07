package marvel.service;

import marvel.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CharacterServiceImpl  {

//  @Autowired
//  AuthenticationGenerator authenticationGenerator;

  ObjectMapper mapper = new ObjectMapper();

  /**
   * @param name This is the description
   * @return CharacterImpl returns an instantiated CharacterImpl object
   */
//  @Override
//  public ApiResponse getCharacter(String name) {
//    ApiResponse response = null;
//    String authenticationString = authenticationGenerator.getAuthenticationString();
//    String parametersString = "name=" + name;
//    String requestString =
//        "?" + authenticationString.join("&", authenticationString, parametersString);
//    try {
//      response = this.makeCall(requestString);
//    } catch (Exception e) {
//      System.out.println(e);
//    }
//
//    return response;
//  }

  /**
   * @param requestString The request string to send to Marvel
   * @return apiResponse
   */
  private ApiResponse makeCall(String requestString) {
    RestTemplate restTemplate = new RestTemplate();
    ApiResponse apiResponse = restTemplate
        .getForObject("http://gateway.marvel.com/v1/public/characters" + requestString,
            ApiResponse.class);
    return apiResponse;

  }
}
