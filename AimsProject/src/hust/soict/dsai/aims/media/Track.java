package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
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
	
	// Constructor method
	public Track(String title, int length) {
		// Set length and title 
		this.setLength(length);
		this.setTitle(title);
	}
	
	// implementing playable
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
