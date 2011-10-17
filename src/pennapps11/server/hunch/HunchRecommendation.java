package pennapps11.server.hunch;

import pennapps11.server.AdviceCategory;

/**Wrapper for Hunch recommendations
 * 
 * @author Mark
 *
 */
public class HunchRecommendation {
	private Topic topic;
	private AdviceCategory adviceCategory;
	private String name;
	private String imageURL;
	private double score;
	
	public HunchRecommendation(String name, Topic topic, AdviceCategory adviceCategory, String imageURL, double score){
		this.name = name;
		this.topic = topic;
		this.adviceCategory = adviceCategory;
		this.imageURL = imageURL;
		this.score = score;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public AdviceCategory getAdviceCategory() {
		return adviceCategory;
	}
	
	public String getImageURL(){
		return imageURL;
	}
	
	public String getName(){
		return name;
	}
	
	public void setScore(double score){
		this.score = score;
	}
	
	public double getScore(){
		return score;
	}

	@Override
	public String toString() {
		return "HunchRecommendation [topic=" + topic + ", adviceCategory="
				+ adviceCategory + ", name=" + name + ", imageURL=" + imageURL
				+ ", score=" + score + "]";
	}
	


}
