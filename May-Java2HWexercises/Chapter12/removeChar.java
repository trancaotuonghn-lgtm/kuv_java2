//chapter12-part2-ex4
public class removeChar {
    public static String removeChar(String str, char ch) {
        //Empty string returns itself.
        if (str == null || str.isEmpty()) {
            return "";
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // Recursive Case: 
        if (firstChar == ch) {
            // If it matches, don't include it; just call the method on the rest of the string.
            return removeChar(str.substring(1), ch);
        } else {
            // If it doesn't match, include it and append the result of the rest of the string.
            return firstChar + removeChar(str.substring(1), ch);
        }
    }

// System.out.println("Remove 'a' from 'banana': " + removeChar("banana", 'a')); // Output: bnn
}
