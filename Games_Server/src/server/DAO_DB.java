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
        st.execute("insert into user values ("+(getMaxId(user)+1)+",'"+user.getUserName()+"', '"+user.getPassword()+"', '"+user.getEmail()+"')");
		
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

	public static int getMaxId(User user) throws ClassNotFoundException, SQLException {
		 int res = 0;
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select max(id) from user");
        
        
        if (result.next())
        {
        	res = result.getInt("max(id)");
        }		
        
        st.close();
        conn.close();
        
        return res;
	}
	public static User getGameList() throws ClassNotFoundException, SQLException {
		 		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
       
       Statement st = conn.createStatement();
       ResultSet result;
       result = st.executeQuery("select * from namegame");
       
       User user = new User();
       user.setKeyWord("gameList");
       if (result.next())
       {
       	user.setGame1(result.getString("game"));
       }	
       if (result.next())
       {
    	   user.setGame2(result.getString("game"));
       }
       
       st.close();
       conn.close();
       
       return user;
	}
}
