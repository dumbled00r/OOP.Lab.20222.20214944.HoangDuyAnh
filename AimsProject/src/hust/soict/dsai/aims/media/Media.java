package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.io.IOException;
import java.util.Comparator;

public abstract class Media {
	private static int nItems = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	private int id;
	private String title;
	private String category;
	private float cost;
	
	// Constructor method
	public Media(String title, String category, float cost) throws IOException {
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
	public void setId(int id) throws IOException {
		if (id >= 0){
			this.id = id;
		} else {
			throw new IOException("ID must not be negative");
		}

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
	public void setTitle(String title) throws IOException {
		if (!title.equals("")){
			this.title = title;
		} else {
			throw new IOException("Title must not be an empty string");
		}
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
	public void setCost(float cost) throws IOException {
		if (cost >= 0) {
			this.cost = cost;
		} else {
			throw new IOException("Cost must not be less than 0");
		}
	}
	
	// Overriding toString method 
	@Override
	public abstract String toString();
	
	// Overriding equals method
	@Override
	public boolean equals(Object obj) throws NullPointerException, ClassCastException{
		try {
			Media media = (Media) obj;
			return this.getTitle() == media.getTitle();
		} catch (ClassCastException e) {
			System.err.println("Cannot cast to Media");
			return false;
		} catch (NullPointerException e) {
			System.err.println("Cannot point to the object");
			return false;
		}
	}
	
	// check if Match by ID
	public boolean isMatchByID(int id) throws IOException {
		if (id >= 0) {
			return this.getId() == id;
		} else {
			throw new IOException("Comparing id must be greater or equal to zero");
		}
	}
	
	// check if Match by Title
	public boolean isMatchByTitle(String title) throws IOException {
		if (title.equals("")) {
			throw new IOException("Comparing title must not be an empty string");
		}
		return this.title.equals(title);
	}
	
	// Try to play 
	public void tryToPlay() throws ClassCastException, PlayerException {
		if (this instanceof Playable) {
			var playable = (Playable) this;
			try {
				playable.play();
			} catch (PlayerException e) {
				throw e;
			}
		} else {
			throw new ClassCastException("The media is not playable");
		}
	}
}
