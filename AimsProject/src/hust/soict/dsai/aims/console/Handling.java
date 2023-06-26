package hust.soict.dsai.aims.console;

import java.io.IOException;
import java.util.*;
import hust.soict.dsai.aims.cart.Cart.*;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.store.Store.Store;

import javax.naming.LimitExceededException;
import java.util.InputMismatchException;

public abstract class Handling {
	private boolean loop = true;
	protected boolean begin = true;
	protected Store store;
	protected Cart cart;
	protected Scanner scanner;
	protected ArrayList<String> options = new ArrayList<String>();
	// Constructor methods
	protected Handling(Store store, Cart cart, Scanner scanner) {
		this.store = store;
		this.cart = cart;
		this.scanner = scanner;
	}
	
	protected Handling(Handling menu) {
		this.store = menu.store;
		this.cart = menu.cart;
		this.scanner = menu.scanner;
	}
	
	protected abstract void displayInfo();
	protected abstract void handleChoice(int choice) throws IOException, LimitExceededException, PlayerException;
	protected void exitLoop() { loop = false; };
	
	// Display menus method
	public void display() throws LimitExceededException, IOException {
		while (loop) {
			// Clear screen
			System.out.print("\033[H\033[2J");
			System.out.flush();
			displayInfo();
			// Display options
			if (!options.contains("Update store")) begin = false;
			if (begin == false) {
				System.out.println();
				System.out.println("Options: ");
			}
			System.out.println("--------------------------------");
			for (int i = 0; i<options.size(); i++) {
				System.out.println(i + 1 + ". " + options.get(i));
			}
			if (begin == false) System.out.println("0. Back");
			else System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: ");
			// scan user input
			int choice = -1;
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {};
			// Consume new line char
			scanner.nextLine();
			// Check whether choice is in the list, if not re-do the process
			if (choice < 0 || choice > options.size()) {
				System.out.println("The choice is not in the list");
				scanner.nextLine();
				continue;
			}
			// Check if user chooses to BACK
			if (choice == 0) {
				exitLoop();
				System.out.println();
				continue;
			}
			// Separator
			System.out.println();
			handleChoice(choice);
		}
	}	
}