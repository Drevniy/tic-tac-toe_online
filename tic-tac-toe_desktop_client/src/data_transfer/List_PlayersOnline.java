package data_transfer;

import java.util.ArrayList;


public class List_PlayersOnline {
	final String className  = "List_PlayersOnline";
	
	private ArrayList<String> playersOnlineList = null;

	public ArrayList<String> getPlayersOnlineList() {
		return playersOnlineList;
	}

	public void setGameList(ArrayList<String> playersOnlineList) {
		this.playersOnlineList = playersOnlineList;
	}
	
	
}
