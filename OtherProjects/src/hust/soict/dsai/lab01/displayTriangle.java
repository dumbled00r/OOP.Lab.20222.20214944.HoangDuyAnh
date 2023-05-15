package hust.soict.dsai.lab01;
import java.util.Scanner;

public class displayTriangle {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int height = keyboard.nextInt();
		
		for (int i = height; i >0; i--) {
			System.out.println(" ".repeat(i-1)+"*".repeat(2*(height-i)+1));
		
		}
		keyboard.close();
	}
}
