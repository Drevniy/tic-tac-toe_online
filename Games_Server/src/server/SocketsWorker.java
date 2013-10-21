package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SocketsWorker implements Runnable
{

	@Override
	public void run() {
		
		while(true)
		{
			for (int i=0;i<Server_Main.getSocketsList().size();i++)
			{
				try {
					InputStream socketin = Server_Main.getSocketsList().get(i).getSocket().getInputStream();
					DataInputStream in = new DataInputStream(socketin);
					Object inputObject = Serialization.fromJSON(in.readUTF());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
