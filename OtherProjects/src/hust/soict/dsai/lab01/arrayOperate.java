package hust.soict.dsai.lab01;
import java.util.*;


public class arrayOperate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of elements: ");
		int elementsNumber = scanner.nextInt();
		
		double[] arr = new double[elementsNumber];
		
		// Input arrays
		for (int i = 0; i < elementsNumber; i++) {
			System.out.print("Enter arr["+i+"] = ");
			arr[i] = scanner.nextDouble();
		}
		
		System.out.print("Your input array is: " + Arrays.toString(arr));
		// Sort arrays
		Arrays.sort(arr);
		
		double sum = 0;
		
		for (double num : arr) {
			sum += num;
		}
		
		double avg = sum/arr.length;
		
		System.out.print("\nThe sorted array is: " + Arrays.toString(arr));
		System.out.print("\nSum of the array is: " + sum);
		System.out.print("\nAverage value of the array's elements is: " + avg);
		
		
		scanner.close();
	}

}
