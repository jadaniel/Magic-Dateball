/**
 * 
 */
package pennapps11.server.hunch;

/**Enum of categories used to describe user preferences
 * 
 * @author Mark
 *
 */
public enum PreferenceCategory {
	FOOD("food_pref", "cat_eat-drink"),
	MOVIES("movies_pref", "list_movie"),
	MUSIC("music_pref", "cat_music"),
	HOBBIES("hobbies_pref", "cat_hobbies-pet"),
	SPORTS_FITNESS("sports_pref", "cat_sports-fitness"),
	POLITICS("politics_pref", "cat_society_politics");
	
	private String id;
	private String formField;
	
	PreferenceCategory(String field, String hunchId){
		id = hunchId;
		formField = field;
	}
	
	public String getHunchId(){
		return id;
	}
	
	public String getFormField(){
		return formField;
	}
}
