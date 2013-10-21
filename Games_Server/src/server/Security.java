package server;

import java.sql.SQLException;
import java.util.ArrayList;

public class Security
{
	public static boolean isUserNameExists(String userName) throws ClassNotFoundException, SQLException{
		
		boolean res = false;
		ArrayList<User> userList = DAO_DB.getUsers();
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).equals(userName)){
				res = true;
			}
		}
		
		return res;
	}
	
	public static boolean registration(Object inputObject) throws NoSuchFieldException, SecurityException, ClassNotFoundException, SQLException{
		boolean res = false;
		
		String userName = inputObject.getClass().getField("userName").toString();
		String email = inputObject.getClass().getField("email").toString();
		String password = inputObject.getClass().getField("password").toString();
		
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		
		if(!isUserNameExists(userName)){
			DAO_DB.createUser(user);
			res = true;
		}
		
		return res;
	}
	
	public static boolean authorization(Object inputObject) throws NoSuchFieldException, SecurityException, ClassNotFoundException, SQLException{
		boolean res = false;
		
		String userName = inputObject.getClass().getField("userName").toString();
		String password = inputObject.getClass().getField("password").toString();
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		if(isUserNameExists(userName)){
			if(DAO_DB.getPassword(user).equals(password))
			{
				res = true;
			}
			
		}
		
		return res;
	}
}
