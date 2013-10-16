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
	public static String stringAuthorization = "panelAuthorization";
	public static String stringRegistration = "panelRegistration";
	public static String stringPlayersOnline = "panelPlayersOnline";
	public static String stringTopPlayers = "panelTopPlayers";
	public static String stringGame = "panelGame";
	public static String stringGameOver = "panelGameOver";
	CardLayout cards;
	 
	public BaseFrame()
	{
		setBounds(320, 200, 450, 425);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		cards = new CardLayout();
		setLayout(cards);
		
		PanelAuthorization panelAuthorization = new PanelAuthorization();
		PanelRegistration panelRegistration = new PanelRegistration();
		PanelPlayersOnline panelPlayersOnline = new PanelPlayersOnline();
		PanelTopPlayers panelTopPlayers = new PanelTopPlayers();
		PanelGame panelGame = new PanelGame();
		PanelGameOver panelGameOver = new PanelGameOver();
		
		
		this.add(stringAuthorization,panelAuthorization);
		this.add(stringRegistration,panelRegistration);
		this.add(stringPlayersOnline,panelPlayersOnline);
		this.add(stringTopPlayers,panelTopPlayers);
		this.add(stringGame,panelGame);
		this.add(stringGameOver,panelGameOver);
		
		
		setVisible(true);
	}
	
	public CardLayout getCards()
	{
		return cards;
	}
}
