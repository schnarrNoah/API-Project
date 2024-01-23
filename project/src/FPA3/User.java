package FPA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User
{
	private LoginGUI gui;

	private String username;
	private HashSHA256 password;

	public User()
	{
		gui = new LoginGUI();
		setUserListeners();
	}

	// GETTER & SETTER
	// =============================================================================================

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public HashSHA256 getPassword()
	{
		return password;
	}

	public void setPassword(HashSHA256 password)
	{
		this.password = password;
	}

	// LISTENERS
	// =============================================================================================

	public void setUserListeners()
	{
		this.gui.setRegisterListner(new Class_Register());
		this.gui.setLoginListner(new Class_Login());
	}

	class Class_Register implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			registerUser();
		}
	}

	class Class_Login implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			loginUser();
		}
	}

	// METHODS
	// =============================================================================================

	private void registerUser()
	{
		username = this.gui.getTextField().getText();
		password = new HashSHA256(String.valueOf(gui.getPasswordField().getPassword()));

		if (userExists(username))
		{
			System.out.println("Benutzername existiert bereits");
		} else
		{

			try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true)))
			{
				writer.write(username + ";" + password);
				writer.newLine();

				System.out.println("Benutzer erfolgreich registriert");
			} catch (IOException e)
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}
	}

	private void loginUser()
	{
		username = this.gui.getTextField().getText();
		password = new HashSHA256(String.valueOf(gui.getPasswordField().getPassword()));

		if (checkUser(username, password))
		{
			new ControllerClass(this);
			System.out.println("Login erfolgreich");
		} else
		{
			System.out.println("Ungültige Anmeldedaten: usr:" + username + " passwd:" + password);
		}
	}

	private boolean userExists(String username)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader("users.txt")))
		{
			String line = null;

			while ((line = reader.readLine()) != null)
			{
				String[] parts = line.split(";");
				if (parts[0].equals(username))
				{
					return true;
				}

			}
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	private boolean checkUser(String username, HashSHA256 password)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader("users.txt")))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] data = line.split(";");

				if (data[0].equals(username) && data[1].equals(String.valueOf(password)))
				{
					return true;
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
}
