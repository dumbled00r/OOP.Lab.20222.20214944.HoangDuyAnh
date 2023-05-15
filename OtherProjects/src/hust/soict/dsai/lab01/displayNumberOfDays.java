package hust.soict.dsai.lab01;
import java.util.*;

public class displayNumberOfDays {

	public static void main(String[] args) {
		
		

		
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter month: ");
		
		String input = keyboard.nextLine().toLowerCase();

        Map<String, Integer> months = new HashMap<>();
        
        // Map to numbers
        months.put("january", 1);
        months.put("jan.", 1);
        months.put("jan", 1);
        months.put("1", 1);
        months.put("february", 2);
        months.put("feb.", 2);
        months.put("feb", 2);
        months.put("2", 2);
        months.put("march", 3);
        months.put("mar.", 3);
        months.put("mar", 3);
        months.put("3", 3);
        months.put("april", 4);
        months.put("apr.", 4);
        months.put("apr", 4);
        months.put("4", 4);
        months.put("may", 5);
        months.put("5", 5);
        months.put("june", 6);
        months.put("jun.", 6);
        months.put("jun", 6);
        months.put("6", 6);
        months.put("july", 7);
        months.put("jul.", 7);
        months.put("jul", 7);
        months.put("7", 7);
        months.put("august", 8);
        months.put("aug.", 8);
        months.put("aug", 8);
        months.put("8", 8);
        months.put("september", 9);
        months.put("sep", 9);
        months.put("sept.", 9);
        months.put("9", 9);
        months.put("october", 10);
        months.put("oct.", 10);
        months.put("oct", 10);
        months.put("10", 10);
        months.put("november", 11);
        months.put("nov", 11);
        months.put("nov.", 11);
        months.put("11", 11);
        months.put("december", 12);
        months.put("dec.", 12);
        months.put("dec", 12);
        months.put("12", 12);
       
        Integer monthNum = months.get(input);
        if (monthNum == null) {
            System.out.print("Please re-enter the month: ");
            System.exit(0);
        }
        
        System.out.print("Enter year: ");
		int yr = keyboard.nextInt();
		
		boolean leapyr = false;
		if ( yr%4 == 0 && yr%100 != 0 || yr%400 == 0 ) {
			leapyr = true;
		}
		
		keyboard.close();
        
        Map<Integer, Integer> noOfDays = new HashMap<>();
        
        // Map months to days
        noOfDays.put(1,31);
        
        if (leapyr) {
        	noOfDays.put(2,29);
        } else {
        	noOfDays.put(2,28);
        }
        noOfDays.put(3,31);
        noOfDays.put(4,30);
        noOfDays.put(5,31);
        noOfDays.put(6,30);
        noOfDays.put(7,31);
        noOfDays.put(8,31);
        noOfDays.put(9,30);
        noOfDays.put(10,31);
        noOfDays.put(11,30);
        noOfDays.put(12,31);
        
        Integer noDays = noOfDays.get(monthNum);
        
        System.out.println("The number of days is: " + noDays);
        
		
		}
	}
