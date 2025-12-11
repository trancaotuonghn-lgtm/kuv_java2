package chap13_ex;

import java.util.Scanner;

public class SwapAnyTypes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = input.nextLine();
        System.out.print("Enter second string: ");
        String s2 = input.nextLine();

        System.out.println("\n--- Processing Strings ---");
        processAndSwap(s1, s2);

        System.out.print("\nEnter first integer: ");
        int i1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int i2 = input.nextInt();

        System.out.println("\n--- Processing Integers ---");
        processAndSwap(i1, i2);
    }

    public static <T> void processAndSwap(T item1, T item2) {
        display(item1, item2, "Original");
        
        T temp = item1;
        item1 = item2;
        item2 = temp;
        
        display(item1, item2, "Swapped");
    }

    public static <T> void display(T item1, T item2, String label) {
        System.out.println(label + ": " + item1 + " | " + item2);
    }
}