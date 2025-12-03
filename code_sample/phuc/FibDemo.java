package chap12;
import java.util.Scanner;
public class FibDemo 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ending value: ");
        int end = input.nextInt();
        System.out.println("Fibonacci sequence up to " + end + ":");
        int i = 1;
        while (true) 
        {
            int f = fibonacci(i);
            if (f > end) break;
            System.out.print(f + " ");
            i++;
        }
    }
    public static int fibonacci(int n) 
    {
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}