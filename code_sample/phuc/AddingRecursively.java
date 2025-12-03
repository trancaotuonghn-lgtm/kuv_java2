package chap12;
import java.util.Scanner;
public class AddingRecursively 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int low, high;
        System.out.print("Enter the first integer: ");
        low = input.nextInt();
        System.out.print("Enter the second integer (must be larger): ");
        high = input.nextInt();
        while (high <= low) 
        {
            System.out.print("Second integer must be larger. Enter again: ");
            high = input.nextInt();
        }
        int sum = recursiveSum(low, high);
        System.out.println("Sum from " + low + " to " + high + " = " + sum);
    }
    public static int recursiveSum(int low, int high) 
    {
        if (high <= low) 
        {
            return low;
        }
        return high + recursiveSum(low, high - 1);
    }
}