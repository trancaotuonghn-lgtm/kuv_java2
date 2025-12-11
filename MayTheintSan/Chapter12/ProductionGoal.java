//Chapter12-ex6

import java.util.Scanner;

public class ProductionGoal {

    private static final double STARTING_PRODUCTION = 1000.0;
    private static final double GROWTH_RATE = 0.06; // 6 percent

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double goal;

        System.out.println("Production Goal Calculator");
        System.out.printf("Current Monthly Production: %.0f units%n", STARTING_PRODUCTION);
        System.out.printf("Monthly Growth Rate: %.0f%%%n", GROWTH_RATE * 100);

        System.out.print("Enter the production goal: ");
        goal = scanner.nextDouble();

        if (goal <= STARTING_PRODUCTION) {
            System.out.println("The goal has already been met this month.");
        } else {
            // Start the recursive calculation from month 0 (current month)
            int months = findGoalMonth(0, STARTING_PRODUCTION, goal);
            System.out.printf("\nThe goal of %.0f units will be met in %d months from now.%n", goal, months);
        }
        
        scanner.close();
    }

    public static int findGoalMonth(int currentMonth, double currentProduction, double goal) {
        // if the current production meets or exceeds the goal
        if (currentProduction >= goal) {
            // Return the number of months it took (the currentMonth index)
            return currentMonth;
        } 
        // calculate production for the next month
        else {
            System.out.printf("Month %d: Production is %.2f%n", currentMonth, currentProduction);
            
            // Calculate next month's production (1 + 0.06)
            double nextProduction = currentProduction * (1 + GROWTH_RATE);
            
            // Call the method for the next month (currentMonth + 1)
            return findGoalMonth(currentMonth + 1, nextProduction, goal);
        }
    }
}
