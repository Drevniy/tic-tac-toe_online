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
						System.out.println("server gameList send");

						final UserSocket userSocket = socketsList.get(i);
						InputStream socketin = userSocket.getSocket().getInputStream();
						if(socketin.available()!=0){
							Thread thread = new Thread(new Runnable() {
								
								@Override
								public void run() {
									try {
										keyWordsHandler(userSocket);
									} catch (IOException | ClassNotFoundException | SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}
							});
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
	
	void keyWordsHandler(UserSocket userSocket) throws IOException, ClassNotFoundException, SQLException{

		Socket socket = userSocket.getSocket();
		InputStream socketin = socket.getInputStream();
		DataInputStream in = new DataInputStream(socketin);
		User user = Serialization.fromJSON(in.readUTF());
		user.getKeyWord();
		if(user.getKeyWord().equals("playersOnlineList")){
			User sendUser = new User();
			sendUser.setKeyWord("playersOnlineList") ;
			for (int i = 0; i < socketsList.size(); i++) {
				User nameUser = new User();
				nameUser.setUserName(socketsList.get(i).getUserName());
				sendUser.getUserList().add(nameUser);
			}
			
			OutputStream socketOut = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(sendUser)); // отсылаем введенную строку текста серверу.
	        out.flush();
		}
		if(user.getKeyWord().equals("gameList")){
			User sendUser = DAO_DB.getGameList();
			OutputStream socketOut = socket.getOutputStream();
			DataOutputStream out = new DataOutputStream(socketOut);
			out.writeUTF(Serialization.toJSON(sendUser)); // отсылаем введенную строку текста серверу.
	        out.flush();
	        
		}
		if(user.getKeyWord().equals("playerStatisticList")){
			
		}
		if(user.getKeyWord().equals("topPlayersList")){
			
		}
		if(user.getKeyWord().equals("offerGame")){
			
		}
	}
}
