package marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.jackson.JsonComponent;

import java.util.Date;
import java.util.Objects;

@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character
{
	private String id;

	private String marvelApiId;

	private String name;

	private String description;

	private Date modified;

	private String resourceURI;

	public String getId()
	{
		return id;
	}

	public String getMarvelApiId() {
		return marvelApiId;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public Date getModified()
	{
		return modified;
	}

	public String getResourceURI()
	{
		return resourceURI;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setMarvelApiId(String marvelApiId) {
		this.marvelApiId = marvelApiId;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setModified(Date date)
	{
		this.modified = date;
	}

	public void setResourceURI(String resourceURI)
	{
		this.resourceURI = resourceURI;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Character character = (Character) o;
		return id == character.id &&
				Objects.equals(name, character.name) &&
				Objects.equals(description, character.description) &&
				Objects.equals(modified, character.modified) &&
				Objects.equals(resourceURI, character.resourceURI);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, modified, resourceURI);
	}

	@Override
	public String toString() {
		return "Character{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", modified=" + modified +
				", resourceURI='" + resourceURI + '\'' +
				'}';
	}
}
