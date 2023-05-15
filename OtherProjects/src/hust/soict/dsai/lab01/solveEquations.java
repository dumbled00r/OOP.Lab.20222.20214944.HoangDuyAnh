package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.io.IOException;;  


public class solveEquations {

	public static void main(String[] args) throws IOException {
		
		// Init scanner
		Scanner keyboard = new Scanner(System.in);
		
		// Enter degree of the equation
		System.out.print("Enter degree of the equation: ");
		int deg = keyboard.nextInt();
		keyboard.nextLine();
		
		switch (deg) {
		case 1:
			System.out.print("System of equation or not (Y/N) ");
			String yn = keyboard.nextLine();
			yn = yn.toUpperCase();
				switch(yn) {
				case "Y":
				{
					// Input co-efficients
					double[][] a = new double[2][2];
					double[] b = new double[2];
					System.out.print("\033[H\033[2J");  
					System.out.flush();  
					
					System.out.println("The equation has the form \n a11*x1 + a12*x2 = b1 \n a21*x1 + a22*x2 = b2");
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < 2; j++) {
							System.out.print("Enter the co-efficient a["+(i+1)+"]"+"["+(j+1)+"]" + " = ");
							a[i][j] = keyboard.nextDouble();
							
						}
						System.out.print("Enter the co-efficient b["+(i+1)+"] = ");
						b[i] = keyboard.nextDouble();
					}
					
					// Calculate determinant
					double D = a[0][0]*a[1][1] - a[1][0]*a[0][1];
					double D1 = b[0]*a[1][1] - b[1]*a[0][1];
					double D2 = a[0][0]*b[1] - a[1][0]*b[0];
					double x1 = D1/D;
					double x2 = D2/D;
					
					System.out.println("The solution is x = " +x1+", x2 = " +x2);
					
				} break;
				
				case "N":
				{	
					System.out.print("\033[H\033[2J");  
					System.out.flush();  
					
					System.out.println("The equation has the form \n a*x + b = 0");
				
					System.out.print("Enter a = ");
					double a = keyboard.nextDouble();
					
					if (a==0) {
						keyboard.close();
						throw new IOException("Co-efficient a must not be zero");
					}
					
						
					
					System.out.print("Enter b = ");
					double b = keyboard.nextDouble();
					
					double x = -b/a;
					
					System.out.println("The solution is x = " + x);
					
				} break;
				} break;
		
				// Second-degree equation
		case 2:
		{
			System.out.print("\033[H\033[2J");  
			System.out.flush();  
			
			System.out.println("The equation has the form \n a*x^2 + b*x + c = 0");
			
			System.out.print("Enter a = ");
			double a = keyboard.nextDouble();
			
			if (a==0) {
				keyboard.close();
				throw new IOException("Co-efficient a must not be zero");
				
			}
			
			System.out.print("Enter b = ");
			double b = keyboard.nextDouble();
			
			System.out.print("Enter c = ");
			double c = keyboard.nextDouble();
			
			double delta = b*b - 4*a*c;
			if (delta>0) {
				double x1 = (-b + Math.sqrt(delta))/(2*a);
				double x2 = (-b - Math.sqrt(delta))/(2*a);
				System.out.println("The solution is x1 = "+x1+ " x2 = "+x2);
			} else if (delta == 0) {
				double x = (-b)/(2*a);
				System.out.println("The solution is x = "+x);
				
			} else {
				System.out.println("The equation has no solution");
			}
		}break;
		
		}
		keyboard.close();
		
	}
	
}