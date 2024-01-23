package FPA3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class DHNIO extends DH
{
	private User user;
	private ArrayList<Log> logs = new ArrayList<>();

	public DHNIO(User user)
	{
		super(user);
		this.user = user;
	}

	public ArrayList<Log> getLogs()
	{
		return logs;
	}

	public void schreiben(Log log)
	{
		Path filePath = Paths.get(user.getUsername() + "_log.txt");
		if (!Files.exists(filePath))
		{
			try
			{
				Files.createFile(filePath);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			System.out.println("TEST: " + user.getUsername());
			BufferedWriter out = Files.newBufferedWriter(Paths.get(user.getUsername() + "_log.txt"),
					StandardOpenOption.APPEND);

			try
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String formattedDate = dateFormat.format(log.getDate());

				String r = log.getResponse().replace("\n", " ");

				String logE = formattedDate + ';' + r + ';';
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

	@Override

	public void lesen()
	{
		try (BufferedReader in = Files.newBufferedReader(Paths.get(user.getUsername() + "_log.txt")))
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
