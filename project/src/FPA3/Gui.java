package FPA3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnSend;
	private JLabel lblProbability_out;
	private JLabel lblProbability;
	private JTextArea taOutput;
	private JTextArea taInput;
	private JLabel lblTitleName;
	private JRadioButton RadioIO;
	private JRadioButton RadioNIO;
	private JRadioButton RadioSer;
	private JButton btnLog;
	private JButton btnSpeichern;
	private JLabel lblBackground;

	public Gui()
	{
		initialize();
	}

	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 640);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTitleName());
		contentPane.add(getBtnSend());
		contentPane.add(getLblProbability_out());
		contentPane.add(getLblProbability());
		contentPane.add(getTaOutput());
		contentPane.add(getTaInput());
		contentPane.add(getRadioIO());
		contentPane.add(getRadioNIO());
		contentPane.add(getRadioSer());
		ButtonGroup group = new ButtonGroup();
		group.add(RadioIO);
		group.add(RadioNIO);
		group.add(RadioSer);
		contentPane.add(getBtnLog());
		contentPane.add(getRadioIO());
		contentPane.add(getRadioNIO());
		contentPane.add(getRadioSer());
		contentPane.add(getBtnLog());
		contentPane.add(getBtnSpeichern());
		contentPane.add(getLblBackground_1());
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// LISTENERS
	// ===================================================================================================

	public void setBtnSend(ActionListener a)
	{
		this.btnSend.addActionListener(a);
	}

	public void setBtnLog(ActionListener a)
	{
		this.btnLog.addActionListener(a);
	}
	public void setBtnSave(ActionListener a)
	{
		this.btnSpeichern.addActionListener(a);
	}
	
	private JButton getBtnSend()
	{
		if (btnSend == null)
		{
			btnSend = new JButton("ANALYSE");
			btnSend.setForeground(Color.RED);
			btnSend.setBackground(Color.LIGHT_GRAY);
			btnSend.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
			btnSend.setBounds(730, 282, 144, 23);
		}
		return btnSend;
	}

	protected JLabel getLblProbability_out()
	{
		if (lblProbability_out == null)
		{
			lblProbability_out = new JLabel("%");
			lblProbability_out.setForeground(new Color(26, 255, 37));
			lblProbability_out.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
			lblProbability_out.setBounds(405, 275, 66, 30);
		}
		return lblProbability_out;
	}

	protected JLabel getLblProbability()
	{
		if (lblProbability == null)
		{
			lblProbability = new JLabel("Probability:");
			lblProbability.setForeground(new Color(26, 255, 37));
			lblProbability.setBackground(new Color(255, 255, 255));
			lblProbability.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
			lblProbability.setBounds(259, 277, 136, 30);
		}
		return lblProbability;
	}

	protected JTextArea getTaOutput()
	{
		if (taOutput == null)
		{
			taOutput = new JTextArea();
			taOutput.setEditable(false);
			taOutput.setForeground(Color.GREEN);
			taOutput.setBackground(new Color(0, 0, 0));
			taOutput.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
			taOutput.setBounds(259, 318, 615, 272);
		}
		return taOutput;
	}

	protected JTextArea getTaInput()
	{
		if (taInput == null)
		{
			taInput = new JTextArea();
			taInput.setForeground(Color.GREEN);
			taInput.setBackground(new Color(0, 0, 0));
			taInput.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
			taInput.setBounds(259, 11, 615, 259);
		}
		return taInput;
	}

	protected JLabel getLblTitleName()
	{
		if (lblTitleName == null)
		{
			lblTitleName = new JLabel("SecurePhish API");
			lblTitleName.setForeground(new Color(0, 255, 0));
			lblTitleName.setFont(new Font("OCR A Extended", Font.BOLD, 23));
			lblTitleName.setBounds(19, 11, 230, 49);
		}
		return lblTitleName;
	}

	protected JRadioButton getRadioIO()
	{
		if (RadioIO == null)
		{
			RadioIO = new JRadioButton("IO");
			RadioIO.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
			RadioIO.setBounds(140, 83, 109, 23);
		}
		return RadioIO;
	}

	protected JRadioButton getRadioNIO()
	{
		if (RadioNIO == null)
		{
			RadioNIO = new JRadioButton("NIO");
			RadioNIO.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
			RadioNIO.setBounds(140, 109, 109, 23);
		}
		return RadioNIO;
	}

	protected JRadioButton getRadioSer()
	{
		if (RadioSer == null)
		{
			RadioSer = new JRadioButton("SER");
			RadioSer.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
			RadioSer.setBounds(140, 135, 109, 23);
		}
		return RadioSer;
	}

	protected JButton getBtnLog()
	{
		if (btnLog == null)
		{
			btnLog = new JButton("SHOW LOG");
			btnLog.setForeground(Color.BLUE);
			btnLog.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 10));
			btnLog.setBackground(Color.WHITE);
			btnLog.setBounds(140, 567, 109, 23);
		}
		return btnLog;
	}

	protected JButton getBtnSpeichern()
	{
		if (btnSpeichern == null)
		{
			btnSpeichern = new JButton("SAVE FOR LOG");
			btnSpeichern.setForeground(Color.BLUE);
			btnSpeichern.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 10));
			btnSpeichern.setBounds(140, 533, 109, 23);
		}
		return btnSpeichern;
	}

	private JLabel getLblBackground_1()
	{
		if (lblBackground == null)
		{
			lblBackground = new JLabel((String) null);
			lblBackground.setIcon(
					new ImageIcon("C:\\Users\\nvinc\\OneDrive\\Desktop\\PROGS\\phishingAPI_backgroundPic.jpg"));
			lblBackground.setBounds(0, 0, 884, 601);
		}
		return lblBackground;
	}
}
