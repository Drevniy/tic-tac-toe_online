package ttt;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Serialization<T>{

	public static String toJSON(Object object){
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
		
	}
	
	public T fromJSON (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<T>(){}.getType();
		T inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
		
	}
	
	public static Class<?> getClassType(String jsonString){
			
		 Class<?> classType = null;
		 String[] parts = jsonString.split("\"");
	     
	     switch(parts[3].trim())
	     {
	     case "Security_Registration": classType = data_transfer.Security_Registration.class;break;
	     }
		return classType;
	}
	
}
