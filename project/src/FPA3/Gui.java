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
import javax.swing.JScrollBar;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSend;
	private JLabel lblProbability_out;
	private JLabel lblProbability;
	private JTextArea taOutput;
	private JTextArea taInput;
	private JScrollBar sbForInput;

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
		contentPane.add(getBtnSend());
		contentPane.add(getLblProbability_out());
		contentPane.add(getLblProbability());
		contentPane.add(getTaOutput());
		contentPane.add(getTaInput());
		contentPane.add(getSbForInput());
		setVisible(true);
	}

	// LISTENERS
	// ===================================================================================================

	public void setBtnSend(ActionListener a)
	{
		this.btnSend.addActionListener(a);
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

	protected JLabel getLblProbability()
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

	protected JTextArea getTaInput()
	{
		if (taInput == null)
		{
			taInput = new JTextArea();
			taInput.setBounds(10, 11, 477, 173);
		}
		return taInput;
	}

	protected JScrollBar getSbForInput()
	{
		if (sbForInput == null)
		{
			sbForInput = new JScrollBar();
			sbForInput.setBounds(497, 11, 17, 173);
		}
		return sbForInput;
	}
}
