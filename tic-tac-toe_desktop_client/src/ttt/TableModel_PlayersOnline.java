package ttt;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModel_PlayersOnline implements TableModel
{
	private static ArrayList<User> userList;

	public TableModel_PlayersOnline() throws IOException {
		
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return userList.get(0).getUserName().getClass();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int arg0) {
		return "Player name";
	}

	@Override
	public int getRowCount() {
		return userList.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return userList.get(arg0);
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
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public static void setUserList(ArrayList<User> userList) {
		TableModel_PlayersOnline.userList = userList;
	}

	
	
}
