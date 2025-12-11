import java.util.ArrayList;
import java.util.Scanner;

public class RemoveNumber {
    public static void main(String[] args) {
        // Create an Integer ArrayList and store at least four integers
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(25);
        numberList.add(40);
        numberList.add(15);

        System.out.println("Initial List");
        
        //display all the numbers
        display(numberList);

        // Prompt the user for a value to remove
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a value to remove from the list: ");
        
        // Handle non-integer input
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.close();
            return;
        }
        
        int valueToRemove = scanner.nextInt();

        // Remove the first occurrence of the number if it appears in the list
        
        // The ArrayList's remove method returns true if the element was found and removed.
        boolean wasRemoved = numberList.remove(Integer.valueOf(valueToRemove));

        System.out.println("\nList After Removal Attempt");
        
        // Display the removal result and the list again
        if (wasRemoved) {
            System.out.println("Success! The value " + valueToRemove + " was removed from the list.");
        } else {
            System.out.println("Failure! The value " + valueToRemove + " was NOT found in the list.");
        }

        display(numberList);

        scanner.close();
    }
    
    // Helper method to display the list using an iterator
    public static void display(ArrayList<Integer> numberList) {
        System.out.print(numberList);
        
    }
}
