package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	// Construct method
	public DigitalVideoDisc() {
		super(null, null, null, 0, 0);
	}
	
	/**
	 * @param Create DVD by title
	 */
	public DigitalVideoDisc(String title) {
		super(title, null, null, 0, 0);
	}
	
	/**
	 * @param Create DVD by category, title, cost
	 */
	public DigitalVideoDisc(String category, String title, float cost) {
		super(title, category, null, 0, cost);
	}

	/**
	 * @param Create DVD by director, category, title and cost
	 */
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super(title, category, director, 0, cost);
	}
	
	/**
	 * @param Create DVD by all attributes: title, category, director, length and cost
	 */
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, 0, cost);
	}
	
	// Method to print out DVD format
	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": "+ this.getCost() + "$";
	}
	
	// implementing playable
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
