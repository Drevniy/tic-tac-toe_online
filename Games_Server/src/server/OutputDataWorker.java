package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import data_transfer.List_PlayersOnline;

public class OutputDataWorker {

	public static void sendOut(Socket socket, String stringOut) throws IOException{
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(stringOut); // отсылаем введенную строку текста серверу.
        out.flush();
	}

	public static void sendListPlayersOnline() {
		List_PlayersOnline listPlayersOnline = new List_PlayersOnline();
		ArrayList<String> playerOnlineList = new ArrayList<>();
		for (int i = 0; i < ListConnectedPlayers.getList().size(); i++) {
			if(ListConnectedPlayers.getList().get(i).getPlayerName().equals("")){
			}else{
				playerOnlineList.add(ListConnectedPlayers.getList().get(i).getPlayerName());
			}
		}
		
		listPlayersOnline.setPlayersOnlineList(playerOnlineList);
		
		for (int i = 0; i < ListConnectedPlayers.getList().size(); i++) {
			if(ListConnectedPlayers.getList().get(i).getPlayerName().equals("")){
			}else{
				try {
					OutputDataWorker.sendOut(ListConnectedPlayers.getList().get(i).getSocketConnect(), Serialization.toJSON(listPlayersOnline));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
