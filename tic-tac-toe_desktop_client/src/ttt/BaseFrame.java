package ttt;

import java.awt.CardLayout;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class BaseFrame extends JFrame
{
	public final static String stringAuthorization = "panelAuthorization";
	public final static String stringRegistration = "panelRegistration";
	public final static String stringPlayersOnline = "panelPlayersOnline";
	public final static String stringTopPlayers = "panelTopPlayers";
	public final static String stringPlayerStatistic = "panelPlayerStatistic";
	public final static String stringGameList = "panelGameList";
	public final static String stringGame = "panelGame";
	public final static String stringGameOver = "panelGameOver";
	CardLayout cards;
	private static String userName;
	private static Socket socketConnect;
	 
	public BaseFrame()
	{
		createConnect();
		
		setBounds(320, 200, 450, 425);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic-Tac-Toe");
		cards = new CardLayout();
		setLayout(cards);
		
		PanelAuthorization panelAuthorization = new PanelAuthorization();
		PanelRegistration panelRegistration = new PanelRegistration();
		PanelGameList panelGameList = new PanelGameList();
		PanelTopPlayers panelTopPlayers = new PanelTopPlayers();
		PanelPlayerStatistic panelPlayerStatistic  = new PanelPlayerStatistic();
		PanelPlayersOnline panelPlayersOnline = new PanelPlayersOnline();
		PanelGame panelGame = new PanelGame();
		PanelGameOver panelGameOver = new PanelGameOver();
		
		this.add(stringAuthorization,panelAuthorization);
		this.add(stringRegistration,panelRegistration);
		this.add(BaseFrame.stringGameList,panelGameList);
		this.add(stringTopPlayers,panelTopPlayers);
		this.add(stringPlayerStatistic,panelPlayerStatistic);
		this.add(BaseFrame.stringPlayersOnline,panelPlayersOnline);
		this.add(stringGame,panelGame);
		this.add(stringGameOver,panelGameOver);
		
		Thread thread = new Thread(new InputWorker());
		thread.start();
		
		setVisible(true);
		
	}
	
	private void createConnect() {
		try {
			socketConnect = new Socket("127.0.0.1",7000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Security.setSocketConnect(socketConnect);
		
	}

	public CardLayout getCards()
	{
		return cards;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userNameIn) {
		userName = userNameIn;
	}

	public static Socket getSocketConnect() {
		return socketConnect;
	}

}
