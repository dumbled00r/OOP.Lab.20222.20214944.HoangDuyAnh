package hust.soict.dsai.lab01;
import java.util.*;


public class Operations {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		//Enter 2 nums
		System.out.print("Enter the first number: ");
		double num1 = keyboard.nextDouble();
		
		System.out.print("Enter the second number: ");
		double num2 = keyboard.nextDouble();
		keyboard.close();
		double sum = num1 + num2;
		double difference = num1 - num2;
		double product = num1*num2;
		double quotient = num1/num2;
		System.out.println("Sum of two numbers is: "+ sum );
		System.out.println("Difference of two numbers is: "+ difference );
		System.out.println("Product of two numbers is: "+ product);
		System.out.println("Quotient of two numbers is: "+ quotient );
	}

}
