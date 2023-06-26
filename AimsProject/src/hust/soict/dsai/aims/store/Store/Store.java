package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;
import java.io.IOException;
import java.util.*;

public class Store {
	public static final int MAX_NUMBER_OF_ITEMS = 100;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	// Add Media to the score
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsInStore.size() < MAX_NUMBER_OF_ITEMS) {
			itemsInStore.add(media);
			System.out.println("The media has been added to the store");
		}
		else {
			throw new LimitExceededException("The store is full, cannot add more items!");
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
		}
		else System.out.println("Media is not found");
	}

	// Method to print items in store
	public void print() {
		System.out.println("**********************STORE***********************");
		for (Media media : itemsInStore) {
			System.out.println(media.getId() + 1 + ". " + media.toString());
		}
		System.out.println("**************************************************");
	}
	
	// Method to search for an item in store by title
	public Media searchByTitle(String title) throws IOException {
		for (Media media : itemsInStore)
			if (media.isMatchByTitle(title)) 
				return media;
		return null;
	}
	
	// Return current items in store
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}	
}
