package FPA3;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DHSER extends DH implements Serializable
{

	private static final long serialVersionUID = 1375939703452677131L;
	private ArrayList<Log> logs = new ArrayList<>();

	public DHSER(User user)
	{
		super(user);
	}

	public ArrayList<Log> getLogs()
	{
		return logs;
	}

	@Override
	public void schreiben(Log log)
	{
		lesen();
		logs.add(log);

		try (FileOutputStream fos = new FileOutputStream(user.getUsername() + "_SERlog.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos))
		{

			oos.writeObject(logs);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void lesen()
	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(user.getUsername() + "_SERlog.txt")))
		{
			Object obj = ois.readObject();

			if (obj instanceof ArrayList)
			{
				logs = (ArrayList<Log>) obj;
			}

		} catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		} catch (EOFException e)
		{
			System.out.println(e.getMessage());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
