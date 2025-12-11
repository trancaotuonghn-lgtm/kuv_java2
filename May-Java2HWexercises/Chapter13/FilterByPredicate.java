import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterByPredicate {

    //Ex6: Filters a list based on a given condition (Predicate).
    // <T> The type of the elements in the list.
    //list The list to filter.
    //predicate The condition (a function that returns true/false) to test elements against.
    //return A new ArrayList containing only elements that satisfy the predicate.
     
    public static <T> ArrayList<T> filterList(List<T> list, Predicate<T> predicate) {
        ArrayList<T> resultList = new ArrayList<>();

        for (T element : list) {
            // predicate.test(element) returns true if the element meets the condition.
            if (predicate.test(element)) {
                resultList.add(element);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        // Filter a List of Strings
        List<String> words = Arrays.asList("sun", "moon", "star", "cloud");
        
        // Keep words that have 4 or more letters.
        Predicate<String> lengthFilter = word -> word.length() >= 4;
        
        ArrayList<String> filteredWords = filterList(words, lengthFilter);
        
        // Expected: [moon, star, cloud]
        System.out.println("Original Words: " + words);
        System.out.println("Filtered (length >= 4): " + filteredWords);

        // Filter a List of Integers
        List<Integer> scores = Arrays.asList(55, 80, 75, 92, 60);
        
        //Keep scores that are 70 or higher.
        Predicate<Integer> passingScore = score -> score >= 70;
        
        ArrayList<Integer> passingScores = filterList(scores, passingScore);
        // Expected: [80, 75, 92]
        System.out.println("\nOriginal Scores: " + scores);
        System.out.println("Filtered (Score >= 70): " + passingScores);
    }
}
