//ex5c
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class ApartmentsLinkedList2 {

    // Reusing the helper method from Ex5b
    public static Apartment getApartmentFromUser(Scanner scanner) {
        // (same implementation as in Ex5b)
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
    
    // Helper method to display the list
    public static void displayList(LinkedList<Apartment> list, String title) {
        System.out.println("\n" + title + " (Total: " + list.size() + ")");
        if (list.isEmpty()) {
            System.out.println("[List is Empty]");
        } else {
            for (Apartment apt : list) {
                System.out.println(apt);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Apartment> apartmentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        final String SENTINEL = "done";
        String input;

        // Data Entry (Same as Ex5b)
        System.out.println("Apartment Data Entry");
        System.out.println("Type '" + SENTINEL + "' to stop entering apartments.");

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

        // Sort and display the initial list
        Collections.sort(apartmentList);
        displayList(apartmentList, "Sorted Apartments (Initial)");
        
        System.out.println("\nBuilding Elimination");
        System.out.print("Enter street address to eliminate (e.g., Main Street): ");
        String addressToEliminate = scanner.nextLine();

        int removedCount = 0;
        
        // Use an Iterator for safe removal while looping through the list
        Iterator<Apartment> iterator = apartmentList.iterator();
        while (iterator.hasNext()) {
            Apartment apt = iterator.next();
            
            // Check if the apartment's address matches the one to eliminate
            if (apt.getStreetAddress().equalsIgnoreCase(addressToEliminate)) {
                iterator.remove();
                removedCount++;
            }
        }

        System.out.println("\n Elimination Complete ");
        System.out.println("Successfully removed " + removedCount + " apartments at '" + addressToEliminate + "'.");
        
        // Display the list again
        displayList(apartmentList, "Remaining Apartments (Post-Elimination)");
        
        scanner.close();
    }
}
