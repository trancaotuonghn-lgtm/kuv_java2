import java.util.ArrayList;
import java.util.Scanner;

public class CommaPlacement {
    public static void main(String[] args) {
        
        ArrayList<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final String SENTINEL = "quit";
        String input;

        System.out.println("Comma Placement Program");
        System.out.println("Enter strings to add to the list.");
        System.out.println("Enter '" + SENTINEL + "' to stop and display the list.");

        // Continually prompt the user for Strings
        do {
            System.out.print("Enter string: ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase(SENTINEL)) {
                wordList.add(input);
            }

        } while (!input.equalsIgnoreCase(SENTINEL));

        // Display the Strings in a single line separated by commas and ending with a period.
        System.out.print("\nList Content: ");
        
        // Check if the list is empty before attempting to display
        if (wordList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            // Loop through the list
            for (int i = 0; i < wordList.size(); i++) {
                System.out.print(wordList.get(i));

                // If it's NOT the last element, print a comma and a space.
                if (i < wordList.size() - 1) {
                    System.out.print(", ");
                } else {
                    // If it IS the last element, print the period.
                    System.out.println(".");
                }
            }
        }
        
        scanner.close();
    }
}
