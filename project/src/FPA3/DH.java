package FPA3;
/*
import java.io.BufferedWriter;
import java.util.ArrayList;
*/
public abstract class DH
{
	protected User user;

	public DH(User user)
	{
		this.user = user;
	}

	public abstract void schreiben(Log log);

	public abstract void lesen();

}