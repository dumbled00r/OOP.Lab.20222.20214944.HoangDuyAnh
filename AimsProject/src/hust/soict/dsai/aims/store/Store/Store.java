package hust.soict.dsai.aims.store.Store;

import java.lang.NullPointerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBER_OF_DVDS = 100000;
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBER_OF_DVDS];
	
	private int currentNBDVDs;
	
	// Add DVD to the score
	public void addDVD(DigitalVideoDisc disc) {
		
		if (currentNBDVDs < MAX_NUMBER_OF_DVDS) {
			itemsInStore[currentNBDVDs++] = disc;
			System.out.println("The DVD with title "+ disc.getTitle() + " has been added to the store");
			
		}
		
		else {
			System.out.println("The store is currently full");
		}
	}
	
	// Remove DVD from the store
	public void removeDVD(DigitalVideoDisc disc) {
		boolean match = false;
		
		// Search for the DVD
		for (int i = 0; i < currentNBDVDs; i++) {
			if (itemsInStore[i] == disc) {
				match = true;
				for (int j = i; j< currentNBDVDs; j++) {
					itemsInStore[j] = itemsInStore[j+1];
				}
			currentNBDVDs--;
			break;
			}
		}
		if (match) {
			System.out.println("The DVD with title " + disc.getTitle() + " is found and is removed from the store");
		}
		else System.out.println("DVD is not found");
	}
	
	
	//  This is just for testing methods above
	
	public void print() {
		int idx = 1;
		for (DigitalVideoDisc disc: itemsInStore) {
			try {
				System.out.println(idx + ". " + disc.toString());
				idx++;
			}
			catch (NullPointerException e) {
			}
		}
	}
}
