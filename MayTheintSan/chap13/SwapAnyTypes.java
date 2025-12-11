 //Ex6: Generic method to display, swap, and re-display two values of the same type.
public class SwapAnyTypes {

    // Helper method to display the two values
    public static <T> void displayValues(T val1, T val2, String label) {
        System.out.println("  " + label + ": Value 1 = " + val1 + ", Value 2 = " + val2);
    }
    
    
    public static <T> void swapAndDisplay(T value1, T value2) {
        
        System.out.println("Inside Generic Swap Method for Type: " + value1.getClass().getSimpleName());

        // Display original values
        displayValues(value1, value2, "Before Swap");

        // Swap the values using a temporary variable
        T temp = value1;
        value1 = value2;
        value2 = temp;

        // Display swapped values
        displayValues(value1, value2, "After Swap ");
        System.out.println("\n");
    }

    public static void main(String[] args) {

        String string1 = "Hello";
        String string2 = "World";
        System.out.println("Original Main Variables (Strings): " + string1 + " and " + string2);
        
        // Send the two Strings to the generic method
        swapAndDisplay(string1, string2);

        // string1 and string2 in main() remain unchanged,
        // a copy of the reference
        System.out.println("Main Variables After Method Call (Strings): " + string1 + " and " + string2);

        System.out.println("\n");
        
      
        Integer int1 = 100;
        Integer int2 = 200;
        System.out.println("Original Main Variables (Integers): " + int1 + " and " + int2);
        
        // Send the two Integers to the generic method
        swapAndDisplay(int1, int2);

        System.out.println("Main Variables After Method Call (Integers): " + int1 + " and " + int2);
    }
}
