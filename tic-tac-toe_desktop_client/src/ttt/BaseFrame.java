package ttt;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class BaseFrame extends JFrame
{
	public static String stringAuthorization = "panelAuthorization";
	public static String stringRegistration = "panelRegistration";
	public static String stringPlayersOnline = "panelPlayersOnline";
	public static String stringTopPlayers = "panelTopPlayers";
	public static String stringPlayerStatistic = "panelPlayerStatistic";
	public static String stringGameList = "panelGameList";
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
		PanelPlayerStatistic panelPlayerStatistic  = new PanelPlayerStatistic();
		PanelGameList panelGameList = new PanelGameList();
		PanelGame panelGame = new PanelGame();
		PanelGameOver panelGameOver = new PanelGameOver();
		
		this.add(stringAuthorization,panelAuthorization);
		this.add(stringRegistration,panelRegistration);
		this.add(stringPlayersOnline,panelPlayersOnline);
		this.add(stringTopPlayers,panelTopPlayers);
		this.add(stringPlayerStatistic,panelPlayerStatistic);
		this.add(stringGameList,panelGameList);
		this.add(stringGame,panelGame);
		this.add(stringGameOver,panelGameOver);
		
		
		setVisible(true);
	}
	
	public CardLayout getCards()
	{
		return cards;
	}
}
