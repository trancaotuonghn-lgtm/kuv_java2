package chap13_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveWords {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String sentinel = "QUIT";

        System.out.println("Enter words to add (type 'QUIT' to stop adding):");
        while (true) {
            String entry = input.nextLine();
            if (entry.equalsIgnoreCase(sentinel)) {
                break;
            }
            words.add(entry);
        }

        System.out.println("\nCurrent List:");
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nNow enter words to remove (type 'QUIT' to stop):");
        while (true) {
            if (words.isEmpty()) {
                System.out.println("The list is now empty. Ending program.");
                break;
            }

            System.out.print("Enter word to remove: ");
            String toRemove = input.nextLine();

            if (toRemove.equalsIgnoreCase(sentinel)) {
                break;
            }

            if (words.remove(toRemove)) {
                System.out.println("Removed. New list: " + words);
            } else {
                System.out.println("Word not found.");
                System.out.println("Current list: " + words);
            }
        }
    }
}