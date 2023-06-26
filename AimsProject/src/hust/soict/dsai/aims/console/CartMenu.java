package hust.soict.dsai.aims.console;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class CartMenu extends Handling {
	public CartMenu(Handling menu) {
		// TODO Auto-generated constructor stub
		super(menu);
		options.clear();
		options.add("Filter medias in cart");
		options.add("Sort medias in cart");
		options.add("Remove media from cart");
		options.add("Play a media");
		options.add("Place order");
	}

	// Display information
	@Override
	protected void displayInfo() {
		// TODO Auto-generated method stub
		cart.print();
	}
	
	// Handling choice
	@Override
	protected void handleChoice(int choice) throws IOException, LimitExceededException, PlayerException {
		// TODO Auto-generated method stub
		Media media = null;
		// Check whether option is 3 or 4 to input media
		if (choice >= 3 && choice <= 4) {
			System.out.println("Enter media's title: ");
			String tempTitle = scanner.nextLine().trim();
			media = store.searchByTitle(tempTitle);
			// Check if the item is null'
			if (media == null) {
				System.out.println(tempTitle + " is not in the store");
				scanner.nextLine();
				return;
			}
		}
		switch (choice) {
			case 1:
				new FilterCart(this).display();
				break;
			case 2:
				new SortCart(this).display();
				break;
			case 3:
				cart.removeMedia(media);
				break;
			case 4:
				media.tryToPlay();
				break;
			case 5:
				cart.placeOrder();
				break;
		}
	}
}