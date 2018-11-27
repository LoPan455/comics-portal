package marvel.model;

public class ComicApiResponse
{
	private int code;

	private String status;

	private String copyright;

	private String attributionText;

	private String attributionHTML;

	private ComicDataContainer data;

	private String etag;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public ComicDataContainer getData()
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

	public void setData(ComicDataContainer data)
	{
		this.data = data;
	}

	public String getCopyright() {
		return copyright;
	}
}
