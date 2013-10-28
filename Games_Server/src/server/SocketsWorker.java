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

	@Override
	public void run() {
		
		while(true)
		{
			for (int i=0;i<ListConnectedPlayers.getList().size();i++)
			{
				if(ListConnectedPlayers.getList().get(i).getSocketConnect().isClosed()&&ListConnectedPlayers.getList().get(i).getSocketGame().isClosed()){
					ListConnectedPlayers.getList().remove(i);
				}else{

						Socket socket = ListConnectedPlayers.getList().get(i).getSocketConnect();
						try {
							InputStream socketin = socket.getInputStream();
							if(socketin.available()!=0){
								Thread thread = new Thread(new InputDataWorker(socket, ListConnectedPlayers.getList().get(i)));
								thread.start();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		}
	}
}
