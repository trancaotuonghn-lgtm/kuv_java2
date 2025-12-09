// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*; // Import all java.io classes

public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs;          // number of semester hours earned
        double qualityPts;      // number of quality points earned
        double gpa;             // grade point (quality point) average
        
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        
        // Declare the file streams outside the try block so they are in scope 
        // for the finally block (not used here) and can be checked after the loop.
        Scanner scan = null; 
        PrintWriter outFile = null; 

        try
        {
            // Set up scanner to input file and PrintWriter to output file
            scan = new Scanner(new File(inputName));
            // Create the PrintWriter from a FileWriter in a single statement
            outFile = new PrintWriter(new FileWriter(outputName)); 

            // Print a header to the output file
            outFile.println();
            outFile.println("Students on Academic Warning");
            outFile.println("----------------------------");
            outFile.println("Name\tHours\tGPA");
            outFile.println();

            // Process the input file, one token (three items) at a time
            while (scan.hasNext())
            {
                // Read student data in order
                name = scan.next();
                
                // The following lines might throw NumberFormatException if data is corrupted
                creditHrs = scan.nextInt(); 
                qualityPts = scan.nextDouble();

                // Compute the GPA
                gpa = qualityPts / creditHrs;
                
                // Determine if the student is on warning
                boolean onWarning = false;
                
                if (creditHrs < 30) {
                    // Less than 30 hours: GPA < 1.5
                    if (gpa < 1.5) onWarning = true;
                } else if (creditHrs < 60) {
                    // 30 to 59 hours: GPA < 1.75
                    if (gpa < 1.75) onWarning = true;
                } else {
                    // 60+ hours: GPA < 2.0
                    if (gpa < 2.0) onWarning = true;
                }
                
                // If on warning, write the student data to the output file.
                if (onWarning) {
                    outFile.printf("%s\t%d\t%.2f%n", name, creditHrs, gpa);
                }
            } // end while loop

            // Close output file
            outFile.close();
            scan.close(); // Also close input file scanner
            
            System.out.println("Processing complete. Warning list saved to " + outputName);
        }
        
        // Catch the specific exceptions
        
        // Catch 1: Input file does not exist
        catch (FileNotFoundException exception)
        {
            System.out.println("FATAL ERROR: The input file '" + inputName + "' was not found.");
            System.out.println("Please ensure 'students.dat' is in the program directory.");
        }
        
        // Catch 2: Non-IO stream error (e.g., failed write attempt, though less common here)
        catch (IOException exception)
        {
            System.out.println("FATAL ERROR: An unexpected I/O problem occurred (e.g., file writing issue).");
            System.out.println("Details: " + exception.getMessage());
        }
        
        // Catch 3: Error during nextInt() or nextDouble()
        catch (java.util.InputMismatchException e)
        {
             // When scan.nextInt() or scan.nextDouble() fails to read a number, 
             // it throws InputMismatchException (part of java.util). 
             // This indicates an error in the input file format.
             System.out.println("FATAL ERROR: Format error in input file (" + inputName + ").");
             System.out.println("Expected a number but found non-numeric data.");
             System.out.println("Details: " + e.getMessage());
        }
        
        // Catch 4: Division by zero, though unlikely if hours > 0
        catch (ArithmeticException e)
        {
            System.out.println("FATAL ERROR: Attempted division by zero (Credit Hours = 0).");
            System.out.println("Details: " + e.getMessage());
        }
        
        // Ensure files are closed even if an exception was caught (optional but robust)
        finally {
             if (outFile != null) {
                 outFile.close();
             }
        }
    }
}
