package ttt;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class InputWorker implements Runnable
{
	private static Socket socket;
	InputStream socketin;
	DataInputStream in;
	
	public InputWorker(Socket socket) throws IOException {
		this.socket = socket;
		socketin = socket.getInputStream();
		in = new DataInputStream(socketin);
	}
	
	@Override
	public void run() {
			
		while(true){
			System.out.println("inputWorcker");
		try
		{
				final String inputString = in.readUTF();
				Thread thread = new Thread(new Runnable() {
													
					@Override
					public void run() {
										
						try {
							keyWordsHandler(inputString);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
										
						}
				});
				thread.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
								
					
		}
	}

	public static Socket getSocket() {
		return socket;
	}
	
	void keyWordsHandler(String inputString) throws IOException{
		User user = Serialization.fromJSON(inputString);
		user.getKeyWord();
		if(user.getKeyWord().equals("playersOnlineList")){
			TableModel_PlayersOnline.setUserList(user.getUserList());
		}
		if(user.getKeyWord().equals("gameList")){
			TableModel_GameList.setUser(user);
		}
		if(user.getKeyWord().equals("playerStatisticList")){
			
		}
		if(user.getKeyWord().equals("topPlayersList")){
			
		}
		if(user.getKeyWord().equals("offerGame")){
			
		}
	}
	
}
