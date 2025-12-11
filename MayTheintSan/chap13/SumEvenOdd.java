import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SumEvenOdd {

    //Ex2: Calculates the sum of all even and odd numbers in a list of numbers
 
    public static List<Double> sumEvenOdd(List<? extends Number> list) {
        double evenSum = 0;
        double oddSum = 0;

        for (Number number : list) {
            // Convert to long to safely check the whole number part for even/odd.
            long intValue = number.longValue();

            if (intValue % 2 == 0) {
                evenSum += number.doubleValue(); // Add the actual value (e.g., 2.5, 4.0) to the sum
            } else {
                oddSum += number.doubleValue();
            }
        }

        // Return the results in a new list.
        List<Double> result = new ArrayList<>();
        result.add(evenSum); 
        result.add(oddSum);  
        return result;
    }

    public static void main(String[] args) {
        // Test with Integers
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> intSums = sumEvenOdd(intList);
        // Expected Even Sum: 2 + 4 = 6.0
        // Expected Odd Sum: 1 + 3 + 5 = 9.0
        System.out.println("List: " + intList);
        System.out.println("Even Sum: " + intSums.get(0));
        System.out.println("Odd Sum: " + intSums.get(1));

        // Test with Doubles (checking the whole number part for even/odd)
        List<Double> doubleList = Arrays.asList(10.5, 12.0, 13.1);
        List<Double> doubleSums = sumEvenOdd(doubleList);
        // 10.5 (10 is Even) -> Even Sum += 10.5
        // 12.0 (12 is Even) -> Even Sum += 12.0
        // 13.1 (13 is Odd) -> Odd Sum += 13.1
        System.out.println("\nList: " + doubleList);
        System.out.println("Even Sum: " + doubleSums.get(0)); // Expected: 22.5
        System.out.println("Odd Sum: " + doubleSums.get(1));  // Expected: 13.1
    }
}
