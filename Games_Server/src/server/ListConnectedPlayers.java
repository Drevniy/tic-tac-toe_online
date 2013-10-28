package server;

import java.util.ArrayList;

public class ListConnectedPlayers {
		
	private static ArrayList<Player> listConnectedPlayers = new ArrayList<>();
	
	public static synchronized ArrayList<Player> getList() {
		return listConnectedPlayers;
	}

}
