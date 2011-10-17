package pennapps11.server;

/**Types of recommendations
 * 
 * @author Mark
 *
 */
public enum AdviceCategory {
	ACTIVITIES("Play Ball"),	
	INTERESTS("Crystal Ball"),
	MISC("Oddball");	
	
	private String name;
	
	AdviceCategory(String hunchId){
		name = hunchId;
	}
	
	public String getName(){
		return name;
	}
}
