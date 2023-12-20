/*package FPA3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request
{

 
	public static char delimeter = '#';
	private String url;
	private String apiKey;
	private URL urlO;
	private HttpURLConnection connection;
	private HttpMethods requestMode;
	protected String inputData;
	
	public Request(String url, String apiKey, HttpMethods httpMethod)
	{
		this.url = url;
        this.apiKey = apiKey;
        
		
        try
		{
			urlO = new URL(url);
	        connection = (HttpURLConnection) urlO.openConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 
        
        // Set the input data
        try
        {
        	urlO = new URL(url);
            connection = (HttpURLConnection) urlO.openConnection();
 
            // Set the request method
            System.out.println(httpMethod.toString());
            connection.setRequestMethod(httpMethod.toString());
 
            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            
            
            if(url.contains("pinecone"))
            {
            	 connection.setRequestProperty("Api-Key", apiKey);
            }
            else 
            {
            	connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            }

 
            // Enable input/output streams
            connection.setDoOutput(true);
            System.out.println("successfully set");
 
          
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        // Create URL object
	}

	public String FireRequest(String[] message)
	{
		String[] arrStr = inputData.split(String. valueOf(delimeter));
		//String toSend = arrStr[0] + message + arrStr[1];
		//System.out.println(toSend);
		String toSend = generateFinaleMessage(message);
		System.out.println(toSend);
		try
		{
			try (DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
	            wr.writeBytes(toSend);
	            wr.flush();
	        }
 
	        // Get the response code
	        int responseCode = connection.getResponseCode();
	        System.out.println("Response Code: " + responseCode);
 
	        // Read the response
	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	            String inputLine;
	            StringBuilder response = new StringBuilder();
 
	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }
 
	            // Print the response
	           return response.toString();
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	public String generateFinaleMessage(String[] arrStr)
	{
		String[] arrStr2 = inputData.split(String. valueOf(delimeter));
		String message = "";
		for(int i = 0; i < arrStr.length;i++)
		{
			message += arrStr2[i] + arrStr[i];
		}
		message += arrStr2[arrStr2.length - 1];
		return message;
	}
}*/
