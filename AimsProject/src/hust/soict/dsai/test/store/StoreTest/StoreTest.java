package hust.soict.dsai.test.store.StoreTest;
import hust.soict.dsai.aims.store.Store.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		// Add dvd to store
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		// add dvd to store
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation",
				"Aladin", 18.99f);
		// add dvd to store
		store.addDVD(dvd3);
		// Test print out store
		store.print();
		// remove dvd from store
		store.removeDVD(dvd3);
		// print out store after deleted
		store.print();
	}
}
