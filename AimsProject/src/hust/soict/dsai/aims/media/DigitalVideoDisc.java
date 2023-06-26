package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.io.IOException;

public class DigitalVideoDisc extends Disc implements Playable {
	// Construct method
	public DigitalVideoDisc() throws IOException {
		super(null, null, null, 0, 0);
	}
	
	/**
	 * Create DVD by title
	 */
	public DigitalVideoDisc(String title) throws IOException {
		super(title, null, null, 0, 0);
	}
	
	/**
	 * Create DVD by category, title, cost
	 */
	public DigitalVideoDisc(String category, String title, float cost) throws IOException {
		super(title, category, null, 0, cost);
	}

	/**
	 * Create DVD by director, category, title and cost
	 */
	public DigitalVideoDisc(String director, String category, String title, float cost) throws IOException {
		super(title, category, director, 0, cost);
	}
	
	/**
	 * Create DVD by all attributes: title, category, director, length and cost
	 */
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws IOException {
		super(title, category, director, length, cost);
	}
	
	// Method to print out DVD format
	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": "+ this.getCost() + "$";
	}
	
	// implementing playable
	public void play() throws PlayerException {
		// Check if track's length is greater than 0 or not
		if (this.getLength() >= 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
}
