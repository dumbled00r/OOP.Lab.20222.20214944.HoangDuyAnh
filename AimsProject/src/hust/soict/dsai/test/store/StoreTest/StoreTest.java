package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.store.Store.*;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class StoreTest {
	public static void main(String[] args) throws LimitExceededException, IOException {
		// TODO Auto-generated method stub
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		// Add media to store
		store.addMedia(dvd1);
		// remove media from store
		store.removeMedia(dvd1);
	}
}