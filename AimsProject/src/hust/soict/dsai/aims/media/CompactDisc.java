package hust.soict.dsai.aims.media;
import java.util.*;
public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
		super(title, category, director, length, cost);
		this.setArtist(artist);
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	// Add track to compact disc
	public void addTrack(Track track) {
		// Check if track is in the list or not
		if (tracks.contains(track)) {
			System.out.println("The track already exists in the compact disc");
		}
		else {
			tracks.add(track);
			System.out.println("The track has been added to the compact disc");
		}
	}
	
	// Remove track from compact disc
	public void removeTrack(Track track) {
		// Check if track is in the list or not
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("The track has been removed");
		}
		else {
			System.out.println("Given track does not exist");
		}
	}
	
	// Calculate the length of CD
	@Override
	public int getLength() {
		int length = 0;
		// Iterate through all and get the length
		for (Track track: tracks) {
			length += track.getLength();
		}
		return length;
	}
}
