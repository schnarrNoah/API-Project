package FPA3;

public class ControllerClass
{
	Gui g;
	
	public ControllerClass()
	{
		this.g = new Gui();
	}
	
	public void setListeners()
	{
		g.setBtnSend(new AClass());
	}
	
	
	class AClass() implements ActionListeners
	{
		
	}
}
