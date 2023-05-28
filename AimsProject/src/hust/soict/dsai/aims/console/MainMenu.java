package hust.soict.dsai.aims.console;

import java.util.*;

public class MainMenu extends Handling {
	public MainMenu(hust.soict.dsai.aims.store.Store.Store store, 
			hust.soict.dsai.aims.cart.Cart.Cart cart, Scanner scanner) {
		super(store, cart, scanner);
		options.clear();
		options.add("View store");
		options.add("Update store");
		options.add("See current cart");
	}

	// Print message
	@Override
	protected void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("\nAIMS: ");
	}
	
	// Handling choice
	@Override
	protected void handleChoice(int choice) {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1:
				new Store(this).display();
				break;
			case 2:
				new StoreUpdate(this).display();
				break;
			case 3:
				new CartMenu(this).display();
				break;
		}
	}
}