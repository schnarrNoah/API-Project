package FPA3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class DHIO extends DH
{
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private ArrayList<Log> logs = new ArrayList<>();

	public DHIO(User user)
	{
		super(user);

	}

	public void schreiben(Log log)
	{
		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(user.getUsername() + "_log.txt", true));

			try
			{
				String formattedDate = dateFormat.format(log.getDate());
				String logE = formattedDate + ';' + log.getResponse() + ';';
				out.write(logE);
				out.newLine();
			} catch (IOException e1)
			{
				System.out.println(e1.getMessage());
			} finally
			{
				out.close();
			}
		} catch (IOException e2)
		{
			System.out.println(e2.getMessage());
		}
	}

	public void lesen()
	{
		try (BufferedReader in = new BufferedReader(new FileReader(user.getUsername() + "_log.txt")))
		{
			String line = null;
			String full = in.lines().collect(Collectors.joining());
			try
			{

				String[] parts = full.split(";");
				for (int i = 0; i < parts.length; i += 2)
				{
					String dateStr = parts[i];
					String response = parts[i + 1];

					Log log = new Log(dateStr, response);
					logs.add(log);
				}

			} catch (ParseException e)
			{
				e.printStackTrace();
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
