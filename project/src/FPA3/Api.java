package FPA3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
//import org.json.JSONObject;


public class Api implements DataTransfer
{
	String url = "https://api.openai.com/v1/chat/completions";
	String apiKey = "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";
	String model = "gpt-3.5-turbo";
	StringBuffer response = null;
	String answer = null;
	URL u;
	HttpURLConnection con;
	
	
	public Api() //Set connection
	{
		try
		{
			response = new StringBuffer();
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			
			if(con == null)
			{
				System.out.println("Keine HTTP-Verbindung hergestellt");
			}
			else
			{
				System.out.println("Verbindung hergestellt!");
				con.setRequestMethod("POST");
				con.setRequestProperty("Authorization", "Bearer " + apiKey);
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);	
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public void sendData(String message) //Send message
	{		
		String introduction = "Check Mail auf Phishing. Das Format deiner Antwort soll so aufgebaut sein: Gib Wahrscheinlichkeit in %, eine kurze, präzise Einschätzung. Die Mail lautet: ";
		
		message = message.replace("\n", " "); 
		message = message.replace("\r", " "); 
		
		String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + introduction + " " + message + "\"}]}";
		
		System.out.println(body);
		
		try
		{
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
			
			try
			{
				out.write(body);
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				out.flush();// Schreibt alles in den Stream und nicht in einen Pufferspeicher
				out.close();// Schließt den Stream und gibt ressourcen frei
			}
		}
		catch(IOException eOUT)
		{
			System.out.println(eOUT.getMessage());
		}
	}
	
	public String getData()	//Get Response
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			
			try
			{
				while((line = in.readLine()) != null)
				{
					response.append(line);
				}
				System.out.println("RESPONSE: " + response);
			}
			catch(IOException e)
			{
				System.out.println(e.getMessage());
			}
			finally
			{
				in.close();
			}
		}
		catch(IOException eIN)
		{
			System.out.println(eIN.getMessage());
		}
		
		/*
		if(response != null)
		{	
			try (JsonReader reader = Json.createReader(new StringReader(String.valueOf(response)))) 
			{
	            JsonObject jsonObject = reader.readObject();
	            answer = jsonObject.getJsonArray("choices").getJsonObject(0).getJsonObject("message").getString("content");
	        } 
			catch (Exception e) 
			{
	            e.printStackTrace();
	        }
		}
		else
		{
			answer = "No content found in response.";
		}
		
		if (response.toString().contains("\"content\":\""))
		{
			answer = response.toString().split("\"content\":\"")[1].split("\"")[0].substring(4);	
		} 
		else
		{
			answer = "No content found in response.";
		}
		*/
		
		
		if(response != null)
		{	
			String responseStr = String.valueOf(response);
			responseStr = responseStr.replaceAll("\\s+", "");

	        String content = responseStr.substring(responseStr.indexOf("\"content\":\"") + 11);
	        answer = content.substring(0, content.indexOf("\""));
		}
		else
		{
			answer = "No content found in response.";
		}
		
		
		
		return answer;
	}
}
