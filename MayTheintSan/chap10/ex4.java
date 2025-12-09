import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CopyFile {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        // This Scanner will read from the file once it's successfully opened.
        Scanner fileScanner = null; 
        
        // Flag to control the loop= true if the file was NOT successfully opened.
        boolean fileNotFound = true; 

        // Loop to handle file existence 
        // The loop continues AS LONG AS a FileNotFoundException was caught (fileNotFound is true).
        do {
            System.out.print("Enter the name of the file to copy: ");
            String fileName = keyboard.nextLine();
            
            // The try block attempts the action that might throw the exception.
            try {
                // Create a File object from the user input.
                File inputFile = new File(fileName);
                
                // Attempt to create a Scanner from the File.
                // This constructor THROWS FileNotFoundException if the file doesn't exist.
                fileScanner = new Scanner(inputFile);
                
                // If the code reaches here, the file was opened successfully.
                fileNotFound = false; 
            } 
            // The catch block executes ONLY if the FileNotFoundException is thrown.
            catch (FileNotFoundException e) {
                // The exception tells us the file was NOT found.
                System.out.println("Error: File '" + fileName + "' not found. Please try again.");
                // Since the exception was caught, fileNotFound remains true, causing the loop to repeat.
            }
            
        } while (fileNotFound); // Loop condition
        
        // Copy the File to Standard Output 
        
        System.out.println("\nStarting File Copy\n");
        
        // Check if fileScanner is not null (guaranteed by the loop structure, 
        // but a good safeguard if the file is empty).
        if (fileScanner != null) {
            // Read and print each line until there are no more lines.
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            
            // Close the file scanner to release the resource.
            fileScanner.close();
        }
        
        System.out.println("\nFile Copy Complete");
        keyboard.close();
    }
}
