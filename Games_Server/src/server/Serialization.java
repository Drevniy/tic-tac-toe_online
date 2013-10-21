package server;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Serialization {

	public static Object toJSON(Object o){
		
		return null;
		
	}
	
	public static User fromJSON(String jsonString){
		
		Gson gson = new Gson();
		Type objectType = new TypeToken<User>(){}.getType();
		User user = gson.fromJson(jsonString, objectType);
		
		return user;
		
	}
	
}
