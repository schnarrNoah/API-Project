package FPA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClass
{
	private Gui gui;
	private Api api;
	private LoginGUI login;
	private User user;

	public ControllerClass(User user)
	{
		this.user = user;
		this.gui = new Gui();
		this.api = new Api();

		setControllerListeners();
	}

	// LISTENERS
	// ======================================================================================

	public void setControllerListeners()
	{
		gui.setBtnSend(new AClass_Send());
		gui.setBtnLog(new AClass_Log());
		gui.setBtnSave(new AClass_Save());
	}

	class AClass_Send implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			gui.getTaOutput().setText("");
			send_show_message();
		}
	}

	class AClass_Log implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			new LogController(user);
		}
	}
	
	class AClass_Save implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Log log = new Log(gui.getTaOutput().getText());
			DH h = null;
			
			if (gui.getRadioIO().isSelected())
			{
				h = new DHIO(user);
			} else if (gui.getRadioNIO().isSelected())
			{
				h = new DHNIO(user);
			} else if (gui.getRadioSer().isSelected())
			{
				h = new DHSER(user);
			}

			if (h != null)
			{
				h.schreiben(log);		
			} else
			{
				System.out.println("\nPlease select a radio button first!");
			}
		}
	}


	// FUNKTIONS
	// =======================================================================================
	// =======================================================================================
	// =======================================================================================

	public void send_show_message()
	{
		// SEND REQUEST
		// -----------------------------------------------------------------------
		api.sendData(gui.getTaInput().getText());

		// GET RESPONSE
		// -----------------------------------------------------------------------
		String ans = api.getData();

		gui.getTaOutput().setText(ans);
		gui.getLblProbability_out().setText(getProbability(ans));

	}

	// =======================================================================================
	// =======================================================================================
	// =======================================================================================

	public String getProbability(String ans)
	{
		String probability = ans.replaceAll("[^\\d]", ""); // Only 0-9
		int prob = Integer.parseInt(probability);

		if (prob > 100) // ERROR (100 kann nicht beachtet werden)
		{
			gui.getLblProbability().setText("ERROR!");
			gui.getLblProbability_out().setVisible(false);
		}

		return probability + "%";
	}

}
