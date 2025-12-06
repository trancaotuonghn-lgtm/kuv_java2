package chap12_ex;

import java.util.Scanner;

public class MultiplicationByAdding {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int num1 = input.nextInt();
		
		System.out.print("Enter second integer: ");
		int num2 = input.nextInt();
		
		int result = recursiveMultiply(num1, num2);
		System.out.println(num1 + " * " + num2 + " = " + result);
	}
	
	public static int recursiveMultiply(int a, int b) {
		if (b == 0) {
			return 0;
		}
		
		if (b < 0) {
			return -recursiveMultiply(a, -b); 
		} 
		
		return a + recursiveMultiply(a, b - 1);
	}
}