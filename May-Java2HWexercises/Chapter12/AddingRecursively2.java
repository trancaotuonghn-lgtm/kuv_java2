//chapter12-ex1b
import java.util.Scanner;
import java.lang.Math; // for Math.min() and Math.max()

public class AddingRecursively2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.println("Recursive Sum Calculator (Any Order)");
        
        System.out.print("Enter the first integer: ");
        num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        num2 = scanner.nextInt();

        // Determine low and high values
        int lowNum = Math.min(num1, num2);
        int highNum = Math.max(num1, num2);

        // Call recursive method
        int sum = calculateSum(lowNum, highNum);

        // Display result
        System.out.printf("\nThe sum of integers between %d and %d (inclusive) is: %d%n", lowNum, highNum, sum);
        
        scanner.close();
    }

    public static int calculateSum(int currentNum, int high) {
        // When the current number exceeds the high value
        if (currentNum > high) {
            return 0;
        } 
        // Add the current number and proceed to the next one
        else {
            return currentNum + calculateSum(currentNum + 1, high);
        }
    }
}
