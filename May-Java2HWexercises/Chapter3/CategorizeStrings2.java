package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class CategorizeStrings2 {
    public static void main(String[] args) {
        final int MAX_STRINGS = 20;
        final String TERMINATING_VALUE = "quit";
        
        // Basic ArrayLists for storage
        ArrayList<String> noSpaceStrings = new ArrayList<>();
        ArrayList<String> oneSpaceStrings = new ArrayList<>();
        ArrayList<String> moreThanOneSpaceStrings = new ArrayList<>();
        ArrayList<String> allStrings = new ArrayList<>(); 
        
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println("--- String Entry ---");
        System.out.println("Enter up to " + MAX_STRINGS + " strings. Type '" + TERMINATING_VALUE + "' to stop.");

        // Data Entry Loop
        while (count < MAX_STRINGS) {
            System.out.print("Enter string #" + (count + 1) + ": ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase(TERMINATING_VALUE)) {
                break;
            }
            
            allStrings.add(input);
            
            // Basic for loop to count spaces
            int spaceCount = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == ' ') {
                    spaceCount++;
                }
            }

            // Basic if/else if/else for categorization
            if (spaceCount == 0) {
                noSpaceStrings.add(input);
            } else if (spaceCount == 1) {
                oneSpaceStrings.add(input);
            } else { // spaceCount > 1
                moreThanOneSpaceStrings.add(input);
            }
            count++;
        }

        System.out.println("\n--- Display Selection ---");
        String choice;
        
        // Output Loop (basic do-while)
        do {
            System.out.print("Enter list type to display ('zero', 'one', 'more', or '" + TERMINATING_VALUE + "' to exit): ");
            choice = scanner.nextLine().toLowerCase();

            if (choice.equals(TERMINATING_VALUE)) {
                System.out.println("Exiting application. Goodbye.");
                break;
            }

            // Basic switch statement for selection
            switch (choice) {
                case "zero":
                    displayList("Strings with ZERO spaces", noSpaceStrings);
                    break;
                case "one":
                    displayList("Strings with ONE space", oneSpaceStrings);
                    break;
                case "more":
                    displayList("Strings with MORE THAN ONE space", moreThanOneSpaceStrings);
                    break;
                default: // Display all if choice is invalid
                    displayList("ALL Strings (Invalid choice entered)", allStrings);
                    break;
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
            for (String s : list) {
                System.out.println(s);
            }
        }
        System.out.println("-------------------------------------");
    }
}
