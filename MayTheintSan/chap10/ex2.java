// ****************************************************************
// ParseInts.java
//
// Reads a line of text and prints the integers in the line.
// The program now handles non-integer tokens using a try-catch block 
// placed inside the loop to ensure the entire line is processed.
//
// ****************************************************************
import java.util.Scanner;

public class ParseInts
{
    public static void main(String[] args)
    {
        int val, sum = 0;
        
        // Scanner to read the entire line from the user
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter a line of text");
        String line = scan.nextLine();
        
        // Scanner to read tokens (words/numbers) from the input line
        Scanner scanLine = new Scanner(line);
        
        // Loop through all tokens on the line
        while (scanLine.hasNext())
        {
            // Exception Handler is inside the loop 
            // This ensures that when a NumberFormatException occurs,
            // the catch block handles it, and the loop proceeds to the next token.
            try 
            {
                // Get the next token (word/number)
                String token = scanLine.next();
                
                // Try to convert the token to an integer
                val = Integer.parseInt(token); 
                
                // Only if parsing is successful, the sum is updated
                sum += val;
            } 
            catch (NumberFormatException e) 
            {
                // Empty catch body= Do nothing, just skip the non-integer token.
                // The loop automatically continues to the next iteration.
            }
        }
        
        System.out.println("The sum of the integers on this line is " + sum);
        
        scan.close();
        scanLine.close();
    }
}
