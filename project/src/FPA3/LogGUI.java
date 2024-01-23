package FPA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class LogGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cmbDate;
	private JTextArea txtlogResponse;
	private JLabel TitleLog;
	private JLabel lblUser;

	public void setDateBoxListner(ActionListener a)
	{
		this.cmbDate.addActionListener(a);
	}

	public LogGUI()
	{
		initialize();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 867, 529);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(getCmbDate());
		contentPane.add(getTxtlogResponse());
		contentPane.add(getTitleLog());
		contentPane.add(getLblUser());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected JComboBox getCmbDate()
	{
		if (cmbDate == null)
		{
			cmbDate = new JComboBox();
			cmbDate.setBackground(Color.LIGHT_GRAY);

			cmbDate.setBounds(599, 11, 242, 22);
		}
		return cmbDate;
	}

	protected JTextArea getTxtlogResponse()
	{
		if (txtlogResponse == null)
		{
			txtlogResponse = new JTextArea();
			txtlogResponse.setFont(new Font("OCR A Extended", Font.BOLD, 14));
			txtlogResponse.setForeground(Color.RED);
			txtlogResponse.setBackground(Color.BLACK);
			txtlogResponse.setBounds(10, 51, 831, 428);
			txtlogResponse.setLineWrap(true);
		}
		return txtlogResponse;
	}

	private JLabel getTitleLog()
	{
		if (TitleLog == null)
		{
			TitleLog = new JLabel("SHOW LOG FILE");
			TitleLog.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
			TitleLog.setBounds(10, 7, 127, 29);
		}
		return TitleLog;
	}

	protected JLabel getLblUser()
	{
		if (lblUser == null)
		{
			lblUser = new JLabel("user");
			lblUser.setFont(new Font("Lucida Console", Font.BOLD, 15));
			lblUser.setBounds(361, 11, 228, 22);
		}
		return lblUser;
	}
}