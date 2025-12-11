//chapter12-part2-ex8
public class countUppercase {

    public static int countUppercase(String str) {
        // empty string has 0 uppercase letters
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // Determine the contribution (1 if uppercase, 0 otherwise)
        int contribution = Character.isUpperCase(firstChar) ? 1 : 0;
        
        // add the contribution to the count of the rest of the string.
        return contribution + countUppercase(str.substring(1));
    }

// System.out.println("Uppercase in 'HelloWorld': " + countUppercase("HelloWorld")); // Output: 2
}
