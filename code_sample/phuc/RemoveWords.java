package chap13;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class RemoveWords 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        String input;
        System.out.println("Enter words (type 'end' to stop):");
        while (true) 
        {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("end"))
                break;
            words.add(input);
        }
        System.out.println("\nCurrent list:");
        display(words);
        System.out.println("\nEnter words to remove (type 'end' to stop):");
        while (true) 
        {
            if (words.isEmpty()) 
            {
                System.out.println("The list is empty. Cannot remove more words.");
                break;
            }
            input = sc.nextLine();
            if (input.equalsIgnoreCase("end"))
                break;
            if (words.contains(input)) 
            {
                words.remove(input);
                System.out.println("Updated list:");
                display(words);
            } 
            else {
                System.out.println("Word not found.");
            }
        }
    }
    public static void display(ArrayList<String> list) 
    {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}