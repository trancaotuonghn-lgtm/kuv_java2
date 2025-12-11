package chap13_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class CommaPlacement {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String sentinel = "QUIT"; // Sentinel value

        System.out.println("Enter words (type 'QUIT' to stop):");
        
        while (true) {
            String entry = input.nextLine();
            if (entry.equalsIgnoreCase(sentinel)) {
                break;
            }
            words.add(entry);
        }

        System.out.print("Result: ");
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i));
            if (i < words.size() - 1) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }
    }
}