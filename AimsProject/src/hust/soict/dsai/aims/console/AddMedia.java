package hust.soict.dsai.aims.console;

import java.io.IOException;
import java.util.InputMismatchException;
import hust.soict.dsai.aims.media.*;

import javax.naming.LimitExceededException;

public class AddMedia extends Handling {
	public AddMedia(Handling menu) {
		super(menu);
		options.clear();
		options.add("CD");
		options.add("DVD");
		options.add("Book");
	}
	
	// just to print out the necessary information
	@Override
	protected void displayInfo() {
		// TODO Auto-generated method stub
		System.out.print("Add a media: ");
	}
	
	// This is for making tracks to add to the CD
	private Track makeTrack() throws IOException {
		System.out.println("Enter title of the track: ");
		String title = scanner.nextLine().trim();
		if (title.isEmpty()) return null;
		int length = 0;
		System.out.println("Enter track's length: ");
		try {
			length = scanner.nextInt();
		} catch (InputMismatchException e) {}
		// Separator
		scanner.nextLine();
		return new Track(title, length);
	}
	
	// This is for adding media to the store
	@Override
	protected void handleChoice(int choice) throws IOException, LimitExceededException {
		// TODO Auto-generated method stub
		System.out.println("Enter title of the media: ");
		String title = scanner.nextLine().trim();
		// Check whether the title is empty or not
		if (title.isEmpty()) {
			System.out.println("The title cannot be empty!");
			// Separator
			scanner.nextLine();
			return;
		}
		// Check whether the store already has the item
		if (store.searchByTitle(title) != null) {
			System.out.println(title + " is already in the store!");
			// Separator
			scanner.nextLine();
			return;
		}
		System.out.println("Enter category: ");
		String category = scanner.nextLine().trim();
		String director = null;
		int length = 0;
		// Only CD and DVD has director and length
		if (choice <= 2) {
			System.out.println("Enter director: ");
			director = scanner.nextLine().trim();
			System.out.println("Enter length: ");
			try {
				length = scanner.nextInt();
			} catch (InputMismatchException e) {}
		}
		float cost = 0;
		System.out.println("Enter cost: ");
		try {
			cost = scanner.nextFloat();
		} catch (InputMismatchException e) {}
		// Separator
		scanner.nextLine();
		// Handle choice
		switch (choice) {
			case 1:
				var CD = new CompactDisc(title, category, director, length, cost, director);
				System.out.println("Enter track(s), press ENTER to stop adding: ");
				while (true) {
					var track = makeTrack();
					if (track == null) break;
					CD.addTrack(track);
				}
				store.addMedia(CD);
				break;
			case 2:
				store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
				break;
			case 3:
				var book = new Book(title, category, cost);
				System.out.println("Enter author(s), Press ENTER to stop adding: ");
				while (true) {
					String author = scanner.nextLine().trim();
					if (author.isEmpty()) break;
					book.addAuthor(author);
				}
				store.addMedia(book);
				break;
		}	
	}
}