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
		
		String res = Serialization.toJSON(list);
		Class className = Serialization.getClassType(res).getClass();
		className.n
		Serialization<className> ser = new Serialization<>();
		
	}

}
