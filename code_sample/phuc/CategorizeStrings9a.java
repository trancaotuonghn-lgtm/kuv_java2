import java.util.ArrayList;
import java.util.Scanner;
public class CategorizeStrings 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<String> shortStrings = new ArrayList<>();
        ArrayList<String> longStrings = new ArrayList<>();
        System.out.println("Enter up to 20 strings (type 'quit' to stop):");
        int count = 0;
        while (count < 20) 
        {
            System.out.print("Enter string #" + (count + 1) + ": ");
            String text = input.nextLine();
            if (text.equalsIgnoreCase("quit")) break;
            if (text.length() <= 10)
                shortStrings.add(text);
            else
                longStrings.add(text);
            count++;
        }
        while (true) {
            System.out.print("Which list to display? (short/long or 'quit' to exit): ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("quit")) break;
            if (choice.equalsIgnoreCase("short")) 
            {
                if (shortStrings.isEmpty())
                    System.out.println("No short strings to display.");
                else
                    System.out.println("Short Strings: " + shortStrings);
            } 
            else {
                if (longStrings.isEmpty())
                    System.out.println("No long strings to display.");
                else
                    System.out.println("Long Strings: " + longStrings);
            }
        }
    }
}
