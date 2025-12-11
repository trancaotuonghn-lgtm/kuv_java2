//Chapter12-ex3
import java.util.Scanner;

public class SumRangeRecursively {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create an array of at least 20 integers
        int[] dataArray = {
            5, 12, 4, 1, 8, 15, 3, 9, 2, 6,
            10, 7, 14, 11, 13, 0, 19, 16, 17, 18, 20
        };
        final int MAX_SUB = dataArray.length - 1;
        
        System.out.println("--- Recursive Array Sum Range ---");
        System.out.println("Array size: " + dataArray.length + " (Indices 0 to " + MAX_SUB + ")");

        int startPos, endPos;

        // Prompt for starting position with validation
        do {
            System.out.printf("Enter starting position (0 to %d): ", MAX_SUB);
            startPos = scanner.nextInt();
            if (startPos < 0 || startPos > MAX_SUB) {
                System.out.println("Error: Invalid starting position. Must be between 0 and " + MAX_SUB + ".");
            }
        } while (startPos < 0 || startPos > MAX_SUB);

        // Prompt for ending position with validation
        do {
            System.out.printf("Enter ending position (%d to %d): ", startPos, MAX_SUB);
            endPos = scanner.nextInt();
            if (endPos < startPos || endPos > MAX_SUB) {
                System.out.printf("Error: Invalid ending position. Must be between %d and %d.%n", startPos, MAX_SUB);
            }
        } while (endPos < startPos || endPos > MAX_SUB);
        
        //Display all the values in the requested range
        System.out.print("\nValues in the range: ");
        for (int i = startPos; i <= endPos; i++) {
            System.out.print(dataArray[i] + (i == endPos ? "" : ", "));
        }
        System.out.println();

        //Call recursive method
        long sum = sumRange(dataArray, startPos, endPos);

        // Display result
        System.out.printf("The recursive sum of values from index %d to %d is: %d%n", startPos, endPos, sum);
        
        scanner.close();
    }

    public static long sumRange(int[] arr, int start, int end) {
        //When the start index has exceeded the end index, there's nothing left to add.
        if (start > end) {
            return 0;
        } 
        //Add the value at the current start index and call the method for the next index.
        else {
            return arr[start] + sumRange(arr, start + 1, end);
        }
    }
}
