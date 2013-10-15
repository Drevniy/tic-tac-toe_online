package ttt;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseFrame extends JFrame
{
	public BaseFrame()
	{
		setBounds(320, 200, 450, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		
		Panel_Registration panelRegistration = new Panel_Registration();
		add(panelRegistration,BorderLayout.CENTER);
		panelRegistration.setVisible(true);
		
		setVisible(true);
	}
}
