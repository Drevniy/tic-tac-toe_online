package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SocketsWorker implements Runnable
{
	private static ArrayList<UserSocket> socketsList;
	
	public SocketsWorker() {
		this.socketsList = Server_Main.getSocketsList();
	}

	@Override
	public void run() {
		
		while(true)
		{
			for (int i=0;i<socketsList.size();i++)
			{
				if(socketsList.get(i).getSocket().isClosed()){
					socketsList.remove(i);
				}else{
					try {
						InputStream socketin = socketsList.get(i).getSocket().getInputStream();
						if(socketin.available()!=0){
							DataInputStream in = new DataInputStream(socketin);
							User user = Serialization.fromJSON(in.readUTF());
							user.getKeyWord();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	void keyWordsHander(){
		
	}
}
