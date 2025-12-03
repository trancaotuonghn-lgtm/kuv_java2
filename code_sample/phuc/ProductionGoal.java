package chap12;
import java.util.Scanner;
public class ProductionGoal 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int currentProduction = 1000;
        double rate = 0.06;
        System.out.print("Enter production goal: ");
        int goal = input.nextInt();
        if (goal <= currentProduction) 
        {
            System.out.println("Goal already met.");
        } 
        else {
            int months = findMonth(0, currentProduction, rate, goal);
            System.out.println("Goal reached in " + months + " months.");
        }
    }
    public static int findMonth(int month, double production,
                                double rate, int goal) 
    {
        if (production >= goal)
            return month;
        return findMonth(month + 1,
                production * (1 + rate),
                rate, goal);
    }
}