//Chapter 12-ex5

import java.util.Scanner;

public class PopulationRecursive {

    // Initial populations (in millions)
    private static final double POP_CA = 39.0;
    private static final double POP_TX = 28.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rateCA, rateTX;

        System.out.println("Population Shift Calculator");
        System.out.printf("Current Population: California (%.1fM), Texas (%.1fM)%n", POP_CA, POP_TX);

        System.out.print("Enter projected annual growth rate for California (e.g., 0.005): ");
        rateCA = scanner.nextDouble();

        System.out.print("Enter projected annual growth rate for Texas (e.g., 0.015): ");
        rateTX = scanner.nextDouble();

        // Constraint: Force California rate to 0 if it is greater than or equal to Texas's rate
        if (rateCA >= rateTX) {
            System.out.println("\nWarning: Texas's rate must be higher for a shift to occur. Setting California's rate to 0.");
            rateCA = 0.0;
        }

        System.out.println("\nYearly Projections:");
        int years = calculateShift(rateCA, rateTX, POP_CA, POP_TX, 0);

        System.out.printf("\nIt will take %d years for Texas's population to exceed California's.%n", years);
        
        scanner.close();
    }

    public static int calculateShift(double rateCA, double rateTX, double popCA, double popTX, int currentYear) {
        // Texas's population exceeds California's.
        if (popTX > popCA) {
            return currentYear;
        } 
        // Calculate population for the next year.
        else {
            System.out.printf("Year %d: CA=%.2fM, TX=%.2fM%n", currentYear, popCA, popTX);
            
            // Calculate new populations
            double nextPopCA = popCA * (1 + rateCA);
            double nextPopTX = popTX * (1 + rateTX);
            
            // Call the method for the next year (currentYear + 1)
            return calculateShift(rateCA, rateTX, nextPopCA, nextPopTX, currentYear + 1);
        }
    }
}
