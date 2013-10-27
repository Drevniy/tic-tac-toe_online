package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class OutputDataWorker {

	public static void sendOut(Socket socket, String stringOut) throws IOException{
		OutputStream socketOut = socket.getOutputStream();
		DataOutputStream out = new DataOutputStream(socketOut);
		out.writeUTF(stringOut); // отсылаем введенную строку текста серверу.
        out.flush();
	}
}
