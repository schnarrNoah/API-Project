package FPA3;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log implements Serializable
{
	private static final long serialVersionUID = 8919506482633769846L;
	private Date date;
	private String response;

	public Log(Date date, Response response)
	{
		this.date = date;
		this.response = response.getResponse();
	}

	public Log(String string)
	{
		this.date = new Date(System.currentTimeMillis());
		this.response = string;
	}

	public Log(String dateStr, String response) throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date = dateFormat.parse(dateStr);
		this.response = response;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getResponse()
	{
		return response;
	}

	public void setResponse(Response response)
	{
		this.response = response.getResponse();
	}

	/*
	 * @Override public String toString() { SimpleDateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); return dateFormat.format(date); }
	 */
}

/*
 * 
 * package FPA3;
 * 
 * import java.time.LocalDate;
 * 
 * public class Log { private LocalDate date; private Response response; private
 * Request request;
 * 
 * 
 * public Log(LocalDate date, Request request, Response response) { super();
 * this.date = date; this.response = response; this.request = request; }
 * 
 * 
 * @Override public String toString() { return date + ":\nRequest\t[" + request
 * + "]" + "\nResponse\t[" + response + "]\n\n"; }
 * 
 * 
 * }
 */
