import java.util.ArrayList;
import java.util.Scanner;
public class CategorizeStrings2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<String> noSpace = new ArrayList<>();
        ArrayList<String> oneSpace = new ArrayList<>();
        ArrayList<String> manySpaces = new ArrayList<>();
        System.out.println("Enter up to 20 strings (type 'quit' to stop):");
        int count = 0;
        while (count < 20) 
        {
            System.out.print("Enter string #" + (count + 1) + ": ");
            String text = input.nextLine();
            if (text.equalsIgnoreCase("quit")) break;
            int spaceCount = countSpaces(text);
            if (spaceCount == 0)
                noSpace.add(text);
            else if (spaceCount == 1)
                oneSpace.add(text);
            else
                manySpaces.add(text);
            count++;
        }
        while (true) {
            System.out.print("Which type to display? (none/one/many or 'quit' to exit): ");
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("quit")) break;
            switch (choice.toLowerCase()) 
            {
                case "none":
                    if (noSpace.isEmpty())
                        System.out.println("No strings without spaces.");
                    else
                        System.out.println("Strings with no spaces: " + noSpace);
                    break;
                case "one":
                    if (oneSpace.isEmpty())
                        System.out.println("No strings with one space.");
                    else
                        System.out.println("Strings with one space: " + oneSpace);
                    break;
                case "many":
                    if (manySpaces.isEmpty())
                        System.out.println("No strings with multiple spaces.");
                    else
                        System.out.println("Strings with multiple spaces: " + manySpaces);
                    break;
                default:
                    System.out.println("All Strings: ");
                    System.out.println(noSpace);
                    System.out.println(oneSpace);
                    System.out.println(manySpaces);
                    break;
            }
        }
    }
    public static int countSpaces(String s) 
    {
        int count = 0;
        for (char c : s.toCharArray()) 
        {
            if (c == ' ') count++;
        }
        return count;
    }
}