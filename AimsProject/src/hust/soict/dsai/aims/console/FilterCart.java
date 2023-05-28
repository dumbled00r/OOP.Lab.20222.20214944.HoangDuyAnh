package hust.soict.dsai.aims.console;

import java.util.*;

public class FilterCart extends Handling {
	public FilterCart(Handling menu) {
		super(menu);
		options.clear();
		options.add("Filter by ID");
		options.add("Filter by title");
	}
	
	// Print out cart
	@Override
	protected void displayInfo() {
		// TODO Auto-generated method stub
		cart.print();
	}
	
	// Handling choice
	@Override
	protected void handleChoice(int choice) {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1:
				System.out.println("Enter item's ID: ");
				int id = -1;
				try {
					id = scanner.nextInt();
				} catch (InputMismatchException e) {};
				scanner.nextLine();
				cart.searchForItemByID(id);
				break;
			case 2:
				System.out.println("Enter item's title: ");
				String tempTitle = scanner.nextLine().trim();
				if (tempTitle.isEmpty()) {
					System.out.println("Title cannot be empty!");
					break;
				}
				else cart.searchForItemByTitle(tempTitle);
				break;
		}
	}
}