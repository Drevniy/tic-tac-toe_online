package ttt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class InputWorker implements Runnable
{
	Socket socket;
	
	public InputWorker(Socket socket) throws IOException {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			InputStream socketin = socket.getInputStream();
			DataInputStream in = new DataInputStream(socketin);
			String inputString = in.readUTF();
			User user = Serialization.fromJSON(inputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Socket getSocket() {
		return socket;
	}
	
}
