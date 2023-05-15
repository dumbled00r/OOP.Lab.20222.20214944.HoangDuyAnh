package hust.soict.dsai.lab01;
import java.util.*;


public class matrixAdding {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of rows: ");
		int rows = scanner.nextInt();
		System.out.print("Enter the number of columns: ");
		int columns = scanner.nextInt();
		
		double[][] mtA = new double[rows][columns];
		double[][] mtB = new double[rows][columns];
		double[][] resmt = new double[rows][columns];
		
		
		// Input matrix A
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print("A["+(i+1)+"]["+(j+1)+"] = ");
				mtA[i][j] = scanner.nextDouble();
				
			}
		}
			
		// Input matrix B
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print("B["+(i+1)+"]["+(j+1)+"] = ");
				mtB[i][j] = scanner.nextDouble();
				
			}
		}
		
		System.out.print("The first matrix is: \n");
		// print result
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(mtA[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		System.out.print("The second matrix is: \n");
		// print result
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(mtB[i][j] + "\t");
			}
			System.out.println();
		}
		
		
		// Adding two matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				resmt[i][j] = mtA[i][j] + mtB[i][j];

			}
		}
		
		System.out.print("The result matrix is: \n");
		// print result
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(resmt[i][j] + "\t");
			}
			System.out.println();
		}
		scanner.close();
	}

}
