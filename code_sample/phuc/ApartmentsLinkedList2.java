package chap13;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class ApartmentsLinkedList2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Apartment> list = new LinkedList<>();
        while (true) 
        {
            System.out.print("Enter street address (or 'end'): ");
            String addr = sc.nextLine();
            if (addr.equalsIgnoreCase("end"))
                break;
            System.out.print("Apartment number: ");
            int num = Integer.parseInt(sc.nextLine());
            System.out.print("Rent: ");
            double rent = Double.parseDouble(sc.nextLine());
            System.out.print("Bedrooms: ");
            int beds = Integer.parseInt(sc.nextLine());
            list.add(new Apartment(addr, num, rent, beds));
        }
        Collections.sort(list);
        System.out.println("\nSorted Apartments:");
        for (Apartment a : list)
            System.out.println(a);
        System.out.print("\nEnter a street address to remove: ");
        String removeAddr = sc.nextLine();
        Iterator<Apartment> it = list.iterator();
        boolean removed = false;
        while (it.hasNext()) 
        {
            Apartment a = it.next();
            if (a.toString().contains(removeAddr)) 
            {
                it.remove();
                removed = true;
            }
        }
        if (!removed) 
        {
            System.out.println("No apartments found with that address.");
        }
        System.out.println("\nUpdated list:");
        for (Apartment a : list)
            System.out.println(a);
    }
}