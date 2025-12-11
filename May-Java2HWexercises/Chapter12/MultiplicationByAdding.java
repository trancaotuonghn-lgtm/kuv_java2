//chapter12-ex2
import java.util.Scanner;

public class MultiplicationByAdding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int factor1, factor2;

        System.out.println("Recursive Multiplication (using Addition)");
        
        System.out.print("Enter the first integer (Factor 1): ");
        factor1 = scanner.nextInt();
        
        System.out.print("Enter the second integer (Factor 2): ");
        factor2 = scanner.nextInt();

        // for negative numbers (by multiplying the absolute values and adjusting the sign later)
        int absFactor1 = Math.abs(factor1);
        int absFactor2 = Math.abs(factor2);
        
        int product = multiply(absFactor1, absFactor2);
        
        // Adjust sign if one factor is negative
        if ((factor1 < 0 && factor2 >= 0) || (factor1 >= 0 && factor2 < 0)) {
            product = -product;
        }

        System.out.printf("\nThe product of %d and %d is: %d%n", factor1, factor2, product);
        
        scanner.close();
    }

    public static int multiply(int num1, int num2) {
        // If num2 is 0, the product is 0.
        if (num2 == 0) {
            return 0;
        } 
        // If num2 is 1, the product is num1.
        else if (num2 == 1) {
            return num1;
        }
        // Add num1 to the result of multiplying num1 by (num2 - 1).
        else {
            return num1 + multiply(num1, num2 - 1);
        }
    }
}
