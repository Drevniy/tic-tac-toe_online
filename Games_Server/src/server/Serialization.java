package server;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import data_transfer.*;

public class Serialization{

	public static String toJSON(Object object){
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
		
	}
	
	public static List_Game fromJSON2List_Game (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<List_Game>(){}.getType();
		List_Game inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	
	public static List_PlayersOnline fromJSON2List_PlayersOnline (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<List_PlayersOnline>(){}.getType();
		List_PlayersOnline inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	public static List_PlayerStatistic fromJSON2List_PlayerStatistic (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<List_PlayerStatistic>(){}.getType();
		List_PlayerStatistic inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	public static List_TopPlayers fromJSON2List_TopPlayers (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<List_TopPlayers>(){}.getType();
		List_TopPlayers inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	public static OfferGame fromJSON2OfferGame (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<OfferGame>(){}.getType();
		OfferGame inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	public static Security_Authorization fromJSON2Security_Authorization (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<Security_Authorization>(){}.getType();
		Security_Authorization inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	public static Security_Registration fromJSON2Security_Registration (String jsonString){
		
		Gson gson = new Gson();
		
		Type objectType = new TypeToken<Security_Registration>(){}.getType();
		Security_Registration inputObject = gson.fromJson(jsonString, objectType);
		
		return inputObject;
	}
	
	public static Class getClassType(String jsonString) throws ClassNotFoundException{
			
		 Class classType = null;
		 String[] parts = jsonString.split("\"");
	     
	     switch(parts[3].trim())
	     {
	     case "Security_Registration": classType = Class.forName("Security_Registration");break;
	     
	     }
		return classType;
	}
	
}
