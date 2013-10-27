package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data_transfer.*;


public class DAO_DB {
	
	public static ArrayList<String> getUserNameList() throws ClassNotFoundException, SQLException {

		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select * from user");
        
        ArrayList<String> userNameList =  new  ArrayList<>();
        
        while (result.next())
        {
        	userNameList.add(result.getString("username"));
        }
        st.close();
        conn.close();
		
		return userNameList;
	}

	public static void createUser(Security_Registration registration) throws ClassNotFoundException, SQLException {
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        st.execute("insert into user values ("+(getMaxId()+1)+",'"+registration.getUserName()+"', '"+registration.getPassword()+"', '"+registration.getEmail()+"')");
		
        st.close();
        conn.close();
	}

	public static String getPassword(String username) throws ClassNotFoundException, SQLException {
		String res = "";
		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
        
        Statement st = conn.createStatement();
        ResultSet result;
        result = st.executeQuery("select password from user where username like '"+username+"'");
        
        
        if (result.next())
        {
        	res = result.getString("password");
        }		
        
        st.close();
        conn.close();
        
        return res;
	}

	public static int getMaxId() throws ClassNotFoundException, SQLException {
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
	public static Player getGameList() throws ClassNotFoundException, SQLException {
		 		
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/games", "sa", "");
       
       Statement st = conn.createStatement();
       ResultSet result;
       result = st.executeQuery("select * from namegame");
       
       Player player = new Player();
       
       st.close();
       conn.close();
       
       return player;
	}
}
