package marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic
{

	private int id;

	private String resourceURI;

	private String title;

	public int getId() {
		return id;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public String getTitle() {
		return title;
	}

}
