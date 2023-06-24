package hust.soict.dsai.aims.console;

import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;
import java.io.IOException;

public class StoreUpdate extends Handling {

	protected StoreUpdate(Handling menu) {
		super(menu);
		// TODO Auto-generated constructor stub
		options.clear();
		options.add("Add a media");
		options.add("Remove a media");
	}
	
	// Just to display message
	@Override
	protected void displayInfo() {
		// TODO Auto-generated method stub
		System.out.print("Update store: ");
	}
	
	// Handling choice
	@Override
	protected void handleChoice(int choice) throws IOException, LimitExceededException {
		// TODO Auto-generated method stub
		switch (choice) {
			case 1:
				new AddMedia(this).display();
				break;
			case 2:
				Media media = null;
				System.out.println("Enter item's title: ");
				String tempTitle = scanner.nextLine().trim();
				System.out.println();
				// Check whether the item exists in the store
				media = store.searchByTitle(tempTitle);
				if (media == null) {
					System.out.println(tempTitle + " is not in the store!");
					scanner.nextLine();
					break;
				}
				else {
					store.removeMedia(media);
					System.out.println(tempTitle+ " has been removed");
					scanner.nextLine();
					break;
				}
		}
	}
}