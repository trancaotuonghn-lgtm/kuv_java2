package chap12_ex; 
import java.util.Scanner;

public class AddingRecursively {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter first integer: ");
        num1 = input.nextInt();

        do {
            System.out.print("Enter second integer (must be larger than first): ");
            num2 = input.nextInt();
            if (num2 <= num1) {
                System.out.println("Invalid input. Second number must be larger.");
            }
        } while (num2 <= num1);
        
        System.out.print("The sequence of numbers is: ");
        for (int i = num1; i <= num2; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();

        int total = sumRecursively(num1, num2);
        System.out.println("Sum of numbers between " + num1 + " and " + num2 + " is: " + total);
    }

    public static int sumRecursively(int low, int high) {
        if (high < low) {
            return 0;
        }
        return high + sumRecursively(low, high - 1);
    }
}
