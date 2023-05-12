
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	// Construct method
	
	public DigitalVideoDisc() {
		
	}
	
	/**
	 * 
	 * @param Create DVD by title
	 */
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
	}
	
	
	/**
	 * @param Create DVD by category, title, cost
	 */
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
	}

	/**
	 * @param Create DVD by director, category, title and cost
	 */
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		this.setDirector(director);
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
	}
	
	/**
	 * @param Create DVD by all attributes: title, category, director, length and cost
	 */
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setTitle(title);
		this.setCategory(category);
		this.setDirector(director);
		this.setLength(length);
		this.setCost(cost);
	}
	
	
	
	
	
}
