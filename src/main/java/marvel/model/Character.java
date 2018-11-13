package marvel.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character
{
	private int id;

	private String name;

	private String description;

	private Date modified;

	private String resourceURI;

	public Character() {}

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
