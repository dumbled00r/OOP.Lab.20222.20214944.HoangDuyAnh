package hust.soict.dsai.aims.media;

public abstract class Media {
	private static int nItems = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public Media(String title, String category, float cost) {
		id = nItems++;
		this.setTitle(title);
		this.setCategory(category);
		this.setCost(cost);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

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
	
	// Overriding toString method 
	@Override
	public abstract String toString();
	
	// Overriding equals method
	@Override
	public boolean equals(Object obj) {
		Media media = (Media) obj;
		return this.getTitle() == media.getTitle();
	}
	
	// check if Match by ID
	public boolean isMatchByID(int id) {
		return this.getId() == id;
	}
	
	// check if Match by Title
	public boolean isMatchByTitle(String title) {
		return this.title.equals(title);
	}
}
