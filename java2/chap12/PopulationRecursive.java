package chap12_ex;
import java.util.*;

public class PopulationRecursive {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		double caPop = 39.0;
		double txPop = 28.0;
		
		System.out.print("Enter annual growth rate for California (e.g., 0.01 for 1%): ");
		double caRate = input.nextDouble();
		
		System.out.print("Enter annual growth rate for Texas (e.g., 0.03 for 3%): ");
		double txRate = input.nextDouble();
		
		if (txRate < caRate) {
	        System.out.println("TX rate is lower. Forcing CA rate to 0 to simulate catch-up possibility.");
	        caRate = 0;
	    }
		
		System.out.println("\nCalculating future populations...");
	    int years = calculateYears(caRate, txRate, caPop, txPop, 0);
	    
	    System.out.println("\nIt will take " + years + " years for Texas to exceed California.");
	}
    
    public static int calculateYears(double caRate, double txRate, double currentCaPop, double currentTxPop, int yearCount) {
        System.out.printf("Year %d: CA = %.2f million, TX = %.2f million\n", yearCount, currentCaPop, currentTxPop);

        if (currentTxPop > currentCaPop) {
            return yearCount;
        }

        double nextCaPop = currentCaPop * (1 + caRate);
        double nextTxPop = currentTxPop * (1 + txRate);

        return calculateYears(caRate, txRate, nextCaPop, nextTxPop, yearCount + 1);
    }
}
