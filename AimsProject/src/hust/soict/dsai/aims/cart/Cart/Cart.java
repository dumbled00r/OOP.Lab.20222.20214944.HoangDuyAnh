package hust.soict.dsai.aims.cart.Cart;

import java.lang.NullPointerException;
import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = 
			new ArrayList<Media>();
	// add a DVD to cart
	public void addMedia(Media media) {
		// Check whether the Cart is full
		if (itemsOrdered.size()<MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The item has been added to the cart");
		}
		else{
			System.out.println("The cart is almost full");	
		}
	}
	
	// Remove a DVD from cart 
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
				System.out.println(media.getId()+1 + ". " + media.toString());
			}
		} catch (NullPointerException e) {}
		// Print out total cost
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
		
	}
	
	// Search for item in cart by ID
	public void searchForItemByID(int id) {
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
					}
				}
				catch (NullPointerException e) {
				}
			}
			System.out.println("***************************************************");
		}
		else {
			System.out.println("There is no items with ID "+ id);
		}				
	}
	
	
	// Search for item in cart by title
	public void searchForItemByTitle(String title) {
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
						idx++;
					}
				}
				catch (NullPointerException e) {	
				}
			}
			System.out.println("***************************************************");
		}
		else {
			System.out.println("There is no items with title "+ title);
		}				
	}
}
	
	
	
	


