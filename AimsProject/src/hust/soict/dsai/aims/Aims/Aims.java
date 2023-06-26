package hust.soict.dsai.aims.Aims;

import java.io.IOException;
import java.util.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.console.*;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.cart.Cart.*;

import javax.naming.LimitExceededException;

public class Aims {
	public static void main(String[] args) throws IOException, LimitExceededException {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Store store = new Store();
		Scanner scanner = new Scanner(System.in);
		// Add media to store
		DigitalVideoDisc dvd1 = 
				new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 12, 19.95f);
		Book book1 = 
				new Book("Star Wars", 
				 "George Lucas", 24.95f);
		CompactDisc cd1 = 
				new CompactDisc("Making my way", "Pop",
				"Unknown", 5,  18.99f, "Son Tung M-TP");
		store.addMedia(dvd1);
		store.addMedia(book1);
		store.addMedia(cd1);
		// start menu
		var menu = new MainMenu(store, cart, scanner);
		menu.display();
	}
}