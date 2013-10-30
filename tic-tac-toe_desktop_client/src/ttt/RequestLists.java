package ttt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import data_transfer.List_Game;
import data_transfer.List_PlayerStatistic;
import data_transfer.List_PlayersOnline;
import data_transfer.List_TopPlayers;

public class RequestLists {

	public static void getPlayersOnlineList(){
		
		Socket socketConnect = BaseFrame.getSocketConnect();
		List_PlayersOnline listPlayersOnline = new List_PlayersOnline();
		
		
		try {
			OutputStream socketOut = socketConnect.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(listPlayersOnline)); // отсылаем введенную строку текста серверу.
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}
	
	public static void getGameList() throws IOException{
		
		Socket socketConnect = BaseFrame.getSocketConnect();
		List_Game listGame = new List_Game();
		try {
			OutputStream socketOut = socketConnect.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(listGame)); // отсылаем введенную строку текста серверу.
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void getTopPlayersList() throws IOException{
		Socket socketConnect = BaseFrame.getSocketConnect();
		List_TopPlayers listTopPlayers = new List_TopPlayers();
		try {
			OutputStream socketOut = socketConnect.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(listTopPlayers)); // отсылаем введенную строку текста серверу.
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getPlayerStatisticList() throws IOException{
		Socket socketConnect = BaseFrame.getSocketConnect();
		List_PlayerStatistic listPlayerStatistic = new List_PlayerStatistic();
		try {
			OutputStream socketOut = socketConnect.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(listPlayerStatistic)); // отсылаем введенную строку текста серверу.
	        out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getOfferGame(){
	
	}
	
	
}
