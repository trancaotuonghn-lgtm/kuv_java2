package chap7;
import java.util.Scanner;

/*Write a program that inserts parentheses-(), a space( ), and a dash(-) into 
 * a String of 10 user-entered numbers to format it as a phone number. 
 * For example, 5153458912 becomes (515)345-8912. 
 * If the user does not enter exactly 10 digits, display an error message. 
 * Continue to accept user input until the user enters 999.
*/

public class PhoneNumberFormat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 10 digits or 999 to quit: ");
            String userInput = sc.nextLine();

            // Quit condition
            if (userInput.equals("999")) {
                System.out.println("Quit Program!");
                break;
            }

            // Check length first
            if (userInput.length() != 10) {
                System.out.println("Error! Please enter exactly 10 digits.\n");
                continue;
            }

            // Check if all characters are digits
            boolean checkDigits = true;
            for (int i = 0; i < userInput.length(); i++) {
                if (!Character.isDigit(userInput.charAt(i))) {
                    checkDigits = false;
                    break;
                }
            }

            if (!checkDigits) {
                System.out.println("Error! Input must contain digits only.\n");
                continue;
            }

            // Format the phone number
            StringBuilder sb = new StringBuilder(userInput);
            sb.insert(0, "(");
            sb.insert(4, ")");
            sb.insert(5, " ");
            sb.insert(9, "-");

            System.out.println("Formatted number is: " + sb.toString() + "\n");
        }

        sc.close();
    }
}

