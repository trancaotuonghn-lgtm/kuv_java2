//Chapter12-part2-ex2

public class reverseString{
public static String reverseString(String str) {
    // Base Case: A string of length 0 or 1 is its own reverse
     if (str == null || str.length() <= 1) {
         return str;
      }
        
     // Move the first character to the end of the reversed result of the rest of the string
     String restOfString = str.substring(1);
     char firstChar = str.charAt(0);
        
     return reverseString(restOfString) + firstChar;
}
}
// System.out.println("Reverse of 'abcd': " + reverseString("abcd")); // Output: dcba
