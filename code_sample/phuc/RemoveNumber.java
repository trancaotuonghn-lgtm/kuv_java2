package chap13;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class RemoveNumber 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        System.out.println("Original list:");
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) 
        {
            System.out.print(it.next() + " ");
        }
        System.out.print("\n\nEnter a number to remove: ");
        int removeValue = sc.nextInt();
        if (nums.contains(removeValue)) 
        {
            nums.remove(Integer.valueOf(removeValue));
            System.out.println("Removed.");
        }
        else {
            System.out.println("Number not found.");
        }
        System.out.println("\nList after removal:");
        it = nums.iterator();
        while (it.hasNext()) 
        {
            System.out.print(it.next() + " ");
        }
    }
}