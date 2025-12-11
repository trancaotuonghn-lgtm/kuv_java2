import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseGenericList {

    //Ex4: Creates a new list with the elements of the input list in reverse order.
    //list The list to reverse.
    //return A new List with the elements in reverse order.
  
    public static List<?> reverseList(List<?> list) {
        // Create a new ArrayList by copying the elements from the input list.
        List<Object> reversedList = new ArrayList<>(list);

        // Use the Collections utility class to reverse the elements in the new list.
        Collections.reverse(reversedList);

        return reversedList;
    }

    public static void main(String[] args) {
        // Reverse a List of Characters
        List<Character> chars = Arrays.asList('X', 'Y', 'Z', 'W');
        List<?> reversedChars = reverseList(chars);
        
        // Expected: [W, Z, Y, X]
        System.out.println("Original List: " + chars);
        System.out.println("Reversed List: " + reversedChars);
        
        // Reverse a List of Doubles
        List<Double> prices = Arrays.asList(19.99, 5.0, 42.5);
        List<?> reversedPrices = reverseList(prices);

        // Expected: [42.5, 5.0, 19.99]
        System.out.println("\nOriginal List: " + prices);
        System.out.println("Reversed List: " + reversedPrices);
    }
}
