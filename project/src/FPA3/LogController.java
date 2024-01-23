package FPA3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

public class LogController
{

	private LogGUI gui;
	private User user;
	private DHNIO nio;
	private DHSER ser;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private DefaultComboBoxModel<String> cbm_dates = new DefaultComboBoxModel<>();

	public LogController(User user)
	{
		this.user = user;
		this.nio = new DHNIO(user);
		this.ser = new DHSER(user);
		gui = new LogGUI();
		
		gui.getLblUser().setText(user.getUsername());
		loadDatesIntoComboBox();
		setLogListeners();
	}

	public void setLogListeners()
	{
		gui.setDateBoxListner(new DateBoxListener());
	}

	class DateBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String selected = (String) gui.getCmbDate().getSelectedItem();

			try
			{
				Date selectedDate = dateFormat.parse(selected);
				addResponseToArea(selectedDate);
			} catch (ParseException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	private void addResponseToArea(Date stringDate)
	{
		ArrayList<Log> logs = new ArrayList<>();
		nio.lesen();
		logs.addAll(nio.getLogs());
		ser.lesen();
		logs.addAll(ser.getLogs());

		String selectedDateString = dateFormat.format(stringDate);

		for (Log log : logs)
		{
			String logDateString = dateFormat.format(log.getDate());

			if (logDateString.equals(selectedDateString))
			{
				gui.getTxtlogResponse().setText(log.getResponse());
			}
		}
	}

	public void loadDatesIntoComboBox()
	{
		nio.lesen();
		ArrayList<Log> nioLogs = nio.getLogs();
		ser.lesen();
		ArrayList<Log> serLogs = ser.getLogs();

		for (Log log : nioLogs)
		{
			String date = dateFormat.format(log.getDate());
			cbm_dates.addElement(date);
		}

		for (Log log : serLogs)
		{
			String date = dateFormat.format(log.getDate());
			cbm_dates.addElement(date);
		}

		gui.getCmbDate().setModel(cbm_dates);
	}
}
