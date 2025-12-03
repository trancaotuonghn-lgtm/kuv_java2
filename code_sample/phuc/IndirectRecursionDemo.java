package chap12;
import java.util.Scanner;
public class IndirectRecursionDemo 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        first(num);
    }
    public static void first(int n) 
    {
        if (n > 0) 
        {
            System.out.println(n);
            second(n - 1);
        }
    }
    public static void second(int n) 
    {
        if (n > 0) 
        {
            System.out.println(n);
            first(n - 1);
        }
    }
}