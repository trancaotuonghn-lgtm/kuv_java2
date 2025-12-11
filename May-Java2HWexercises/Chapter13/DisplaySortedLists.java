import java.util.*;


public class DisplaySortedLists {

    // Generic display method that can accept and display a List of ANY type.
    public static <T> void display(List<T> list, String listName) {
        System.out.println("\nSorted List: " + listName );
        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> integerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        final String SENTINEL = "quit";
        String input;

        //Handle Strings 
        System.out.println("Word List Builder");
        System.out.println("Enter words (or '" + SENTINEL + "' to move to numbers):");

        do {
            System.out.print("Enter word: ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase(SENTINEL)) {
                stringList.add(input);
                // Sort the list after adding
                Collections.sort(stringList); 
                // Pass the list to the display method
                display(stringList, "Words");
            }

        } while (!input.equalsIgnoreCase(SENTINEL));

        //Handle Integers 
        System.out.println("Integer List Builder");
        System.out.println("Enter integers (or '" + SENTINEL + "' to exit):");
        
        do {
            System.out.print("Enter integer: ");
            input = scanner.nextLine();

            if (!input.equalsIgnoreCase(SENTINEL)) {
                try {
                    // Convert the input to an Integer
                    int num = Integer.parseInt(input);
                    integerList.add(num);
                    
                    // Sort the list after adding
                    Collections.sort(integerList);
                    // Pass the list to the display method
                    display(integerList, "Numbers");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer or '" + SENTINEL + "'.");
                }
            }

        } while (!input.equalsIgnoreCase(SENTINEL));

        scanner.close();
        System.out.println("\nProgram finished.");
    }
}
