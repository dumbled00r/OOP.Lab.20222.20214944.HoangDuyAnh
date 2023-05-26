package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
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
	
	
	// Construct method
	
	public DigitalVideoDisc() {
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	/**
	 * 
	 * @param Create DVD by title
	 */
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	
	/**
	 * @param Create DVD by category, title, cost
	 */
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
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
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
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
		nbDigitalVideoDiscs++;
		this.setId(nbDigitalVideoDiscs);
	}
	
	public String toString() {
	
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": "+ this.getCost() + "$";
	}
	
	
	public boolean isMatch(String title) {
		
		if (this.getTitle() == title) {
			return true;
		}
		return false;
	}
	
//	
//	
//	public void toString(int length) {
//			String newLength = length.toString();
//			
//		}
//	
//	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
