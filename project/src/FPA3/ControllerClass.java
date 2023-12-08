package FPA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerClass
{
	Gui g;
	
	public ControllerClass()
	{
		this.g = new Gui();
		setListeners();
	}
	
	
	//LISTENERS===============================================================================
	
	public void setListeners()
	{
		g.setBtnSend(new AClass_Send());
	}
	class AClass_Send implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			sendData();
		}	
	}
	
	
	
	public void sendData()
	{
		
	}
}
