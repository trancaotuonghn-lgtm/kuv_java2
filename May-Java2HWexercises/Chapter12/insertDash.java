//chapter12-part2-ex9
public class insertDash {
    public static String insertDash(String str) {
        // string of length 0 or 1 is returned as is (no dash needed).
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // append the first character, a dash, and the result of the rest of the string.
        return firstChar + "-" + insertDash(str.substring(1));
    }

// System.out.println("Dashed 'CAT': " + insertDash("CAT")); // Output: C-A-T
}
