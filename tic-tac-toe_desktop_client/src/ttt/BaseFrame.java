package ttt;

import javax.swing.JFrame;

public class BaseFrame extends JFrame
{
	public BaseFrame()
	{
		setBounds(320, 200, 450, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		
		
		setVisible(true);
	}
}
