package chap13_ex;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ApartmentsLinkedList2 {
    public static void main(String[] args) {
        LinkedList<Apartment> apartments = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String sentinel = "QUIT";

        System.out.println("Enter Apartment Data (type 'QUIT' for address to stop):");
        while (true) {
            System.out.print("\nEnter Street Address: ");
            String address = input.nextLine();
            if (address.equalsIgnoreCase(sentinel)) break;

            System.out.print("Enter Apt Number: ");
            String aptNum = input.nextLine();

            System.out.print("Enter Rent Amount: ");
            double rent = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Bedrooms: ");
            int bedrooms = Integer.parseInt(input.nextLine());

            apartments.add(new Apartment(address, aptNum, rent, bedrooms));
        }

        Collections.sort(apartments);
        System.out.println("\n--- Sorted List ---");
        displayList(apartments);

        System.out.print("\nEnter a street address to remove all apartments there: ");
        String addressToRemove = input.nextLine();

        Iterator<Apartment> it = apartments.iterator();
        while (it.hasNext()) {
            Apartment apt = it.next();
            if (apt.getStreetAddress().equalsIgnoreCase(addressToRemove)) {
                it.remove();
            }
        }

        System.out.println("\n--- Final List after removal ---");
        displayList(apartments);
    }

    public static void displayList(LinkedList<Apartment> list) {
        if (list.isEmpty()) {
            System.out.println("(List is empty)");
        } else {
            for (Apartment apt : list) {
                System.out.println(apt);
            }
        }
    }
}