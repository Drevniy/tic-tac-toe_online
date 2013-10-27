package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;


public class SocketsWorker implements Runnable
{
	private static ArrayList<Player> socketsList;
	
	public SocketsWorker() {
		this.socketsList = Server_Main.getPlayerList();
	}

	@Override
	public void run() {
		
		while(true)
		{
			for (int i=0;i<socketsList.size();i++)
			{
				if(socketsList.get(i).getSocketConnect().isClosed()||socketsList.get(i).getSocketGame().isClosed()){
					socketsList.remove(i);
				}else{

						Socket socket = socketsList.get(i).getSocketConnect();
						try {
							InputStream socketin = socket.getInputStream();
							if(socketin.available()!=0){
								Thread thread = new Thread(new InputDataWorker(socket));
								thread.start();
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}
	}
}
