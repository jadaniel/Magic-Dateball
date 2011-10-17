package pennapps11.server.hunch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.*;
import org.json.*;


/**
 * Class to handle JSON returns to pass to .jsp pages
 * @author Jim
 *	 
 */
public class JSONHandling {
	static String json, IDnumber;

	
	public JSONHandling(String fromHunch){
		json = fromHunch;
	}
	
	
	/**
	 * code from http://code.google.com/p/google-gson/source/browse/trunk/extras/src/main/java/com/google/gson/extras/examples/rawcollections/RawCollectionsExample.java
	 * THIS SHOULD ONLY PARSE A "BATCH" REPLY FROM HUNCH 
	 * @throws JSONException 
	 */
	public void myJsonParser() throws JSONException{	    
		JSONTokener myTokener = new JSONTokener(json);
		JSONObject jsonObj = new JSONObject(myTokener);

		JSONArray responses = jsonObj.getJSONArray("responses");
		
		// TODO Store these somewhere? Yes!!! Let's do it now!
		String resultID = "";
		ArrayList<String> myResultIDs = new ArrayList<String>();
		
		for(int i = 0; i < responses.length(); i++){
			JSONObject newObj = responses.getJSONObject(i);
			JSONArray arr = newObj.getJSONArray("results");
			resultID = arr.get(0).toString(); //works to generate string - MUST RETOKENIZE!
			JSONTokener token = new JSONTokener(resultID);
			JSONObject obj = new JSONObject(token);
			myResultIDs.add(obj.getString("result_id"));
			
		}
		System.out.println(myResultIDs.toString());    

	}
	
	
	
}
