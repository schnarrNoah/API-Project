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
			showMessage();
		}
	}

	// FUNKTIONS
	// =======================================================================================
	
	public void showMessage()
	{
		api.sendData(gui.getTaInput().getText());
		String ans = api.getData();
		
		gui.getTaOutput().setText(ans);
		gui.getLblProbability_out().setText(String.valueOf(getProbability(ans)));
	}
	
	
	public int getProbability(String ans)
	{
		String probability = ans.replaceAll("[^\\d]", "");

        try 
        {
            int parsedProb = Integer.parseInt(probability);
            return parsedProb;
        } 
        catch (NumberFormatException e) 
        {
        	System.out.println("Keine Zahl in der Antwort gefunden!");
        	return -1;
        }
	}
	
	
	//DataTransfer d = 
}
