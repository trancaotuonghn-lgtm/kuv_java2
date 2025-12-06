package chap13;
import java.util.ArrayList;
import java.util.Scanner;
public class CommaPlacement 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        String input;
        System.out.println("Enter strings (type 'end' to stop):");
        while (true) 
        {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("end"))
                break;
            list.add(input);
        }
        for (int i = 0; i < list.size(); i++) 
        {
            System.out.print(list.get(i));
            if (i < list.size() - 1)
                System.out.print(", ");
            else
                System.out.print(".");
        }
    }
}