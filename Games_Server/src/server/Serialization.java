package server;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Serialization {

	public static String toJSON(User user){
		
		Gson gson = new Gson();
		String jsonString = gson.toJson(user);
		
		return jsonString;
		
	}
	
	public static User fromJSON(String jsonString){
		
		Gson gson = new Gson();
		Type objectType = new TypeToken<User>(){}.getType();
		User user = gson.fromJson(jsonString, objectType);
		
		return user;
		
	}
	
}
