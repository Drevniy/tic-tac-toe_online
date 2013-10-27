package ttt;

import data_transfer.*;

public class InputDataWorker implements Runnable
{
	String jsonString;
	
	public InputDataWorker(String jsonString) {
		this.jsonString = jsonString;
	}
	
	@Override
	public void run() {
		String[] parts = jsonString.split("\"");
	     
	     switch(parts[3].trim())
	     {
	     case "Security_Registration": classType = Class.forName("Security_Registration");break;
	     
	     }
	}
	
	private void inList_Game(){
		
	}

}
