package hust.soict.dsai.aims.media;

import java.io.IOException;

public abstract class Disc extends Media {
	protected int length;
	protected String director;

	public Disc(String title, String category, float cost) throws IOException {
		super(title, category, cost);
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
	
	// Constructor method
	public Disc(String title, String category, String director, int length, float cost) throws IOException {
		// Inherit from superior class
		super(title, category, cost);
		// set values for attributes length and director
		this.setLength(length);
		this.setDirector(director);
	}
	
	// Method to print out Disc
	@Override
	public String toString() {
		return "Disc - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": "+ this.getCost() + "$";
	}
}