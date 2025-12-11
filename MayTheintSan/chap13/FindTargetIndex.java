import java.util.Arrays;
import java.util.List;

public class FindTargetIndex {

    //Ex3: Finds the index of the first occurrence of a target element in a list.
    // <T> The type of the elements in the list.
    //list The list to search within
    //target The element to find
    //return The index of the first occurrence, or -1 if not found.
     
    public static <T> int findFirstOccurrence(List<T> list, T target) {
        // Iterate through the list by index.
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);

            // Use equals() for object comparison. 
            // Handles null check safely.
            if (target == null) {
                if (element == null) return i;
            } else if (target.equals(element)) {
                return i;
            }
        }
        
        // Target not found after checking the whole list.
        return -1;
    }

    public static void main(String[] args) {
        // Search in a String list
        List<String> planets = Arrays.asList("Earth", "Mars", "Jupiter", "Mars");
        String target1 = "Jupiter";
        String target2 = "Saturn";
        
        System.out.println("List: " + planets);
        System.out.println("Index of '" + target1 + "': " + findFirstOccurrence(planets, target1)); // Expected: 2
        System.out.println("Index of '" + target2 + "': " + findFirstOccurrence(planets, target2)); // Expected: -1

        // Search in an Integer list
        List<Integer> codes = Arrays.asList(99, 101, 404, 500);
        Integer target3 = 404;

        System.out.println("\nList: " + codes);
        System.out.println("Index of " + target3 + ": " + findFirstOccurrence(codes, target3)); // Expected: 2
    }
}
