package hust.soict.dsai.aims.cart.Cart;
import java.lang.NullPointerException;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.*;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	private int qtyOrdered;
	

	// add a DVD to cart
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		if (qtyOrdered<MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			
			System.out.println("The DVD with title " + disc.getTitle()+ " has been added to the cart");
			
		}
		else{
			System.out.println("The cart is almost full");
			
			
		}
	}
	
	
	// Remove a DVD from cart 
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		boolean match = false;
		
		// Search for the DVD
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				match = true;
				for (int j = i; j< qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
			qtyOrdered--;
			break;
			}
		}
		if (match) {
			System.out.println("The DVD with title " + disc.getTitle() + " is found and is removed from the cart");
		}
		else System.out.println("DVD is not found");
	}
	
	
	// Calculate the total cost
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i<qtyOrdered; i++) {
			sum+=itemsOrdered[i].getCost();
		}
		return sum;
	

	}
	
	// add DVD to the cart by using a list
	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc: dvdList) {
			if (qtyOrdered<MAX_NUMBER_ORDERED) {
				itemsOrdered[qtyOrdered++] = disc;
				
				System.out.println("The DVD has been added");
				
			}
			else{
				System.out.println("The cart is almost full");
						
			}
			
		}
	}
	*/
	
	
	// Vararg add DVDs to cart
	public void addDigitalVideoDisc(DigitalVideoDisc ... discs) {
		for (DigitalVideoDisc disc: discs) {
			if (qtyOrdered<MAX_NUMBER_ORDERED) {
				itemsOrdered[qtyOrdered++] = disc;
				
				System.out.println("The DVD has been added");
				
			}
			else{
				System.out.println("The cart is almost full");
						
			}
			
		}
		
		
	}
	
	// Add two DVDs to cart
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered+1<MAX_NUMBER_ORDERED) {
			
			itemsOrdered[qtyOrdered++] = dvd1;
			itemsOrdered[qtyOrdered++] = dvd2;
			
			System.out.println("The DVDs has been added");
		}
		
		else if (qtyOrdered == MAX_NUMBER_ORDERED-1){
			itemsOrdered[qtyOrdered++] = dvd1;
		}
		else{
			System.out.println("The cart is almost full");
			
			
		}
		
		
	}
	
	
	
	// Method to print out current cart's status
	
	public void print() {
		
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		try {
			
			for (int i = 0; i < qtyOrdered; i++) {
				System.out.println(i+1 + ". " + itemsOrdered[i].toString());
			}
		} catch (NullPointerException e) {}
		
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("***************************************************");
		
	}
	
	
	// Search for item in cart by ID
	
	public void searchForItem(int id) {
		boolean found = false;
		int idx = 1;
		
		// Look for item in the cart, if there exists one, return True
		for (int i = 0; i < qtyOrdered; i++) {
			try {
				
				if (itemsOrdered[i].getId() == id) {
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
			System.out.println("Results for item(s) with ID " + id + ":");
			for (int i = 0; i < qtyOrdered; i++) {
				try {
					
					if (itemsOrdered[i].getId() == id) {
						System.out.println(idx + ". "+ itemsOrdered[i].toString());
						idx++;
					}
				}
				catch (NullPointerException e) {
					}
				}
			System.out.println("***************************************************");
		}
		
		else {
			System.out.println("There is no items with ID "+ id );
		}
	}
	
	
	// Search for item in cart by title
	public void searchForItem(String title) {
		boolean found = false;
		int idx = 1;
		// Look for item in the cart, if there exists one, return True
		for (int i = 0; i < qtyOrdered; i++) {
			try {
				if (itemsOrdered[i].isMatch(title)) {
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
			for (int i = 0; i< qtyOrdered; i++) {
				try {
					if (itemsOrdered[i].isMatch(title)) {
						System.out.println(idx + ". " + itemsOrdered[i].toString());
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
	
	
	
	


