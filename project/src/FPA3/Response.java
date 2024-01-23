package FPA3;

import org.json.*;

public class Response
{
	String response;
	
	public Response(StringBuffer response)
	{
		this.response = String.valueOf(response);
	}
	public Response(String response)
	{
		this.response = response;
	}
	
	public String getResponse()
	{
		response = response.toString().replace(';', ' ');
		return response;
	}

	public void setResponse(String response)
	{
		this.response = response;
	}
	
	
	public String getContent()
	{
		String content = null;
		
		try
		{
			JSONObject jsonResp = new JSONObject(response);

			JSONArray choices = jsonResp.getJSONArray("choices");
	        JSONObject firstChoice = choices.getJSONObject(0);	//Takes the first

	        JSONObject message = firstChoice.getJSONObject("message");
			
			if(message.has("content"))
			{
				content = message.getString("content");
			}
			else
			{
				System.out.println("No content in response (Error in: getContent())");
			}	
		}
		catch(JSONException jsonE)
		{
			System.out.println("(No JSON) Wrong typ of response: " + jsonE.getMessage());
		}
		// FORMATTER
		content = formatter(content);
		
		return content;
	}
	
	public String formatter(String content)
	{
		int j = 0;
		int spaceCount = 0;
		StringBuilder formatter = new StringBuilder(content);
		
        for (int i = 0; i < content.length(); i++) 
        {
            if (formatter.charAt(i) == ' ') 
            {
                spaceCount++;
                
                if (spaceCount % 8 == 0 || spaceCount % 8 == 0 && j > 20 && formatter.charAt(i) == ' ') 
                {
                    // Fügen einen Zeilenumbruch nach 10 Leerzeichen ein
                	formatter.insert(i + 1, '\n');
                	j = 0;
                }
            }
            j ++;
        }
        
		return content = String.valueOf(formatter);
	}
	

	@Override
	public String toString()
	{
		String r = String.valueOf(response);
		return r;
	}	
}
