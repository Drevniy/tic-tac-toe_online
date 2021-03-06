package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import data_transfer.*;

public class InputDataWorker implements Runnable
{
	String jsonString;
	Player player;
	Socket socket;
	
	public InputDataWorker(Socket socket,  Player player) throws IOException {
		this.socket = socket;
		this.player = player;
		
		InputStream socketIn = socket.getInputStream();
		DataInputStream in = new DataInputStream(socketIn);
		jsonString = in.readUTF();
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
	
	private void inList_Game(){
		
		try {
			List_Game listGame = new List_Game();
			listGame.setGameList(DAO_DB.getGameList());
			
			OutputDataWorker.sendOut(socket, Serialization.toJSON(listGame));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void inList_PlayersOnline(){
		List_PlayersOnline listPlayersOnline = new List_PlayersOnline();
		ArrayList<String> playerOnlineList = new ArrayList<>();
		for (int i = 0; i < ListConnectedPlayers.getList().size(); i++) {
			if(ListConnectedPlayers.getList().get(i).getPlayerName().equals("")){
			}else{
				playerOnlineList.add(ListConnectedPlayers.getList().get(i).getPlayerName());
			}
		}
		
		listPlayersOnline.setPlayersOnlineList(playerOnlineList);
		try {
			OutputDataWorker.sendOut(socket, Serialization.toJSON(listPlayersOnline));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void inList_PlayerStatistic(){
		List_PlayerStatistic playerStatistic = Serialization.fromJSON2List_PlayerStatistic(jsonString);
	}
	
	private void inList_TopPlayers(){
		List_TopPlayers topPlayers = Serialization.fromJSON2List_TopPlayers(jsonString);
	}
	
	private void inOfferGame(){
		OfferGame offerGame = Serialization.fromJSON2OfferGame(jsonString);
	}
	
	private void inSecurity_Authorization(){
		Security_Authorization authorization = Serialization.fromJSON2Security_Authorization(jsonString);
		try {
			String password = DAO_DB.getPassword(authorization.getUserName());
			
			Security_Authorization authorizationOut = new Security_Authorization();
			
			if(authorization.getPassword().equals(password)){
				authorizationOut.setResult(true);
				player.setPlayerName(authorization.getUserName());
				OutputDataWorker.sendOut(socket, Serialization.toJSON(authorizationOut));
				OutputDataWorker.sendListPlayersOnline();
			}else{
				OutputDataWorker.sendOut(socket, Serialization.toJSON(authorizationOut));
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void inSecurity_Registration(){
		Security_Registration registration = Serialization.fromJSON2Security_Registration(jsonString);
		
		try {
			Security_Registration registrationOut = new Security_Registration();
			ArrayList<String> userNameList = DAO_DB.getUserNameList();
			boolean res = true;
			for (int i = 0; i < userNameList.size(); i++) {
				if(userNameList.get(i).equals(registration.getUserName())){
					res = false;
				}
			}
			if(res){
				DAO_DB.createUser(registration);
				registrationOut.setResult(res);
			}
			OutputDataWorker.sendOut(socket, Serialization.toJSON(registrationOut));
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
