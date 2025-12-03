package chap12;
import java.util.Scanner;
public class MultiplicationByAdding 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int x = input.nextInt();
        System.out.print("Enter second integer: ");
        int y = input.nextInt();
        int product = multiply(x, y);
        System.out.println(x + " * " + y + " = " + product);
    }
    public static int multiply(int x, int y) 
    {
        if (y == 0) return 0;
        if (y > 0) return x + multiply(x, y - 1);
        return -multiply(x, -y);
    }
}