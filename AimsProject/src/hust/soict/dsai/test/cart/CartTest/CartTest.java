package hust.soict.dsai.test.cart.CartTest;
import hust.soict.dsai.aims.cart.Cart.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
public class CartTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a new cart
		Cart cart = new Cart();
		// Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		// add dvd to the cart
		cart.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		// add dvd to the cart
		cart.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation",
				"Aladin", 18.99f);
		// add 2 same dvd to the cart to test
		cart.addDigitalVideoDisc(dvd3);
		cart.addDigitalVideoDisc(dvd3);
		// print out cart
		cart.print();
		// cart's total cost
		cart.totalCost();
		// search for item by ID
		cart.searchForItem(1);
		// search for item by title
		cart.searchForItem("The Lion King");
	}
}
