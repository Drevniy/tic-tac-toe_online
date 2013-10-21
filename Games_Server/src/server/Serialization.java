package server;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Serialization {

	public static Object toJSON(Object o){
		
		return null;
		
	}
	
	public static Object fromJSON(String jsonString){
		
		Gson gson = new Gson();
		Type objectType = new TypeToken<Object>(){}.getType();
		Object inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
		
	}
	
}
