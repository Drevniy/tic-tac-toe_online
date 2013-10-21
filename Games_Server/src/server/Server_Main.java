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
		System.out.println("server started");
		while(true){
			Socket socket = serverSocket.accept();
			InputStream socketin = socket.getInputStream();
			DataInputStream in = new DataInputStream(socketin);
			inputString = in.readUTF();
			
			User user = Serialization.fromJSON(inputString);
			if(user.getKeyWord().equals("registration")){
				Security.registration(user);
			}

			if(user.getKeyWord().equals("authorization")){
				if(Security.authorization(user)){
					Sockets newSocket = new Sockets();
					newSocket.setSocket(socket);
					newSocket.setUserName(user.getUserName());
					getSocketsList().add(newSocket);
				}
				System.out.println(getSocketsList().get(0).getUserName());
			}
			
			//socketin.flush();
		}

	}


	synchronized public static ArrayList<Sockets> getSocketsList() {
		return socketsList;
	}

}
