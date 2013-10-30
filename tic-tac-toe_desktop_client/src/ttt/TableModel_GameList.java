package ttt;

import java.io.IOException;
import java.net.Socket;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TableModel_GameList implements TableModel
{
	private static User user;
	
	public TableModel_GameList() throws IOException {
		//this.user = Lists.getGameList();
	}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return ("Tic-Tac-Toe").getClass();
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public String getColumnName(int arg0) {
		return "Game:";
	}

	@Override
	public int getRowCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Object res = null;
		if(arg0==0){
			res = "Tic-Tac-Toe";
		}else{
			res = "BattleShip";
		}
		return res;
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

	public static void setUser(User user) {
		TableModel_GameList.user = user;
	}

	
	
}
