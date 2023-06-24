package hust.soict.dsai.aims.media;

import java.io.IOException;

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
	public void setLength(int length) throws IOException {
		if (length >= 0){
			this.length = length;
		} else {
			throw new IOException("Track's length must be greater or equal");
		}
	}
	
	// Constructor method
	public Track(String title, int length) throws IOException {
		// Set length and title 
		this.setLength(length);
		this.setTitle(title);
	}
	
	// implementing playable
	public void play() {
		System.out.println("Playing track: " + title);
		System.out.println("Track length: " + length);
	}
	
	// Override equal method for track
	@Override
	public boolean equals(Object o) {
		Track track = (Track) o;
		return (title == track.title) && (length == track.length);
	}
}
