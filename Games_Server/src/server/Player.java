package server;

import java.net.Socket;

public class Player {
	private String playerName = "";
	private String opponentName = "";
	private Socket socketConnect = null;
	private Socket socketGame = null;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getOpponentName() {
		return opponentName;
	}
	public void setOpponentName(String opponentName) {
		this.opponentName = opponentName;
	}
	public Socket getSocketConnect() {
		return socketConnect;
	}
	public void setSocketConnect(Socket socketConnect) {
		this.socketConnect = socketConnect;
	}
	public Socket getSocketGame() {
		return socketGame;
	}
	public void setSocketGame(Socket socketGame) {
		this.socketGame = socketGame;
	}
	
	
}
