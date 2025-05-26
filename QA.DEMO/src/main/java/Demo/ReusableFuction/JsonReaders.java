package Demo.ReusableFuction;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.testng.annotations.DataProvider;

import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.*;
import java.io.FileReader;

public class JsonReaders {
    
	@DataProvider(name="userData")
	public static Object[][] getUserData() throws FileNotFoundException
	{
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(new FileReader("C:\\Users\\thangrs\\eclipse-workspace\\QA.DEMO\\DateStore\\Details.json")).getAsJsonObject();
		
		JsonObject userDetails = json.getAsJsonObject("userDetails");
		List<Map<String,String>> userList= new ArrayList<>();
		
		for(Map.Entry<String, JsonElement> entry : userDetails.entrySet())
		{
			JsonObject userObject = entry.getValue().getAsJsonObject();
			Map<String,String> userMap =  new HashMap<>();
			
			for(Map.Entry<String,JsonElement> field : userObject.entrySet())
			{
				userMap.put(field.getKey(), field.getValue().getAsString());
			}
			userList.add(userMap);
		}
		
		Object[][] data = new Object[userList.size()][1];
		for(int i=0;i<userList.size();i++)
		{
			data[i][0] = userList.get(i);
		}
		return data;
		
		
	}
}
