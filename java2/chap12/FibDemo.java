package chap12_ex;

import java.util.Scanner;

public class FibDemo {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the maximum ending value to display: ");
		int limit = input.nextInt();
		
		System.out.print("Fibonacci sequence up to " + limit + ": "); 
		
		int n = 1;
		while (true) {
			int fibValue = calculateFibonacci(n);
			if (fibValue > limit) {
				break;
			}
			System.out.print(fibValue + " ");
			n++; 
		}
		System.out.println();
	}
	
	public static int calculateFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		
		return calculateFibonacci(n - 1) + calculateFibonacci(n - 2); 
	}
}
