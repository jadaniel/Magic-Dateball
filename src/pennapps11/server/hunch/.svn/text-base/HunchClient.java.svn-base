/**
 * 
 */
package pennapps11.server.hunch;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import pennapps11.server.GeoLocation;
import pennapps11.server.TargetProfile;
import pennapps11.server.TargetProfile.SITE_ID;

import com.google.gson.*;


/**
 * Retrieve recommendation information from Hunch.
 * 
 * @author Mark
 *
 *
 */
public class HunchClient {
	
	private static final String USER_ID_KEY ="user_id";
	private static final String TOPIC_ID_KEY = "topic_ids";
	private static final String FIELDS_KEY = "fields";
	private static final String LATITUDE_KEY = "lat";
	private static final String LONGITUDE_KEY = "lng";
	private static final String RADIUS_KEY = "radius";
	private static final String NAME_KEY = "name";
	private static final String AUTH_SIG_KEY = "auth_sig";
	private static final String PARAMS_KEY = "params";
	private static final String LIMIT_KEY = "limit";
	private static final String QUERY_KEY = "query";
	private static final String RECOMMENDATION_FIELDS = "name,score,image_urls";
	private static final String RESULT_ID_FIELDS = "result_id";
	private static final String LIMIT_VALUE = "1";
	private static final String HUNCH_BATCH_URL = "http://api.hunch.com/api/v1/batch/";
	private static final String QUERY_STRING_PREFIX="calls=";
	private static final String GET_RECOMMENDATIONS_METHOD = "get-recommendations";
	private static final String GET_RESULTS_METHOD = "get-results";
	
	private static final String APP_SECRET="4586d7edd8cfd9c3ec3eedb4bba58c42477ea854";
	private static final Map<SITE_ID, String> SITE_PREFIXES = new HashMap<SITE_ID, String>();
	
	static{
		SITE_PREFIXES.put(SITE_ID.FACEBOOK, "fb_");
		SITE_PREFIXES.put(SITE_ID.TWITTER, "tw_");
	}
	
	/**Returns a HunchID for a keyword within the context of a specific topic
	 * 
	 * @return
	 */
	public static String getResultIDs(Map<PreferenceCategory, String> queries){
		if(queries == null) return null;
		Collection<Map<String, Object>> message = new ArrayList<Map<String, Object>>();
		for(PreferenceCategory cat : queries.keySet()){
			Map<String, Object> catMap = new HashMap<String, Object>();
			catMap.put(NAME_KEY, GET_RESULTS_METHOD);
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(TOPIC_ID_KEY, cat.getHunchId());
			paramMap.put(QUERY_KEY, queries.get(cat));
			paramMap.put(LIMIT_KEY, "1");
			paramMap.put(FIELDS_KEY, RESULT_ID_FIELDS);
			catMap.put(PARAMS_KEY, paramMap);
			message.add(catMap);
		}
		return getHunchResponse(message);
	}
	
	/**Returns the Json response from Hunch
	 * @param profile
	 * @return
	 */
	public static String getRecommendations(TargetProfile profile){
		if(profile == null) return null;
		System.out.println("Retrieving recommendations");
		Collection<Map<String, Object>> message = new ArrayList<Map<String, Object>>();
		boolean hasProfileId = false;
		String siteIdString = null;
		if(profile.getSiteIDs().size() > 0){
			 hasProfileId = true;
			 siteIdString = getSiteIDString(profile);
		}
		String latitude = null;
		String longitude = null;
		String radius = null;
		boolean hasLocation = false;
		if(profile.getZipCode() != null && profile.getRadius() != null){
			hasLocation = true;
			System.out.println("--Retrieving geolocation data");
			GeoLocation loc = new GeoLocation(profile.getZipCode());
			latitude = loc.getLatitude();
			longitude = loc.getLongitude();
			radius = profile.getRadius();
			System.out.println("--Geolocation data retrieved");
		}
		
		try {
			// create JSON request object for each Hunch Topic
			for(Topic topic : Topic.values()){
				System.out.println("Creating recommendation object for topic " + topic.getHunchId());
				Map<String, Object> catMap = new HashMap<String, Object>();
				catMap.put(NAME_KEY, GET_RECOMMENDATIONS_METHOD);
				HashMap<String, String> paramMap = new HashMap<String, String>();
				if(hasProfileId) paramMap.put(USER_ID_KEY, siteIdString);
				if(hasLocation){
					paramMap.put(LATITUDE_KEY, latitude);
					paramMap.put(LONGITUDE_KEY, longitude);
					paramMap.put(RADIUS_KEY, radius);
				}
				paramMap.put(TOPIC_ID_KEY, topic.getHunchId());
				paramMap.put(FIELDS_KEY, RECOMMENDATION_FIELDS);
				paramMap.put(LIMIT_KEY, LIMIT_VALUE);
				System.out.println("--Generating Authentication Signature");
				String authSig = getAuthSig(paramMap, APP_SECRET);
				paramMap.put(AUTH_SIG_KEY, authSig);
				catMap.put(PARAMS_KEY, paramMap);
				System.out.println("--adding to message");
				message.add(catMap);
			}
			StringBuffer url = new StringBuffer();
			url.append(HUNCH_BATCH_URL);
			return(getHunchResponse(message));
			
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String getHunchResponse(Collection<Map<String, Object>> message){
		Gson gson;
		gson = new Gson();
		StringBuffer queryString = new StringBuffer(QUERY_STRING_PREFIX);
		StringBuffer responseStringBuffer = new StringBuffer();
		try {
			queryString.append(URLEncoder.encode(gson.toJson(message), "UTF-8"));
			URL url = new URL("http://api.hunch.com/api/v1/batch/");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			writer.write(queryString.toString());
			writer.flush();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = reader.readLine()) != null){
				responseStringBuffer.append(line);
			}
			reader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseStringBuffer.toString();
	}
	

	

	private static String getSiteIDString(TargetProfile profile) {
		Map<SITE_ID, String> profileIds = profile.getSiteIDs();
		Iterator<SITE_ID> idIter = profileIds.keySet().iterator();
		StringBuffer idString = new StringBuffer();
		while(idIter.hasNext()){
			SITE_ID id = idIter.next();
			idString.append(SITE_PREFIXES.get(id) + profileIds.get(id));
			if(idIter.hasNext()) idString.append(",");
		}
		return idString.toString();
	}
	
	
	/**Authentication code pulled from Hunch forums.
	 * 
	 * 
	 * @param params
	 * @param appSecret
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	private static String getAuthSig(HashMap<String, String> params, String appSecret) throws
		UnsupportedEncodingException, NoSuchAlgorithmException{
		String result = new String();
		ArrayList<String> keys = new ArrayList<String>();
		for (String key : params.keySet()) {
			keys.add(key);
		}
		Collections.sort(keys);
		for ( int i = 0; i < keys.size(); ++i ) {
			String key = keys.get( i );
			String keyValuePair = URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(params.get(key), "UTF-8");
			result += (i == 0) ? keyValuePair : "&" + keyValuePair;
		}
		result += appSecret;
		String sha1 = AeSimpleSHA1.SHA1(result);
		return sha1;
	}

	private static class AeSimpleSHA1 {
		private static String convertToHex(byte[] data) {
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
			}
			return buf.toString();
		}

		public static String SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-1");
			byte[] sha1hash = new byte[40];
			md.update(text.getBytes("UTF8"), 0, text.length());
			sha1hash = md.digest();
			return convertToHex(sha1hash);
		}
	}



}
