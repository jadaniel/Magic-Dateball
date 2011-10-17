package pennapps11.server.hunch;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.Test;

import pennapps11.server.TargetProfile;

public class HunchClientTest {

	@Test
	public void testGetHunchRecommendations(){
		System.out.println("**testGetHunchRecommendations");
		TargetProfile profile = new TargetProfile();
		profile.addID(TargetProfile.SITE_ID.TWITTER, "cimbriano");
		profile.setZipCode("19104");
		profile.setRadius("5");
		String response = HunchClient.getRecommendations(profile);
		System.out.println(response);
		assertTrue(response.contains("ok"));
	}

	@Test 
	public void testGetResultID(){
		System.out.println("**testGetResultID");
		Map<PreferenceCategory, String> queries = new HashMap<PreferenceCategory, String>();
		queries.put(PreferenceCategory.MOVIES, "Godfather");
		queries.put(PreferenceCategory.FOOD, "Pasta");
		String response = HunchClient.getResultIDs(queries);
		System.out.println(response);
		assertTrue(response.contains("ok"));
	}
	
	@Test
	public void testParseResults(){
		System.out.println("**testParseResults");
		Map<PreferenceCategory, String> queries = new HashMap<PreferenceCategory, String>();
		queries.put(PreferenceCategory.MOVIES, "Godfather");
		queries.put(PreferenceCategory.FOOD, "Pasta");
		String response = HunchClient.getResultIDs(queries);
		System.out.println(response);
		JSONHandler handler = new JSONHandler();
		try {
			handler.parseResults(response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("This is not working yet!!!");
	}
		

}
