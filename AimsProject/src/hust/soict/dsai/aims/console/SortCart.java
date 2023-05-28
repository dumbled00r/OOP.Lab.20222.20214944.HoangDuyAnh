package hust.soict.dsai.aims.console;

public class SortCart extends Handling {

	public SortCart(Handling menu) {
		// TODO Auto-generated constructor stub
		super(menu);
		options.clear();
		options.add("Sort by title");
		options.add("Sort by price");
	}
	
	// Display cart
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
				cart.sortByTitle();
				break;
			case 2:
				cart.sortByPrice();
				break;
		}
		exitLoop();
	}
}
