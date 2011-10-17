package pennapps11.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.servlet.http.*;
import org.json.*;

import pennapps11.server.hunch.HunchClient;
import pennapps11.server.hunch.JSONHandler;
import pennapps11.server.hunch.PreferenceCategory;
import pennapps11.server.hunch.HunchRecommendation;
import pennapps11.server.hunch.Topic;


public class FormServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FormServlet.class.getName());
    String FB_ID, TW_ID, food, music, drinks, movies, active, zip;
    HashMap<PreferenceCategory, String> hunchQuery = new HashMap<PreferenceCategory, String>();
    
   

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Pull user form input from .jsp
        @SuppressWarnings("unchecked")
		Map<String, String[]> requestParameterMap = req.getParameterMap();
        
        
        // If user has entered a value, pull that value and place into a map w/ Preference category
        for(PreferenceCategory cat : PreferenceCategory.values()){
        	if (requestParameterMap.containsKey(cat.getFormField())) {
        		String catField = cat.getFormField();
        		String keyWord = requestParameterMap.get(catField)[0];
        		
        		hunchQuery.put(cat, keyWord);
        		
        	}
        }
        

        String returnFromResults = HunchClient.getResultIDs(hunchQuery);

        TargetProfile profile = new TargetProfile();
        String json = HunchClient.getResultIDs(hunchQuery);
        ArrayList<String> resultIDs;
		try {
			resultIDs = JSONHandler.parseResults(json);
			for (String ID : resultIDs) {profile.addLike(ID);}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
                
        profile.addID(TargetProfile.SITE_ID.FACEBOOK, requestParameterMap.get("fb_id")[0]);
        profile.addID(TargetProfile.SITE_ID.TWITTER, requestParameterMap.get("tw_id")[0]);
        profile.setZipCode(requestParameterMap.get("zip_code")[0]);
        profile.setRadius("3");
        
        String recommendations = HunchClient.getRecommendations(profile);
        ArrayList<HunchRecommendation> reccs = JSONHandler.parseRecommendations(recommendations);
        
        //TODO get real json
        //String returnFromResults = HunchClient.getResultIDs(hunchQuery); //TODO need to separate IDs!
        String sampleJSON= "{'total': 3841, 'ok': true, 'results': [{'url': 'http://hunch.com/item/hn_1882014/', 'result_id': 'hn_1882014', 'image_url': 'http://aka-img-1.h-img.com/media/img/b/hn/1882014/8078020434315226016', 'name': 'The Beatles - The White Album'}, {'url': 'http://hunch.com/item/hn_2466744/', 'result_id': 'hn_2466744', 'image_url': 'http://aka-img-2.h-img.com/media/img/b/hn/2466744/4435353142136457893', 'name': 'Beatles for Sale'}, {'url': 'http://hunch.com/item/hn_2747104/', 'result_id': 'hn_2747104', 'image_url': 'http://aka-img-1.h-img.com/media/img/b/hn/2747104/1828851390027614509', 'name': 'With the Beatles'}, {'url': 'http://hunch.com/item/hn_3569584/', 'result_id': 'hn_3569584', 'image_url': 'http://aka-img-1.h-img.com/media/img/b/hn/3569584/3519388481926086177', 'name': 'The Beatles'}, {'url': 'http://musicbrainz.org/release-group/055be730-dcad-31bf-b550-45ba9c202aa3', 'result_id': 'mb_055be730-dcad-31bf-b550-45ba9c202aa3', 'name': 'The Beatles'}, {'url': 'http://musicbrainz.org/release-group/a63dc65f-09f2-359b-a10e-648f00ecd96c', 'result_id': 'mb_a63dc65f-09f2-359b-a10e-648f00ecd96c', 'name': 'With The Beatles'}, {'url': 'http://musicbrainz.org/release-group/f50a3b6f-27f0-3832-bd3f-3568dc557d95', 'result_id': 'mb_f50a3b6f-27f0-3832-bd3f-3568dc557d95', 'name': 'Beatles for Sale'}, {'url': 'http://musicbrainz.org/recording/41409bc8-24f7-472d-8ca9-ceee871c7920', 'result_id': 'mb_41409bc8-24f7-472d-8ca9-ceee871c7920', 'name': 'The Beatles'}, {'url': 'http://musicbrainz.org/recording/b03f0614-1132-49da-a67e-1a50c31632de', 'result_id': 'mb_b03f0614-1132-49da-a67e-1a50c31632de', 'name': 'Beatles'}, {'url': 'http://www.pandora.com/music/album/beatles/beatles+for+sale', 'result_id': 'pandora_al77774643825', 'image_url': 'http://cont-sjl-2.pandora.com/images/public/amz/5/2/8/3/077774643825_500W_500H.jpg', 'name': 'Beatles For Sale'}]}";

        
        
        try {
			JSONHandler.parseResults(returnFromResults);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //TODO send HashMap to hunch engine
		
		//get reccomendations returns JSON
		
		//parse reccomendations JSON and build list of HunchReccomendations
		String recsJSON = "{'total': 810, 'ok': true, 'is_personalized': true, 'recommendations': [{'topic_ids': ['cat_approved', 'cat_entertainment-media', 'cat_humor', 'cat_video-games', 'list_chart', 'list_web-pic'], 'image_urls': ['http://aka-img-2.h-img.com/media/img/s/e/I/r/eIr-10812472.jpg'], 'name': 'The Evolution of Video Game Controllers', 'score': [0, 0, 4.843806859730029, false, 0.9609517149325073], 'result_id': 'hn_3841751'}, {'topic_ids': ['cat_approved', 'cat_entertainment-media', 'cat_featured', 'cat_humor', 'cat_just-for-fun', 'cat_movies-tv', 'cat_other', 'list_humor-video', 'list_web-video'], 'image_urls': ['http://aka-img-2.h-img.com/media/img/s/p/B/p/pBp-10863191.jpg'], 'name': 'Oprah and the Yelling Goat', 'score': [0, 0, 4.6692413388536504, false, 0.9173103347134127], 'result_id': 'hn_3853094'}]}";
		req.setAttribute("hunchRecs", JSONHandler.parseRecommendations(recsJSON));
		
        
        resp.sendRedirect("/results.jsp?gwt.codesvr=127.0.0.1:9997"); //prob don't need this - send to hunch engine

    }
}