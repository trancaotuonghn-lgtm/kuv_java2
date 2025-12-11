//chapter12-part2-ex6
public class isPalindrome {
    public static boolean isPalindrome(String str) {
        // Empty string or a string of length 1 is a palindrome
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        // Get the first and last characters
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);

        // if the outer characters don't match, it's not a palindrome
        if (first != last) {
            return false;
        }
        
        //check the inner substring (excluding the first and last characters)
        String innerString = str.substring(1, str.length() - 1);
        return isPalindrome(innerString);
    }

// System.out.println("'racecar' is a palindrome: " + isPalindrome("racecar")); // Output: true
}
