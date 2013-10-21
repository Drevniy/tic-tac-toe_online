package ttt;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Security {
	
	public static boolean authorization(User user) throws UnknownHostException, IOException{
		
		Socket socket = new Socket("127.0.0.1",7000);
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
        out.flush(); // заставляем поток закончить передачу данных.
        socket.close();
		
		return false;
		
	}
	
	public static boolean registration(User user) throws UnknownHostException, IOException{
		
		Socket socket = new Socket("127.0.0.1",7000);
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
        out.flush(); // заставляем поток закончить передачу данных.
        socket.close();
		
		return false;
		
	}
}
