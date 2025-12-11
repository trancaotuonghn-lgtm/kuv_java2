//Chapter 12-ex4

import java.util.Scanner;

public class FibDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int endValue;

        System.out.println("Recursive Fibonacci Sequence Generator");
        
        // Prompt for positive ending value
        do {
            System.out.print("Enter a positive integer ending value: ");
            endValue = scanner.nextInt();
            if (endValue <= 0) {
                System.out.println("Error: Value must be positive.");
            }
        } while (endValue <= 0);

        System.out.print("Fibonacci sequence up to " + endValue + ": ");
        
        displayFibonacci(1, 1, endValue);
        
        System.out.println();
        scanner.close();
    }

    public static void displayFibonacci(int prev, int current, int maxVal) {
        // stop if the current number exceeds the maximum value allowed
        if (current > maxVal) {
            return;
        }

        // Display the current number
        System.out.print(current + " ");

        //Calculate the next number and call the method again
        int next = prev + current;
        
        // Pass the current number as the new 'prev', and the calculated 'next' as the new 'current'
        displayFibonacci(current, next, maxVal);
    }
}
