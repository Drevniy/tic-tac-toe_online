package forTests;

import org.junit.Test;

import ttt.Serialization;
import data_transfer.Security_Registration;

public class test_Serialization {

	//@Test
	public void test() {
		
		data_transfer.Security_Registration list = new Security_Registration();
		list.setUserName("12412");
		list.setEmail("dfghdxf@xfdhgfh,drydrt");
		list.setPassword("fgjfgjhgh");
		
		String res = Serialization.toJSON(list);
		System.out.println(res);
		
	}
	
	@Test
		public void test1() {
			
		for (int i = 0; i < 100; i++) {
			System.out.print((int) Math.round(30*Math.random()+20)+" ");
		}
		System.out.println();
		for (int i = 0; i < 1000; i++) {
			System.out.print((int)Math.round(100*Math.random())+", ");
		}	
		System.out.println();
		for (int i = 0; i < 100; i++) {
			System.out.print((int) Math.round(30*Math.random()-20)+", ");
		}
		}
	
}
