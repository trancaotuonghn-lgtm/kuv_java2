// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
// Now includes a try-catch block to handle IllegalArgumentException.
//
// ****************************************************************
import java.util.Scanner;

public class Factorials
{
    public static void main(String[] args)
    {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing.equals("y") || keepGoing.equals("Y"))
        {
            try {
                // Get input within the try block
                System.out.print("Enter an integer: ");
                int val = scan.nextInt();
                
                // Call the method that might throw the exception
                System.out.println("Factorial(" + val + ") = " + MathUtils.factorial(val));
                
            } 
            // Catch the exception thrown by factorial and print a message
            catch (IllegalArgumentException e) {
                // Print a clean error message using the message passed to the exception constructor
                System.out.println("Error: " + e.getMessage());
                
                // Clear the scanner buffer since nextInt() failed 
                // (though in this case, nextInt() succeeds before factorial() is called
            }
            // Catch for invalid non-integer input (e.g., user types "hello")
            catch (java.util.InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter an integer.");
                scan.next(); // Clear the invalid input from the buffer
            }
            
            // Ask whether to continue, ensuring this happens outside the inner try-catch
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
        scan.close();
    }
}
