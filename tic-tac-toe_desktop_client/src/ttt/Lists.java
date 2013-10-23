package ttt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Lists {

	public static void getPlayersOnlineList() throws IOException{
		
		Socket socket = InputWorker.getSocket();
		User user = new User();
		user.setKeyWord("playersOnlineList");
		
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
        out.flush();
        
	}
	
	public static void getGameList() throws IOException{
		
		Socket socket = InputWorker.getSocket();
		User user = new User();
		user.setKeyWord("gameList");
		
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
        out.flush();
        
       /* InputStream socketin = socket.getInputStream();
        DataInputStream in = new DataInputStream(socketin);
        String inputString = in.readUTF();
        User userIn = Serialization.fromJSON(inputString);
        return userIn;*/
		
	}
	
	public static ArrayList<User> getTopPlayersList(){
		return null;
		
	}
	
	public static ArrayList<User> getOfferGame(){
		return null;
	
}
	
	
}
