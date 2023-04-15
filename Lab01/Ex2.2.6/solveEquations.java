import java.util.Scanner;



public class solveEquations {

	public static void main(String[] args) {
		
		// Init scanner
		Scanner keyboard = new Scanner(System.in);
		
		// Enter degree of the equation
		System.out.println("Enter degree of the equation: ");
		int deg = keyboard.nextInt();
		keyboard.nextLine();
		
		switch (deg) {
		case 1:
			System.out.println("System of equation or not (Y/N)");
			String yn = keyboard.nextLine();
				switch(yn) {
				case "Y":
				{
					double[][] a = new double[1000][1000];
					for (int i = 0; i < 2; i++) {
						for (int j = 0; j < 2; j++) {
							System.out.println("Enter the co-efficient a["+(i+1)+"]"+"["+(j+1)+"]" + "= ");
							a[i][j] = keyboard.nextDouble();
							
						}
					}
					System.out.println(a[0][0]);
				}
				}
			
		}

	}

}
