package pennapps11.server;

import java.util.HashMap;
import java.util.Map;

/**Wrapper class encapsulating the attributes of the target person.
 * 
 * @author Mark
 *
 */
public class TargetProfile {
	
	private StringBuffer likes = new StringBuffer();
	private String zipCode;
	private String radius;
	private Map<SITE_ID, String> siteIDs = new HashMap<SITE_ID, String>();
	public enum SITE_ID{FACEBOOK, TWITTER}
	
	public void addLike(String hunchLikeID){
		if(likes.length() > 0) likes.append(",");
		likes.append(hunchLikeID);
	}
	
	public String getLikes(){
		if(likes.length() > 0){
			return likes.toString();
		} else {
			return null;
		}
	}
	
	public void addID(SITE_ID siteID, String id){
		siteIDs.put(siteID, id);
	}
	
	public Map<SITE_ID, String> getSiteIDs(){
		return siteIDs;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}



	
}
