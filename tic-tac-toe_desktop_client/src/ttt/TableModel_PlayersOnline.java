package ttt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import data_transfer.List_PlayersOnline;

public class TableModel_PlayersOnline implements TableModel
{
	private static ArrayList<String> playersOnlineList;
	private static JTable table;
	private static Socket socketConnect;

	public TableModel_PlayersOnline(Socket socketConnect,JTable table){
		this.socketConnect = socketConnect;
		this.table = table;
		firstRequest();
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return ("Game").getClass();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int arg0) {
		return "Player name:";
	}

	@Override
	public int getRowCount() {
		return playersOnlineList.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return playersOnlineList.get(rowIndex);
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {}

	public static void setPlayersOnlineList(ArrayList<String> playersOnlineListIn) {
		playersOnlineList = playersOnlineListIn;
		table.revalidate();
	}

	private void firstRequest (){
		try {
			OutputStream out = socketConnect.getOutputStream();
			DataOutputStream outData = new DataOutputStream(out);
			
			List_PlayersOnline listPlayersOnlineRequest = new List_PlayersOnline();
			String jsonString = Serialization.toJSON(listPlayersOnlineRequest);
			
			outData.writeUTF(jsonString);
			out.flush();
			
			InputStream in = socketConnect.getInputStream();
			DataInputStream inData = new DataInputStream(in);
			jsonString = inData.readUTF();
			List_PlayersOnline listPlayersOnlineAnswer = Serialization.fromJSON2List_PlayersOnline(jsonString);
			playersOnlineList = listPlayersOnlineAnswer.getPlayersOnlineList();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
