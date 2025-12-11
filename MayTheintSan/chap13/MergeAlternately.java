import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeAlternately {

    //Ex5: Merges two lists of the same type by alternating their elements.
    //<T> The type of the elements in the lists.
    //list1 The first list.
    //list2 The second list.
    //return A new List with the elements of list1 and list2 merged alternately.
     
    public static <T> List<T> mergeAlternately(List<T> list1, List<T> list2) {
        List<T> mergedList = new ArrayList<>();
        int i = 0; // Iterator for both lists

        // Determine the maximum length to ensure we process all elements.
        int maxLength = Math.max(list1.size(), list2.size());

        while (i < maxLength) {
            // Add element from list1 if the index is valid
            if (i < list1.size()) {
                mergedList.add(list1.get(i));
            }

            // Add element from list2 if the index is valid
            if (i < list2.size()) {
                mergedList.add(list2.get(i));
            }

            i++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        // Lists of equal length
        List<String> listA = Arrays.asList("Red", "Green", "Blue");
        List<String> listB = Arrays.asList("One", "Two", "Three");
        List<String> merged1 = mergeAlternately(listA, listB);
        
        // Expected: [Red, One, Green, Two, Blue, Three]
        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);
        System.out.println("Merged (Equal Length): " + merged1);

        // Lists of different length (List C is longer)
        List<Integer> listC = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> listD = Arrays.asList(2, 4);
        List<Integer> merged2 = mergeAlternately(listC, listD);

        // Expected: [1, 2, 3, 4, 5, 7, 9]
        System.out.println("\nList C: " + listC);
        System.out.println("List D: " + listD);
        System.out.println("Merged (C Longer): " + merged2);
    }
}
