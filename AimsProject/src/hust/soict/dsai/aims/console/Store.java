package hust.soict.dsai.aims.console;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class Store extends Handling {
	public Store(Handling menu) {
		super(menu);
		options.clear();
		options.add("See a media's details");
		options.add("Add a media to cart");
		options.add("Play a media");
		options.add("See current cart");
	}
	
	// Display store
	@Override
	protected void displayInfo() {
		store.print();
	}
	
	// Handling choice
	@Override
	protected void handleChoice(int choice) throws IOException, LimitExceededException, PlayerException {
		Media item = null;
		if (choice <= 3) {
			System.out.println("Enter title of the item: ");
			String tempTitle = scanner.nextLine();
			item = store.searchByTitle(tempTitle.trim());
			// Check whether the store has that item
			if (item == null) {
				System.out.println("There is no " + tempTitle.trim() + " in the store");
				// Separator
				scanner.nextLine();
				return;
			}
		}
		switch(choice) {
			case 1:
				new MediaDetailsMenu(this, item).display();
				scanner.nextLine();
				break;
			case 2:
				cart.addMedia(item);
				scanner.nextLine();
				break;
			case 3:
				item.tryToPlay();
				scanner.nextLine();
				break;
			case 4:
				new CartMenu(this).display();
				break;
		}
	}
}
