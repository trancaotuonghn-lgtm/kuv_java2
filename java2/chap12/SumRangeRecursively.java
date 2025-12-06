package chap12_ex;

import java.util.*;

public class SumRangeRecursively {
	public static void main (String[] args) {
		int[] numbers = new int[20];
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Array elements:");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(100);
			System.out.print(numbers[i] + " ");
		}
		System.out.println("\n");
		
		int start, end;
		
		do {
			System.out.print("Enter starting position (0-19): ");
			start = input.nextInt();
		} while (start < 0 || start >= numbers.length);
		
		do {
			System.out.print("Enter ending position (must be more or equal the start number and smaller or equal 19): ");
			end = input.nextInt();
		} while (end < start || end >= numbers.length);
		
		System.out.print("Values in range: ");
		for (int i = start; i <= end; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		int sum = sumArrayRange(numbers, start, end);
		System.out.println("Sum of elements from index " + start + " to " + end + " is: " + sum);
	}
	
	public static int sumArrayRange(int[] arr, int current, int end) {
		if (current > end) {
			return 0;
		}
		
		return arr[current] + sumArrayRange(arr, current + 1, end);
	}
}
