//chapter12-part2-ex7
public class sumDigits {
    public static int sumDigits(String str) {
        // empty string, the sum is 0.
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        // Take the first character (which is a digit)
        char firstChar = str.charAt(0);
        
        // Convert the character digit to its integer value
        int digitValue = Character.getNumericValue(firstChar); 
        
        // add the value of the first digit to the sum of the rest of the string.
        return digitValue + sumDigits(str.substring(1));
    }

// System.out.println("Sum of digits in '2025': " + sumDigits("2025")); // Output: 9
}
