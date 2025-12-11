//Chapter12-ex7

import java.util.Scanner;

public class IndirectRecursionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startValue;

        System.out.println("--- Indirect Recursion Demo ---");
        System.out.print("Enter a positive integer: ");
        startValue = scanner.nextInt();

        // Start the process with the first method
        System.out.println("\nStarting countdown:");
        methodA(startValue);
        
        System.out.println("Countdown finished.");
        scanner.close();
    }

  //MethodA = checks if the number is > 0, displays it and calls Method B
    public static void methodA(int n) {
        if (n > 0) {
            System.out.printf("Method A: %d%n", n);
            // Recursive Call (Indirect): Calls Method B with n-1
            methodB(n - 1);
        }
    }

    // Method B: Checks if the number is > 0. Displays it and calls Method A.
    public static void methodB(int n) {
        if (n > 0) {
            System.out.printf("  Method B: %d%n", n);
            // Recursive Call (Indirect): Calls Method A with n-1
            methodA(n - 1);
        }
        // If n <= 0, both methods stop calling each other.
    }
}
