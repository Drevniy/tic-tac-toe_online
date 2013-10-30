package ttt;

import data_transfer.*;

public class InputDataWorker implements Runnable
{
	String jsonString;
	
	public InputDataWorker(String jsonString) {
		this.jsonString = jsonString;
	}
	
	@Override
	public void run() {
		String[] parts = jsonString.split("\"");
	     
	     switch(parts[3].trim())
	     {
		     case "List_Game": inList_Game();break;
		     case "List_PlayersOnline": inList_PlayersOnline();break;
		     case "List_PlayerStatistic": inList_PlayerStatistic();break;
		     case "List_TopPlayers": inList_TopPlayers();break;
		     case "OfferGame": inOfferGame();break;
		     case "Security_Authorization": inSecurity_Authorization();break;
		     case "Security_Registration": inSecurity_Registration();break;
	     }
	}

	private void inList_Game() {
		// TODO Auto-generated method stub
		
	}
	
	private void inSecurity_Registration() {
		// TODO Auto-generated method stub
		
	}
	
	private void inSecurity_Authorization() {
		// TODO Auto-generated method stub
		
	}
	
	private void inOfferGame() {
		// TODO Auto-generated method stub
		
	}
	
	private void inList_TopPlayers() {
		// TODO Auto-generated method stub
		
	}
	
	private void inList_PlayerStatistic() {
		// TODO Auto-generated method stub
		
	}
	
	private void inList_PlayersOnline() {
		List_PlayersOnline listPlayersOnlineAnswer = Serialization.fromJSON2List_PlayersOnline(jsonString);
		TableModel_PlayersOnline.setPlayersOnlineList(listPlayersOnlineAnswer.getPlayersOnlineList());
	}
	
}
