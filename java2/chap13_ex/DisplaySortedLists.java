package chap13_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplaySortedLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentinel = "QUIT";

        ArrayList<String> stringList = new ArrayList<>();
        System.out.println("--- String List Mode ---");
        while (true) {
            System.out.print("Enter a word (or 'QUIT' to switch to Integers): ");
            String word = input.nextLine();

            if (word.equalsIgnoreCase(sentinel)) {
                break;
            }

            stringList.add(word);
            Collections.sort(stringList);
            display(stringList);
        }

        ArrayList<Integer> intList = new ArrayList<>();
        System.out.println("\n--- Integer List Mode ---");
        while (true) {
            System.out.print("Enter an integer (or 999 to exit): ");
            
            try {
                String entry = input.nextLine();
                int number = Integer.parseInt(entry);

                if (number == 999) { // Assuming 999 is sentinel for ints
                    break;
                }

                intList.add(number);
                Collections.sort(intList);
                display(intList);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    public static <T> void display(ArrayList<T> list) {
        System.out.print("Current Sorted List: ");
        for (T element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}