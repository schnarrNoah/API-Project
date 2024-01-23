package FPA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class LoginGUI extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_2;
	private JLabel lblDeveloper;
	private JLabel lblBackgroundLogin;

	public void setRegisterListner(ActionListener a)
	{
		this.btnNewButton.addActionListener(a);
	}

	public void setLoginListner(ActionListener a)
	{
		this.btnNewButton_1.addActionListener(a);
	}

	public LoginGUI()
	{
		initialize();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTextField());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getPasswordField());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblDeveloper());
		contentPane.add(getLblBackgroundLogin());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null)
		{
			lblNewLabel = new JLabel("Username");
			lblNewLabel.setForeground(Color.GREEN);
			lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
			lblNewLabel.setBounds(21, 102, 98, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null)
		{
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setForeground(Color.GREEN);
			lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
			lblNewLabel_1.setBounds(21, 159, 98, 14);
		}
		return lblNewLabel_1;
	}

	protected JTextField getTextField()
	{
		if (textField == null)
		{
			textField = new JTextField();
			textField.setForeground(Color.RED);
			textField.setBackground(Color.BLACK);
			textField.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
			textField.setBounds(145, 99, 382, 23);
			textField.setColumns(10);
		}
		return textField;
	}

	private JButton getBtnNewButton()
	{
		if (btnNewButton == null)
		{
			btnNewButton = new JButton("SIGN UP");
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));

			btnNewButton.setBounds(21, 278, 115, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnNewButton_1()
	{
		if (btnNewButton_1 == null)
		{
			btnNewButton_1 = new JButton("SIGN IN");
			btnNewButton_1.setForeground(Color.RED);
			btnNewButton_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));

			btnNewButton_1.setBounds(412, 278, 115, 23);
		}
		return btnNewButton_1;
	}

	protected JPasswordField getPasswordField()
	{
		if (passwordField == null)
		{
			passwordField = new JPasswordField();
			passwordField.setBackground(Color.BLACK);
			passwordField.setForeground(Color.RED);
			passwordField.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
			passwordField.setBounds(148, 156, 379, 23);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("WELCOME TO SecurePhish API");
			lblNewLabel_2.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 30));
			lblNewLabel_2.setForeground(Color.GREEN);
			lblNewLabel_2.setBounds(34, 11, 487, 58);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblDeveloper() {
		if (lblDeveloper == null) {
			lblDeveloper = new JLabel(" Java project  developed by Lukas Lang and Noah Schnarr");
			lblDeveloper.setForeground(Color.WHITE);
			lblDeveloper.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 10));
			lblDeveloper.setBounds(110, 312, 343, 23);
		}
		return lblDeveloper;
	}
	private JLabel getLblBackgroundLogin() {
		if (lblBackgroundLogin == null) {
			lblBackgroundLogin = new JLabel("");
			lblBackgroundLogin.setIcon(new ImageIcon("C:\\Users\\nvinc\\OneDrive\\Desktop\\PROGS\\phishingLogin_sharkbackground.jpg"));
			lblBackgroundLogin.setBounds(0, 0, 565, 342);
		}
		return lblBackgroundLogin;
	}
}