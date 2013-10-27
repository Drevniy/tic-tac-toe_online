package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class Server_Main {
	
	private static ArrayList<Player> playerList = new ArrayList<>();


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = new ServerSocket(7000);
		System.out.println("server started");
	       
	       Thread thread = new Thread(new SocketsWorker());
	       thread.start();
	       
	       while(true){
			Socket socket = serverSocket.accept();
			Player newPlayer = new Player();
			newPlayer.setSocketConnect(socket);
	       }

	}


	synchronized public static ArrayList<Player> getPlayerList() {
		return playerList;
	}

}
