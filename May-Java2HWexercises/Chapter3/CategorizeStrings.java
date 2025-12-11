package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class CategorizeStrings {
    public static void main(String[] args) {
        final int MAX_STRINGS = 20;
        final String TERMINATING_VALUE = "quit";
        
        // Use basic ArrayLists for storage
        ArrayList<String> shortStrings = new ArrayList<>();
        ArrayList<String> longStrings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("--- String Entry ---");
        System.out.println("Enter up to " + MAX_STRINGS + " strings. Type '" + TERMINATING_VALUE + "' to stop.");

        // Basic while loop for data entry
        while (count < MAX_STRINGS) {
            System.out.print("Enter string #" + (count + 1) + ": ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(TERMINATING_VALUE)) {
                break;
            }

            // Basic if/else for categorization
            if (input.length() <= 10) {
                shortStrings.add(input);
            } else { // length >= 11
                longStrings.add(input);
            }
            count++;
        }

        System.out.println("\n--- Display Selection ---");
        String choice;
        
        // Basic do-while loop for continuous output
        do {
            System.out.print("Enter list type to display ('short', 'long', or '" + TERMINATING_VALUE + "' to exit): ");
            choice = scanner.nextLine().toLowerCase();

            if (choice.equals(TERMINATING_VALUE)) {
                System.out.println("Exiting application. Goodbye.");
                break;
            }

            // Basic if/else for list selection
            if (choice.equals("short")) {
                displayList("Short Strings (10 chars or less)", shortStrings);
            } else { // Assumption: If not "short", assume "long"
                displayList("Long Strings (11 chars or more)", longStrings);
            }
        } while (true);
        
        scanner.close();
    }

    // Helper method using a basic for-each loop
    private static void displayList(String listName, ArrayList<String> list) {
        System.out.println("\n*** " + listName + " ***");
        if (list.isEmpty()) {
            System.out.println("This list is currently empty.");
        } else {
            for (String s : list) { // Basic for-each loop
                System.out.println(s);
            }
        }
        System.out.println("-------------------------------------");
    }
}
