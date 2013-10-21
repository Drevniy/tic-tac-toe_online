package server;

import java.sql.SQLException;
import java.util.ArrayList;

public class Security
{
	public static boolean isUserNameExists(String userName) throws ClassNotFoundException, SQLException{
		boolean res = false;
		ArrayList<User> userList = DAO_DB.getUsers();
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUserName().equals(userName)){
				res = true;
			}
		}
		return res;
	}
	
	public static boolean registration(User user) throws NoSuchFieldException, SecurityException, ClassNotFoundException, SQLException{
		boolean res = false;
		
		
		if(!isUserNameExists(user.getUserName())){
			DAO_DB.createUser(user);
			res = true;
		}
		
		return res;
	}
	
	public static boolean authorization(User user) throws NoSuchFieldException, SecurityException, ClassNotFoundException, SQLException{
		boolean res = false;
		
		if(isUserNameExists(user.getUserName())){
			if(DAO_DB.getPassword(user).equals(user.getPassword()))
			{
				res = true;
			}
			
		}
		
		return res;
	}
}
