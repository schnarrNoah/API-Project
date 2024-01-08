package FPA3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
/*
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
//import org.json.JSONObject;
*/
public class Api implements DataTransfer
{
	String url = "https://api.openai.com/v1/chat/completions";
	String apiKey = "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";
	String model = "gpt-3.5-turbo";

	StringBuffer response = null;
	String answer = null;
	URL u;
	HttpURLConnection con;

	// Set
	// connection========================================================================================
	public Api()
	{
		try
		{
			response = new StringBuffer();
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();

			int responseCode = con.getResponseCode();
			
			if (con != null && responseCode == HttpURLConnection.HTTP_OK)
			{
				System.out.println("HTTP-Verbindung OK :)");
				con.setRequestMethod("POST");
				con.setRequestProperty("Authorization", "Bearer " + apiKey);
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
			} 
			else
			{
				System.out.println("Keine HTTP-Verbindung hergestellt :( \n ERRORCODE: " + responseCode);
				answer = "ERRORCODE: " + responseCode;
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	
	// Send message
	// ==========================================================================================================
	public void sendData(String message)
	{
		String introduction = "Check Mail auf Phishing. "
				+ "Das Format deiner Antwort soll so aufgebaut sein: "
				+ "Gib Wahrscheinlichkeit in %, eine kurze, präzise Einschätzung. Die Mail lautet: ";

		message = message.replace("\n", " ");
		message = message.replace("\r", " ");

		String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" 
				+ introduction + " " + message + "\"}]}";

		System.out.println(body);

		try
		{
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());

			try
			{
				out.write(body);
			} 
			catch (IOException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			} 
			finally
			{
				// Writes everything into stream and close it
				out.flush();
				out.close();
			}
		} 
		catch (IOException eOUT)
		{
			System.out.println(eOUT.getMessage());
		}
	}

	
	// Get Response
	// ==========================================================================================================
	public String getData()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;

			try
			{
				while ((line = in.readLine()) != null)
				{
					response.append(line);
				}
				System.out.println("RESPONSE: " + response);
			} 
			catch (IOException e)
			{
				System.out.println(e.getMessage());
			} 
			finally
			{
				in.close();
			}
		} 
		catch (IOException eIN)
		{
			System.out.println(eIN.getMessage());
		}

		if (response != null)
		{
			Response r = new Response(response);
		} 
		else
		{
			answer = "No content found in response.";
		}

		return answer;
	}
}
