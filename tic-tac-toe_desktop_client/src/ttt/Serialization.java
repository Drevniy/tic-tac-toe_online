package ttt;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Serialization {

	public static String toJSON(User user){
		Gson gson = new Gson();
		String json = gson.toJson(user);
		return json;
		
	}
	
	public static Object fromJSON(String jsonString){
		
		Gson gson = new Gson();
		Type objectType = new TypeToken<Object>(){}.getType();
		Object inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
		
	}
	
}
