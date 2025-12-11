package chap13_ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RemoveNumber {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(33);
        numbers.add(42);
        numbers.add(55);

        System.out.println("Original list:");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number to remove: ");
        int numberToRemove = input.nextInt();

        if (numbers.contains(numberToRemove)) {
            numbers.remove(Integer.valueOf(numberToRemove));
            System.out.println("Number removed.");
        } else {
            System.out.println("Number not found in the list.");
        }

        System.out.println("Updated list: " + numbers);
    }
}