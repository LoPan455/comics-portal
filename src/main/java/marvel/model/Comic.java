package marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

@Data
@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comic
{

	private int id;

	private String resourceURI;

	private String title;

}
