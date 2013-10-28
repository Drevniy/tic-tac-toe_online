package forTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ttt.Serialization;
import ttt.User;

import data_transfer.List_PlayersOnline;
import data_transfer.Security_Registration;

public class test_Serialization {

	@Test
	public void test() {
		
		data_transfer.Security_Registration list = new Security_Registration();
		list.setUserName("12412");
		list.setEmail("dfghdxf@xfdhgfh,drydrt");
		list.setPassword("fgjfgjhgh");
		
		String res = Serialization.toJSON(list);
		System.out.println(res);
		
	}

	@Test
	public void test2() {
		
		List_PlayersOnline playerList = new List_PlayersOnline();
		ArrayList<User> userList = new ArrayList<>();
		User user = new User();
		user.setUserName("Саша");
		User user1 = new User();
		user1.setUserName("Петя");
		
		userList.add(user);
		userList.add(user1);
		
		playerList.setUserList(userList);
		
		
		String res = Serialization.toJSON(playerList);
		System.out.println(res);
		
	}
	
}
