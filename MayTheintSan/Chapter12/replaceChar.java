//chapter12-part2-ex5
public class replaceChar {
    public static String replaceChar(String str, char original, char replacement) {
        // Empty string returns itself
        if (str == null || str.isEmpty()) {
            return "";
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // Determine the character to keep/use in the result
        char charToUse = (firstChar == original) ? replacement : firstChar;
        
        //Append the determined character and call the method on the rest of the string
        return charToUse + replaceChar(str.substring(1), original, replacement);
    }

// System.out.println("Replace 'p' in 'apple' with 'x': " + replaceChar("apple", 'p', 'x')); // Output: axxle
}
