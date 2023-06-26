package hust.soict.dsai.aims.console;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;

public class MediaDetailsMenu extends Handling {
	private Media item;
	public MediaDetailsMenu(Handling menu, Media item) {
		super(menu);
		this.item = item;
		options.clear();
		options.add("Add to cart");
		options.add("Play");
	}
	
	// Display infos of medias
	@Override
	protected void displayInfo() {
		System.out.println("\n"+ item.toString());	
	}
	
	// Handle choice of user
	@Override
	protected void handleChoice(int choice) throws LimitExceededException, PlayerException {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1:
				cart.addMedia(item);
				scanner.nextLine();
				break;
			case 2:
				item.tryToPlay();
				scanner.nextLine();
				break;
		}
	}
}
