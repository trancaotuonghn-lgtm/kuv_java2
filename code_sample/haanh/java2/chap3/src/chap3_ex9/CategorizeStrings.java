package chap3_ex9;
import java.util.*;

public class CategorizeStrings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> shortStrings = new ArrayList<>(); // <=10c
		ArrayList<String> longStrings = new ArrayList<>(); // >=11c
		
		System.out.println("Enter a string (or 'quit' to stop: ");
		
		int count = 0;
		while(count < 20) {
			System.out.print("Enter string #" + (count + 1) + ": ");
			String str = input.nextLine();
			
			if (str.equalsIgnoreCase("quit")) {
				break;
			}
			
			if (str.length() <= 10) {
				shortStrings.add(str);
				System.out.println("Added to SHORT strings list.");
			} else {
				longStrings.add(str);
				System.out.println("Added to LONG strings list.");
			}
			
			count++;
		}
		
		System.out.println("Data entry complete");
		System.out.println("Short strings: " + shortStrings.size() + " items");
		System.out.println("Long strings: " + longStrings.size() + " items");

		boolean continueDisplay = true;
		while(continueDisplay) {
			System.out.println("Display (1)short or (2)long strings?");
			String choice = input.nextLine();
			
			if (choice.equals("1")) {
                displayStringList(shortStrings, "SHORT STRINGS");
            } else {
                // Mặc định hiển thị long strings nếu không chọn 1
                displayStringList(longStrings, "LONG STRINGS");
            }
			
			System.out.println("Do you want to view another list? (yes/no): ");
			String continueChoice = input.nextLine();
			if (!continueChoice.equalsIgnoreCase("yes")) {
				continueDisplay = false; 
			}
		}
		System.out.println("PROGRAM ENDED");
		input.close();
	}
	public static void displayStringList(ArrayList<String> list, String title) {
		System.out.println("title");
		
		if (list.isEmpty()) {
			System.out.println("No strings in this category.");
		} else {
			System.out.println("Total: " + list.size() + " string(s)");
			
			for (int i = 0; i < list.size(); i++) {
				String str = list.get(i);
				System.out.println((i+1) + ". \"" + str + "\" (" + str.length() + " characters)");
			}
		}
	}
}
