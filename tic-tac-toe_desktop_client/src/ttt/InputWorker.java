package ttt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class InputWorker implements Runnable
{
	private static Socket socketConnect;
	InputStream socketIn;
	DataInputStream in;
	String jsonString;
	
	public InputWorker() {
		
		try {
			socketConnect = BaseFrame.getSocketConnect();
			socketIn = socketConnect.getInputStream();
			in = new DataInputStream(socketIn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
			
		while(true){
			try {
				jsonString = in.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread thread = new Thread(new InputDataWorker(jsonString));
			thread.start();
		}
	}
}
