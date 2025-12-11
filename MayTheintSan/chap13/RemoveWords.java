import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveWords {

    // Helper method to display the list using an Iterator
    public static void displayListWithIterator(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("\n[The list is currently EMPTY.]");
            return;
        }

        System.out.print("\nCurrent List: ");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final String SENTINEL = "done";
        String input;

        System.out.println("--- Word List Builder ---");
        System.out.println("Enter words (or '" + SENTINEL + "' to finish adding):");
        
        // Populate the list
        do {
            System.out.print("Add word: ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase(SENTINEL)) {
                wordList.add(input);
            }
        } while (!input.equalsIgnoreCase(SENTINEL));

        // Display the initial list using the iterator
        displayListWithIterator(wordList);

        System.out.println("\n--- Word Elimination ---");
        System.out.println("Enter a word to eliminate (or '" + SENTINEL + "' to stop eliminating):");

        // Continually ask for a String to eliminate
        do {
            if (wordList.isEmpty()) {
                // If the list is empty, display message and break the loop.
                System.out.println("\n*** ERROR: The list is now EMPTY. Cannot eliminate any more words. Ending program. ***");
                break;
            }

            System.out.print("Eliminate word: ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase(SENTINEL)) {
                // Check if the word exists and remove it
                if (wordList.remove(input)) {
                    System.out.println("Removed '" + input + "'.");
                } else {
                    System.out.println("'" + input + "' was not found in the list.");
                }
                
                // Display the new list after each attempt to eliminate
                displayListWithIterator(wordList);
            }

        } while (!input.equalsIgnoreCase(SENTINEL));

        scanner.close();
    }
}
