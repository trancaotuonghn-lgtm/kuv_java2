package chap12;
import java.util.Scanner;
public class AddingRecursively2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first integer: ");
        int a = input.nextInt();
        System.out.print("Enter the second integer: ");
        int b = input.nextInt();
        int low = Math.min(a, b);
        int high = Math.max(a, b);
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