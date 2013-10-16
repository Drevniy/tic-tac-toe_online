package ttt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseFrame extends JFrame
{
	public static String stringRegistration = "Panel Registration";
	public static String stringAuthorization = "Panel Authorization";
	 CardLayout cl;
	 
	public BaseFrame()
	{
		setBounds(320, 200, 450, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		setLayout(new CardLayout());
		
		PanelRegistration panelRegistration = new PanelRegistration();
		panelRegistration.setVisible(true);
		
		PanelAuthorization panelAuthorization = new PanelAuthorization();
		panelAuthorization.setVisible(false);
		
		add(stringRegistration,panelRegistration);
		add(stringAuthorization,panelAuthorization);
		
		
		setVisible(true);
	}
}
