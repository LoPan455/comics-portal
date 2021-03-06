package marvel.model;

import org.springframework.boot.jackson.JsonComponent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse
{
	private int code;

	private String status;

	private String copyright;

	private String attributionText;

	private String attributionHTML;

	private CharacterDataContainer data;

	private String etag;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public CharacterDataContainer getData()
	{
		return data;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getCopywright()
	{
		return copyright;
	}

	public void setCopyright(String copyright)
	{
		this.copyright = copyright;
	}

	public String getAttributionText()
	{
		return attributionText;
	}

	public void setAttributionText(String attributionText)
	{
		this.attributionText = attributionText;
	}

	public String getAttributionHTML()
	{
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML)
	{
		this.attributionHTML = attributionHTML;
	}

	public String getEtag()
	{
		return etag;
	}

	public void setEtag(String etag)
	{
		this.etag = etag;
	}

	public void setData(CharacterDataContainer data)
	{
		this.data = data;
	}

	public String getCopyright() {
		return copyright;
	}
}
