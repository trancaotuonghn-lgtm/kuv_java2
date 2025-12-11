//Chapter12-ex1a
import java.util.Scanner;

public class AddingRecursively {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowNum, highNum;

        System.out.println("Recursive Sum Calculator");
        
        //first integer
        System.out.print("Enter the first integer (low value): ");
        lowNum = scanner.nextInt();

        // second integer and check is it larger
        do {
            System.out.print("Enter the second integer (must be > first): ");
            highNum = scanner.nextInt();
            if (highNum <= lowNum) {
                System.out.println("Error: The second integer must be larger than the first. Try again.");
            }
        } while (highNum <= lowNum);

        // Call recursive method
        int sum = calculateSum(lowNum, highNum);

        // Display result
        System.out.printf("\nThe sum of integers from %d to %d is: %d%n", lowNum, highNum, sum);
        
        scanner.close();
    }

    public static int calculateSum(int low, int high) {
        //When the current low value exceeds the high value, stop
        if (low > high) {
            return 0;
        } 
        // add the current low value to the sum of the remaining values
        else {
            return low + calculateSum(low + 1, high);
        }
    }
}
