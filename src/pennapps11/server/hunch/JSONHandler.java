package pennapps11.server.hunch;


import java.util.ArrayList;
import org.json.*;
import pennapps11.server.hunch.HunchRecommendation;

import pennapps11.server.AdviceCategory;

/**
 * Class to handle JSON returns to pass to .jsp pages
 * @author Jim
 *	 
 */
public class JSONHandler {
	
	/**
	 * code from http://code.google.com/p/google-gson/source/browse/trunk/extras/src/main/java/com/google/gson/extras/examples/rawcollections/RawCollectionsExample.java
	 * THIS SHOULD ONLY PARSE A "BATCH" REPLY FROM HUNCH 
	 * @throws JSONException 
	 */
	public static ArrayList<String> parseResults(String json) throws JSONException{	    

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
		//System.out.println(myResultIDs.toString());    
		return myResultIDs;

	}
	
	public static ArrayList<HunchRecommendation> parseRecommendations(String json){
		JSONTokener recsTokener = new JSONTokener(json);
		
		ArrayList<HunchRecommendation> myRecs = new ArrayList<HunchRecommendation>();
		try {
			JSONObject recsObj = new JSONObject(recsTokener);
			
			JSONArray recommendations = recsObj.getJSONArray("recommendations");
			
			
			for(int i = 0; i < recommendations.length(); i++){
				
				JSONObject thisOne = recommendations.getJSONObject(i);
				
				Topic topic = null;
				AdviceCategory adviceCategory = null;
				String name = thisOne.getString("name");
				String imageURL = thisOne.getJSONArray("image_urls").getString(0); 
				double score = thisOne.getJSONArray("score").getDouble(4);
				
				JSONArray topics = thisOne.getJSONArray("topic_ids");
				for(int j = 0; j < topics.length() && topic == null; j++){
					String temp = topics.getString(j);
					topic = Topic.getTopic(temp);
					
					if(topic != null) {
						adviceCategory = topic.getAdviceCategory();
					}
				}
				
				HunchRecommendation tempHunchRec = new HunchRecommendation(name, topic, adviceCategory, imageURL, score);
				myRecs.add(tempHunchRec);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myRecs;
        
	}
}
