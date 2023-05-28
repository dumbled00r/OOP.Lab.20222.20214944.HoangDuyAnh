package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Store {
	public static final int MAX_NUMBER_OF_ITEMS = 100000;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	// Add Media to the score
	public void addMedia(Media media) {
		if (itemsInStore.size() < MAX_NUMBER_OF_ITEMS) {
			itemsInStore.add(media);
			System.out.println("The media has been added to the store");
		}
		else {
			System.out.println("The store is currently full");
		}
	}
	
	// Remove Media from the store
	public void removeMedia(Media media) {
		// Check if store is empty
		if (itemsInStore.size() == 0) {
			System.out.println("The store is empty");
		}
		// Check if item exists in store
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("The media is found and is removed from the store");
		}
		else System.out.println("Media is not found");
	}
}
