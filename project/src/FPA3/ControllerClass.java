package FPA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClass
{
	Gui gui;
	Api api;

	public ControllerClass()
	{
		this.gui = new Gui();
		this.api = new Api();
		setListeners();
	}

	// LISTENERS
	// ======================================================================================

	public void setListeners()
	{
		gui.setBtnSend(new AClass_Send());
	}

	class AClass_Send implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			send_show_message();
		}
	}

	// FUNKTIONS
	// =======================================================================================
	
	public void send_show_message()
	{
		//SEND REQUEST
		api.sendData(gui.getTaInput().getText());
		String ans = api.getData();
		
		//GET RESPONSE
		gui.getTaOutput().setText(ans);
		gui.getLblProbability_out().setText(String.valueOf(getProbability(ans)) + "%");
	}
	
	
	public int getProbability(String ans)
	{
		String probability = ans.replaceAll("[^\\d]", "");
		int prob = Integer.parseInt(probability);
		
		if(prob > 100) //Error 100 kann nicht beachtet werden
		{
			gui.getLblProbability().setText("ERROR: ");
			return prob;
		}
		
        try 
        {
            return prob;
        } 
        catch (NumberFormatException e) 
        {
        	System.out.println("Keine Zahl in der Antwort gefunden!");
        	return -1;
        }
	}
}
