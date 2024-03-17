package FPA3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import javax.net.ssl.HttpsURLConnection;

public class Api implements DataTransfer
{
	private String url = "https://api.openai.com/v1/chat/completions";
	private String apiKey = "";
	private String model = "gpt-3.5-turbo";

	private StringBuffer response = null;
	private String answer = null;
	private URL u;
	private HttpURLConnection con;

	public Api()
	{
		setConnection();
	}

	// Set connection
	// ========================================================================================
	public void setConnection()
	{
		try
		{
			response = new StringBuffer();
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();

			if (con != null /* && con.getResponseCode() != HttpsURLConnection.HTTP_NOT_FOUND */)
			{

				System.out.println("HTTP-Verbindung hergestellt :)");

				con.setRequestMethod("POST");
				con.setRequestProperty("Authorization", "Bearer " + apiKey);
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
			} else
			{
				System.out.println("Keine HTTP-Verbindung hergestellt :(");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	// Send Request
	// ==========================================================================================================

	public void sendData(String message)
	{
		setConnection();
		
		Request request = new Request(message);

		String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + request
				+ "\"}]}";

		System.out.println("\nREQUEST: " + body);

		try
		{
			OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());

			// Actual sending body
			try
			{
				out.write(body);
			} catch (IOException eOUT1)
			{
				System.out.println("Error in sendData()-eOUT1: " + eOUT1.getMessage());
				eOUT1.printStackTrace();
			} finally
			{
				// Everything into stream and close it
				System.out.println("\tSENDING DATA COMPLETE...");
				out.flush();
				out.close();
			}
		} catch (IOException eOUT2)
		{
			System.out.println("Error in sendData()-eOUT2: " + eOUT2.getMessage());
		}
	}

	// Get Response
	// ==========================================================================================================

	public String getData()
	{
		StringBuffer responseBuffer = new StringBuffer();

		try
		{
			BufferedReader in = null;
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;

			try
			{
				while ((line = in.readLine()) != null)
				{
					responseBuffer.append(line);
				}
				System.out.println("\nRESPONSE: " + responseBuffer);
			} catch (IOException eIN1)
			{
				System.out.println("Error in getData()-eIN1: " + eIN1.getMessage());
			} finally
			{
				System.out.println("\t...GETTING DATA COMPLETE");
				in.close();
			}		
		} catch (IOException eIN2)
		{
			System.out.println("Error in getData()-eIN2: " + eIN2.getMessage());
		}
		

		if (responseBuffer != null)
		{

			Response r = new Response(responseBuffer);
			answer = r.getContent();

			/*
			 * Log log = new Log(LocalDate.now(), request, response);
			 */
			// answer = String.valueOf(responseBuffer);
		} else
		{
			answer = "No content found in response.";
		}

		return answer;
	}
}
