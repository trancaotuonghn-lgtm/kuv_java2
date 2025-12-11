package chap13_ex;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ApartmentsLinkedList {
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

        System.out.println("\n--- Sorting by Rent ---");
        Collections.sort(apartments);

        System.out.println("Sorted List:");
        for (Apartment apt : apartments) {
            System.out.println(apt);
        }
    }
}