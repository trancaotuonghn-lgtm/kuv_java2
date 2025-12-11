//chapter12-part2-ex3
public class countChar {
    public static int countChar(String str, char ch) {
        //Empty string has 0 occurrences
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // Determine the contribution (1 if it matches the target char, 0 otherwise)
        int contribution = (firstChar == ch) ? 1 : 0;
        
        //Add the contribution to the count of the rest of the string
        return contribution + countChar(str.substring(1), ch);
    }
}

//System.out.println("Count of 'a' in 'banana': " + countChar("banana", 'a')); // Output: 3

