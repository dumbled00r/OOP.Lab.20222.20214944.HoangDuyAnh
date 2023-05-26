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
		
		cart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Animation",
				"Aladin", 18.99f);
		
		cart.addDigitalVideoDisc(dvd3);
		cart.addDigitalVideoDisc(dvd3);
		cart.print();
		cart.totalCost();
		cart.searchForItem(1);
		
	}

}
