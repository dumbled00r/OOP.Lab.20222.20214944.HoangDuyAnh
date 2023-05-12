
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	private int qtyOrdered;


	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		if (qtyOrdered<MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			
			System.out.println("The DVD has been added");
			
		}
		else{
			System.out.println("The cart is almost full");
			
			
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		boolean match = false;
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
			System.out.println("DVD is found and is removed from cart");
		}
		else System.out.println("DVD is not found");
	}
	
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i<qtyOrdered; i++) {
			sum+=itemsOrdered[i].getCost();
		}
		return sum;
	

	}
	
	// Overload the method
	
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
	
	
	
	
	

}
