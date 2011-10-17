/**
 * 
 */
package pennapps11.server.hunch;

import java.util.HashMap;

import pennapps11.server.AdviceCategory;

/**
 * @author Mark
 *
 */
public enum Topic {

	RESTAURANTS("list_restaurant", AdviceCategory.ACTIVITIES),	
	MUSIC_VENUES("list_music-venue", AdviceCategory.ACTIVITIES),
	MUSEUMS("list_museum", AdviceCategory.ACTIVITIES),
	COMEDY_CLUBS("list_comedy-club", AdviceCategory.ACTIVITIES),
	DRINKS("list_drink", AdviceCategory.INTERESTS),
	DIGESTIFS("list_after-dinner-liquor", AdviceCategory.INTERESTS),
	POEMS("list_poem", AdviceCategory.INTERESTS),
	HUMOR("cat_humor", AdviceCategory.INTERESTS),
	ART_MOVEMENTS("list_art-movement", AdviceCategory.INTERESTS),
	AUTHORS("list_author", AdviceCategory.INTERESTS),
	COMPOSERS("list_composer", AdviceCategory.INTERESTS),
	ODDBALL_ATTRACTIONS("list_oddball-attraction", AdviceCategory.MISC),
	DEVIANT_ART_USERS("list_deviantart-user", AdviceCategory.MISC),
	OPTICAL_ILLUSION("list_optical-illusion", AdviceCategory.MISC),
	PRODUCTIVITY_TOOLS("list_productivity-tool", AdviceCategory.MISC),
	YOGA_POSES("list_yoga-pose", AdviceCategory.MISC),
	HICCUP_REMEDY("list_hiccup-remedy", AdviceCategory.MISC),
	JELLY_BELLY_FLAVORS("list_jelly-belly-flavor", AdviceCategory.MISC);
	
	private static HashMap<String, Topic> topicIds = new HashMap<String, Topic>();
	static{
		topicIds.put("list_restaurant", RESTAURANTS);
		topicIds.put("list_music-venue", MUSIC_VENUES);
		topicIds.put("list_museum", MUSEUMS);
		topicIds.put("list_comedy-club", COMEDY_CLUBS);
		topicIds.put("list_drink", DRINKS);
		topicIds.put("list_after-dinner-liquor", DIGESTIFS);
		topicIds.put("list_poem", POEMS);
		topicIds.put("cat_humor", HUMOR);
		topicIds.put("list_art-movement", ART_MOVEMENTS);
		topicIds.put("list_author", AUTHORS);
		topicIds.put("list_composer", COMPOSERS);
		topicIds.put("list_oddball_attraction", ODDBALL_ATTRACTIONS);
		topicIds.put("list_deviantart-user", DEVIANT_ART_USERS);
		topicIds.put("list_optical-illusion", OPTICAL_ILLUSION);
		topicIds.put("list_productivity-tool", PRODUCTIVITY_TOOLS);
		topicIds.put("list_yoga-pose", YOGA_POSES);
		topicIds.put("list_hiccup-remedy", HICCUP_REMEDY);
		topicIds.put("list_jelly-belly-flavor", JELLY_BELLY_FLAVORS);
	}
	
	
	private String id;
	private AdviceCategory adviceCategory;
	
	Topic(String hunchId, AdviceCategory category){
		id = hunchId;
		adviceCategory = category;
	}
	
	public String getHunchId(){
		return id;
	}
	
	public AdviceCategory getAdviceCategory(){
		return adviceCategory;
	}
	
	/**Retrieve Topic enum by hunchTopicId
	 * @param hunchTopicId
	 * @return
	 */
	public static Topic getTopic(String hunchTopicId){
		if(topicIds.keySet().contains(hunchTopicId)){
			return topicIds.get(hunchTopicId);
		} else {
			return null;
		}
	}


}
