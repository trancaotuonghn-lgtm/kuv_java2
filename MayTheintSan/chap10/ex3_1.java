// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
// Throws IllegalArgumentException for invalid input (n < 0 or n > 16).
//
// ****************************************************************
public class MathUtils 
{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    // Throws IllegalArgumentException if n is negative or too large (n > 16).
    //-------------------------------------------------------------
    public static int factorial(int n) // throws IllegalArgumentException (Optional in header since it's unchecked)
    {
        // Check for invalid arguments (n < 0 or n > 16)
        if (n < 0) {
            // Throw an IllegalArgumentException for negative numbers
            throw new IllegalArgumentException("Factorial is not defined for negative integers: n = " + n);
        }
        if (n > 16) {
            // Throw an IllegalArgumentException for overflow risk (since int max factorial is 16!)
            throw new IllegalArgumentException("Factorial for " + n + " will cause integer overflow. Max allowed is 16.");
        }
        
        // Standard factorial calculation for valid arguments (0 <= n <= 16)
        int fac = 1;
        for (int i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}
