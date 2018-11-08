package marvel.marvelobjects;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hero implements Character
{
	private int id;

	private String name;

	private String description;

	private Date modified;

	private String resourceURI;

	public Hero() {}

	public Hero(String name) {
		this.name = name;
	}

	public Hero(int id, String name, String description)	{

		this.id = id;

		this.name = name;

		this.description = description;
	}

	public int getId()
	{
		return id;
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

	public void setId(int id)
	{
		this.id = id;
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

}
