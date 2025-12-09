// ****************************************************************
// CountLetters.java
//
// Reads a words from the standard input and prints the number of
// occurrences of each letter in that word.
//
// ****************************************************************

import java.util.Scanner;

public class Countletters
{
    public static void main(String[] args)
    {
        int[] counts = new int[26];
        Scanner scan = new Scanner(System.in);
        
        //get word from user
        System.out.print("Enter a word or phrase: "); 
        String word = scan.nextLine();
        
        //convert to all upper case
        word = word.toUpperCase();
        
        //count frequency of each letter in string
        for (int i=0; i < word.length(); i++)
        {
            // Exception Handling 
            
            // put the code that might cause the ArrayIndexOutOfBoundsException in a try block.
            try 
            {
                // This line causes the exception if word.charAt(i) is not between 'A' and 'Z'.
                counts[word.charAt(i)-'A']++; 
            }
            // The exception handler for ArrayIndexOutOfBoundsException.
            catch (ArrayIndexOutOfBoundsException e)
            {
                // Print a useful message, replacing the exception with the character itself.
                char nonLetter = word.charAt(i);
                System.out.println("Not a letter: '" + nonLetter + "' was ignored.");
                // this catch block would have been empty, catch (ArrayIndexOutOfBoundsException e) { }
            }
        }
        
        //print frequencies
        System.out.println();
        System.out.println("Letter Frequencies");
        for (int i=0; i < counts.length; i++)
        {
            if (counts [i] != 0)
            {
                // Cast the index back to a character ('A' + 0 = 'A', 'A' + 1 = 'B', etc.)
                System.out.println((char)(i +'A') + ": " + counts[i]);
            }
        }
        
        scan.close();
    }
}
