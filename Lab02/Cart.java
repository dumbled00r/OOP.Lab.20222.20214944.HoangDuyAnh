
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	private int qtyOrdered = 0;


	public DigitalVideoDisc[] addDigitalVideoDisc(DigitalVideoDisc disc) {
		
		if (qtyOrdered<MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			
			System.out.println("The disc has been added");
			return itemsOrdered;
		}
		else{
			System.out.println("The cart is almost full");
			
			return itemsOrdered;
		}
	}
	
	public DigitalVideoDisc[] removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
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
		return itemsOrdered;
	}
	
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i<qtyOrdered; i++) {
			sum+=itemsOrdered[i].getCost();
		}
		return sum;
		
	}

}
