package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO_DB {

	public static ArrayList<User> getUsers() throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select * from user");
        
        ArrayList<User> userList =  new  ArrayList<>();
        
        while (result.next())
        {
        	User user = new User(); 
        	user.setUserName(result.getString("username"));
        	userList.add(user);
        	
        }
        st.close();
        conn.close();
		
		return userList;
	}

	public static void createUser(User user) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        st.execute("insert into user values ("+user.getUserName()+", '"+user.getEmail()+"', '"+user.getPassword()+"')");
		
        st.close();
        conn.close();
	}

	public static String getPassword(User user) throws ClassNotFoundException, SQLException {
		String res = "";
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select password from user where username like '"+user.getUserName()+"'");
        
        
        if (result.next())
        {
        	res = result.getString("password");
        	
        }		
        
        st.close();
        conn.close();
        
        return res;
	}

}
