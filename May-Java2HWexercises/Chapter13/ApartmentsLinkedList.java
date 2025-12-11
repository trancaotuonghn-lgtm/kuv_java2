//ex5b
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ApartmentsLinkedList {

    // Helper method to create an Apartment object from user input
    public static Apartment getApartmentFromUser(Scanner scanner) {
        try {
            System.out.print("  Enter street address: ");
            String address = scanner.nextLine();
            
            System.out.print("  Enter apartment number: ");
            int aptNum = Integer.parseInt(scanner.nextLine());
            
            System.out.print("  Enter monthly rent: $");
            double rent = Double.parseDouble(scanner.nextLine());
            
            System.out.print("  Enter number of bedrooms: ");
            int beds = Integer.parseInt(scanner.nextLine());
            
            return new Apartment(address, aptNum, rent, beds);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
            return null;
        }
    }

    public static void main(String[] args) {
        // Use a LinkedList to store Apartment objects
        LinkedList<Apartment> apartmentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        final String SENTINEL = "done";
        String input;

        System.out.println("Apartment Data Entry");
        System.out.println("Type '" + SENTINEL + "' to stop entering apartments.");

        // Prompt user for Apartment values
        do {
            System.out.print("\nAdd a new apartment? (y/" + SENTINEL + "): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {
                Apartment apt = getApartmentFromUser(scanner);
                if (apt != null) {
                    apartmentList.add(apt);
                    System.out.println("Apartment added.");
                }
            }

        } while (!input.equalsIgnoreCase(SENTINEL));

        System.out.println("\nOriginal List Size: " + apartmentList.size());
        
        // Sort the Apartments using the compareTo() method defined in the Apartment class
        Collections.sort(apartmentList);

        System.out.println("\nSorted Apartments (by Rent)");
        
        // Display the sorted list
        for (Apartment apt : apartmentList) {
            System.out.println(apt);
        }

        scanner.close();
    }
}
