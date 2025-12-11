package ex;
import java.util.Scanner;

public class PigLatin {

    private static final String VOWELS = "aeiou";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a single word (all lowercase): ");
        String originalWord = scanner.next();
        
        String pigLatinWord = convertToPigLatin(originalWord);
        
        System.out.println("Original Word: " + originalWord);
        System.out.println("Pig Latin: " + pigLatinWord);
        
        scanner.close();
    }

    public static String convertToPigLatin(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        char firstChar = word.charAt(0);

        // Check if the word starts with a true vowel (a, e, i, o, u)
        if (VOWELS.indexOf(firstChar) != -1) {
            // Starts with a vowel -> append "ay"
            return word + "ay";
        } else {
            //Starts with a consonant (or 'y')
            int firstVowelIndex = -1;
            
            // Basic for loop to find the end of the initial consonant cluster
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                
                // Check for a, e, i, o, u (using VOWELS string) 
                // OR 'y' that is NOT the first character
                if (VOWELS.indexOf(c) != -1 || (c == 'y' && i > 0)) {
                    firstVowelIndex = i;
                    break;
                }
            }

            if (firstVowelIndex == -1) {
                // Word contains no vowels (e.g., "shh", "rhythm")
                return word + "ay"; 
            } else {
                // Move initial consonants to the end
                String initialConsonants = word.substring(0, firstVowelIndex);
                String restOfWord = word.substring(firstVowelIndex);
                return restOfWord + initialConsonants + "ay";
            }
        }
    }
}
