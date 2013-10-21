package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class Server_Main {
	
	private static String inputString = "";
	private static ArrayList<Sockets> socketsList = new ArrayList<>();


	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException, ClassNotFoundException, SQLException
	{
		ServerSocket serverSocket = new ServerSocket(7000);
		
		while(true){
			Socket socket = serverSocket.accept();
			InputStream socketin = socket.getInputStream();
			DataInputStream in = new DataInputStream(socketin);
			inputString = in.readUTF();
			
			Object inputObject = Serialization.fromJSON(inputString);
			Field keyWord = inputObject.getClass().getDeclaredField("keyWord");
			Field userName = inputObject.getClass().getDeclaredField("userName");
			if(keyWord.equals("registration")){
				Security.registration(inputObject);
			}

			if(keyWord.equals("authorization")){
				if(Security.authorization(inputObject)){
					Sockets newSocket = new Sockets();
					newSocket.setSocket(socket);
					newSocket.setUserName(userName.toString());
					getSocketsList().add(newSocket);
				}
			}
			
			//socketin.flush();
		}

	}


	synchronized public static ArrayList<Sockets> getSocketsList() {
		return socketsList;
	}

}
