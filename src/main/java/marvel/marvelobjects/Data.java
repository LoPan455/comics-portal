package marvel.marvelobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data
{
	private int offset;

	private int limit;

	private int total;

	private int count;

	private Hero[] results;

	public int getOffset()
	{
		return offset;
	}

	public void setOffset(int offset)
	{
		this.offset = offset;
	}

	public int getLimit()
	{
		return limit;
	}

	public void setLimit(int limit)
	{
		this.limit = limit;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public Hero[] getResults()
	{
		return results;
	}

	public void setResults(Hero[] results)
	{
		this.results = results;
	}


}
