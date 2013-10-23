package ttt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Security {
	
	public static boolean authorization(User user) throws UnknownHostException, IOException{
		
		boolean res = false;
		
		Socket socket = new Socket("127.0.0.1",7000);
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
        out.flush(); // заставляем поток закончить передачу данных.
        
        InputStream socketin = socket.getInputStream();
		DataInputStream in = new DataInputStream(socketin);
		String inputString = in.readUTF();
		User userAnswer = Serialization.fromJSON(inputString);
		// этот socket надо сохранить и работать с ним дальше
        if(userAnswer.getKeyWord().equals("AuthorizationSuccessful"))
        {
        	InputWorker inputWorker = new InputWorker(socket);
        	Thread inputThread = new Thread(inputWorker);
        	inputThread.start();
        	
        	res = true;
        }else{
        	res=false;
        	socket.close();
        }
		return res;
		
	}
	
	public static boolean registration(User user) throws UnknownHostException, IOException{
		boolean res = false;
		
		Socket socket = new Socket("127.0.0.1",7000);
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(user)); // отсылаем введенную строку текста серверу.
		
		InputStream socketin = socket.getInputStream();
		DataInputStream in = new DataInputStream(socketin);
		String inputString = in.readUTF();
		User userAnswer = Serialization.fromJSON(inputString);
        socket.close();
		
        if(userAnswer.getKeyWord().equals("RegistrationSuccessful"))
        {
        	res = true;
        }else{
        	res=false;
        }
        
		return res;
		
	}
}
