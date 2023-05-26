package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
	private int length;
	private String director;
	
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
	public Disc(String title, String category, String director, int length, float cost) {
		// Inherit from superior class
		super(title, category, cost);
		// set values for attributes length and director
		this.setLength(length);
		this.setDirector(director);
	}
}
