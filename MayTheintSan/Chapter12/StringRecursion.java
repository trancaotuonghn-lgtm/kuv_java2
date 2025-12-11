//Chapter12-part2-ex1

public class StringRecursion {
    private static final String VOWELS = "aeiouAEIOU";
    public static int countVowels(String str) {
        // empty string has 0 vowels
        if (str == null || str.isEmpty()) {
            return 0;
        }
        
        // Take the first character
        char firstChar = str.charAt(0);
        
        // Determine the contribution of the first character (1 if vowel, 0 if not)
        int contribution = VOWELS.indexOf(firstChar) != -1 ? 1 : 0;
        
        // Add the contribution to the count of the rest of the string
        return contribution + countVowels(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("Vowels in 'hello': " + countVowels("hello"));      // Output: 2
        System.out.println("Vowels in 'banana': " + countVowels("banana"));    // Output: 3
        System.out.println("Vowels in 'Programming': " + countVowels("Programming")); // Output: 4
    }
}
