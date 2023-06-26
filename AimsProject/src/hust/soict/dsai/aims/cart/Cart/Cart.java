package hust.soict.dsai.aims.cart.Cart;

import java.io.IOException;
import java.lang.NullPointerException;
import hust.soict.dsai.aims.media.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered =
			FXCollections.observableArrayList();

	private ObservableList<Media> filteredItems =
			FXCollections.observableArrayList();
	// add a media to cart
	public void addMedia(Media media) throws LimitExceededException {
		// Check whether the Cart is full
		if (itemsOrdered.size()<MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The item has been added to the cart");
		}
		else{
			throw new LimitExceededException("The cart is currently full, cannot add more items!");
		}
	}
	
	// Remove a media from cart 
	public void removeMedia(Media media) {
		// Check if the cart is empty
		if (itemsOrdered.size() == 0) {
			System.out.println("The cart is currently empty");
		}
		// Check whether the media is in the cart 
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The item has been removed from the cart");
		} else System.out.println("The item is not in the cart");
	}
	
	// Calculate the total cost
	public float totalCost() {
		float sum = 0.0f;
		// Iterate through all media in the cart
		for (Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}
	
	// Method to print out current cart's status
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		try {
			for (Media media : itemsOrdered) {
				System.out.println(media.getId() + ". " + media.toString());
			}
		} catch (NullPointerException e) {}
		// Print out total cost
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("**************************************************");
	}
	
	// Search for item in cart by ID
	public ObservableList<Media> searchForItemByID(int id) {
		filteredItems.clear();
		boolean found = false;
		int idx = 1;
		// Look for item in the cart, if there exists one, return true
		for (Media media : itemsOrdered) {
			try {
				if (media.isMatchByID(id)) {
					found = true;
					break;
				}
			}
			catch (NullPointerException e) {
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		// Print out items that we're looking for if exist
		if (found) {
			System.out.println("***************************************************");
			System.out.println("Results for item(s) with ID "+ id + ":");
			for (Media media : itemsOrdered) {
				try {
					if (media.isMatchByID(id)) {
						System.out.println(idx + ". " + media.toString());
						idx++;
						filteredItems.add(media);
					}
				}
				catch (NullPointerException e) {
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("***************************************************");
		}
		else {
			System.out.println("There is no items with ID "+ id);
		}
		return filteredItems;
	}

	// Search for item in cart by title
	public ObservableList<Media> searchForItemByTitle(String title) {
		filteredItems.clear();
		boolean found = false;
		int idx = 1;
		// Look for item in the cart, if there exists one, return true
		for (Media media : itemsOrdered) {
			try {
				if (media.isMatchByTitle(title)) {
					found = true;
					break;
				}
			}
			catch (NullPointerException e) {
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		// Print out items that we're looking for if exist
		if (found) {
			System.out.println("***************************************************");
			System.out.println("Results for item(s) with title "+ title + ":");
			for (Media media : itemsOrdered) {
				try {
					if (media.isMatchByTitle(title)) {
						System.out.println(idx + ". " + media.toString());
						filteredItems.add(media);
						idx++;
					}
				}
				catch (NullPointerException e) {	
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			System.out.println("***************************************************");
		}
		else {
			System.out.println("There is no items with title "+ title);
		}
		return filteredItems;
	}
	
	// Sort cart by title
	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	// Sort cart by price
	public void sortByPrice() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	// Place order
	public void placeOrder() {
		itemsOrdered.clear();
		System.out.println("Order placed!");
	}

	// get ordered items
	public ObservableList<Media> getItemsOrdered(){
		return itemsOrdered;
	}
}