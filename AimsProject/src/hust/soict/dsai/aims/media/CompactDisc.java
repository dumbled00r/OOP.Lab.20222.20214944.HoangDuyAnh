package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.io.IOException;
import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist) throws IOException {
		super(title, category, director, length, cost);
		this.setArtist(artist);
	}

	public CompactDisc(String title, String category, float cost) throws IOException {
		super(title, category, cost);
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
			System.out.println("The track already exists in the CD");
			System.out.println();
		}
		else {
			tracks.add(track);
			System.out.println("The track has been added to the CD");
			System.out.println();
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
	
	// implementing playable
	public void play() throws PlayerException {
		System.out.println("Playing " + this.getTitle());
		if (this.getLength() > 0) {
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				if (nextTrack.getLength() >= 0) {
					nextTrack.play();
				} else {
					throw new PlayerException(nextTrack.getTitle() + " has non-positive length");
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
	}
	
	// Method to print out CD
	@Override
	public String toString() {
		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": "+ this.getCost() + "$";
	}
}