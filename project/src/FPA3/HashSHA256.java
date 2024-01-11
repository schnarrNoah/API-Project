package FPA3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashSHA256
{
	private String hash = null;
	
	private byte[] hashBytes = null;
	private MessageDigest digest;
	private StringBuilder hexString = new StringBuilder();
	private String hex = null;
	
	
	public HashSHA256(String input)
	{
		this.hash = getHash(input);
	}
	
	public String getHash(String input)
	{
		try
		{
			// Instance SHA-256-hash-algorithm
			digest = MessageDigest.getInstance("SHA-256");
	
			// Convert Input into byte-array
			hashBytes = digest.digest(input.getBytes());
	
			// Convert Byte-Array into hexadecimal string
			for (byte b : hashBytes)
			{
				hex = Integer.toHexString(0xff & b);
				
				if (hex.length() == 1)
				{
					hexString.append('0');
				}
				hexString.append(hex);
			}
	
			// Hashed string
			//System.out.println("SHA-256 Hash: " + hexString.toString());
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		
		return hexString.toString();
	}	
	
	public String toString()
	{
		return hash;
	}
}
