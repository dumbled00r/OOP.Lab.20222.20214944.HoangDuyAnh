package hust.soict.dsai.test.disc.TestPassingParameter;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.*;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		
		
		
		swap(jungleDVD, cinderellaDVD);
		
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		

	}
	
	
	// Corrected swap method
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		
		String tmpTitle = dvd1.getTitle();
		String tmpCategory = dvd1.getCategory();
		String tmpDirector = dvd1.getDirector();
		int    tmpLength = dvd1.getLength();
		float  tmpCost = dvd1.getCost();
	
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		
		dvd2.setTitle(tmpTitle);
		dvd2.setCategory(tmpCategory);
		dvd2.setDirector(tmpDirector);
		dvd2.setCost(tmpCost);
		dvd2.setLength(tmpLength);
		
		
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	

	
}
