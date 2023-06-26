package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart.*;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class CartTest {
	public static void main(String[] args) throws IOException, LimitExceededException {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart cart = new Cart();
		// Create new dvd and add it to the cart
		DigitalVideoDisc dvd1 = 
				new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		// Create new book and add it to the cart
		Book book1 = 
				new Book("Star Wars", 
				 "George Lucas", 24.95f);
		cart.addMedia(book1);
		// Create new CD and add it to the cart
		CompactDisc cd1 = 
				new CompactDisc("Making my way", "Pop",
				"Unknown", 5,  18.99f, "Son Tung M-TP");
		cart.addMedia(cd1);
		// print out cart
		cart.print();
		// cart's total cost
		cart.totalCost();
		// search for item by ID
		cart.searchForItemByID(1);
		// search for item by title
		cart.searchForItemByTitle("The Lion King");
	}
}
