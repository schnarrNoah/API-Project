package FPA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea taInput;
	private JButton btnSend;
	private JLabel lblProbability_out;
	private JLabel lblProbability;
	private JTextArea taOutput;

	public Gui()
	{
		initialize();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(156, 238, 248));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTaInput());
		contentPane.add(getBtnSend());
		contentPane.add(getLblProbability_out());
		contentPane.add(getLblProbability());
		setVisible(true);
		contentPane.add(getTaOutput());
	}

	// LISTENERS
	// ===================================================================================================

	public void setBtnSend(ActionListener a)
	{
		this.btnSend.addActionListener(a);
	}

	// COMPONENTS
	// ===================================================================================================

	protected JTextArea getTaInput()
	{
		if (taInput == null)
		{
			taInput = new JTextArea();
			taInput.setBounds(10, 11, 504, 173);
		}
		return taInput;
	}

	private JButton getBtnSend()
	{
		if (btnSend == null)
		{
			btnSend = new JButton("SEND");
			btnSend.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 13));
			btnSend.setBounds(389, 195, 125, 23);
		}
		return btnSend;
	}

	protected JLabel getLblProbability_out()
	{
		if (lblProbability_out == null)
		{
			lblProbability_out = new JLabel("%");
			lblProbability_out.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
			lblProbability_out.setBounds(112, 234, 66, 30);
		}
		return lblProbability_out;
	}

	private JLabel getLblProbability()
	{
		if (lblProbability == null)
		{
			lblProbability = new JLabel("Probability:");
			lblProbability.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 12));
			lblProbability.setBounds(10, 236, 92, 30);
		}
		return lblProbability;
	}

	protected JTextArea getTaOutput()
	{
		if (taOutput == null)
		{
			taOutput = new JTextArea();
			taOutput.setBounds(10, 277, 504, 155);
		}
		return taOutput;
	}
}
