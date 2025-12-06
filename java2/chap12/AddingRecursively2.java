package chap12_ex;

import java.util.Scanner;

public class AddingRecursively2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int input1, input2;

        System.out.print("Enter first integer: ");
        input1 = input.nextInt();

        System.out.print("Enter second integer: ");
        input2 = input.nextInt();

        // Determine actual low and high before calling recursion
        int low = Math.min(input1, input2);
        int high = Math.max(input1, input2);
        
        System.out.print("The sequence of numbers is: ");
        for (int i = low; i <= high; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int total = sumRecursively(low, high);
        System.out.println("Sum of numbers between " + low + " and " + high + " is: " + total);
    }

    public static int sumRecursively(int low, int high) {
        if (high < low) {
            return 0;
        }
        return high + sumRecursively(low, high - 1);
    }
}