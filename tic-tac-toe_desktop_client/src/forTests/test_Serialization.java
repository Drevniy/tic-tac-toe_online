package forTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ttt.Serialization;

import data_transfer.Security_Registration;

public class test_Serialization {

	@Test
	public void test() {
		data_transfer.Security_Registration list = new Security_Registration();
		list.setUserName("12412");
		list.setEmail("dfghdxf@xfdhgfh,drydrt");
		list.setPassword("fgjfgjhgh");
		
		System.out.println(Serialization.toJSON(list));
		System.out.println(Serialization.getClassType(Serialization.toJSON(list)));
		
	}

}
