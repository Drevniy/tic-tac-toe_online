package ttt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import data_transfer.*;
	

public class Security {
	private static Socket socketConnect;
	
	public static boolean authorization(Security_Authorization authorization) throws UnknownHostException, IOException{
		
		boolean res = false;
		
		OutputStream socketOut = socketConnect.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(authorization)); // отсылаем введенную строку текста серверу.
        socketOut.flush();
		socketOut.close();
		
        InputStream socketin = socketConnect.getInputStream();
		DataInputStream in = new DataInputStream(socketin);
		String jsonString = in.readUTF();
		Security_Authorization authorizationAnswer = Serialization.fromJSON2Security_Authorization(jsonString);
        if(authorizationAnswer.getResult())
        {
        	/*InputWorker inputWorker = new InputWorker(socket);
        	Thread inputThread = new Thread(inputWorker);
        	inputThread.start();*/
        	
        	res = true;
        }else{
        	res=false;
        }
		return res;
		
	}
	
	public static boolean registration(Security_Registration registration) throws UnknownHostException, IOException{
		boolean res = false;
		
		OutputStream socketOut = socketConnect.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(Serialization.toJSON(registration)); // отсылаем введенную строку текста серверу.
		socketOut.flush();
		socketOut.close();
		
		InputStream socketin = socketConnect.getInputStream();
		DataInputStream in = new DataInputStream(socketin);
		String jsonString = in.readUTF();
		Security_Registration registrationAnswer = Serialization.fromJSON2Security_Registration(jsonString);
		
        if(registrationAnswer.getResult())
        {
        	res = true;
        }else{
        	res=false;
        }
        
		return res;
		
	}

	public static Socket getSocketConnect() {
		return socketConnect;
	}

	public static void setSocketConnect(Socket socketConnect) {
		Security.socketConnect = socketConnect;
	}
	
}
