package chap12;
import java.util.Scanner;
public class PopulationRecursive 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        double california = 39;
        double texas = 28;
        System.out.print("Enter California growth rate (%): ");
        double calRate = input.nextDouble();
        System.out.print("Enter Texas growth rate (%): ");
        double texRate = input.nextDouble();
        if (texRate < calRate) 
        {
            System.out.println("Texas rate must not be lower. Setting California rate to 0.");
            calRate = 0;
        }
        int years = comparePop(texRate, calRate, texas, california, 0);
        System.out.println("Texas surpasses California in " + years + " years.");
    }
    public static int comparePop(double texRate, double calRate,
                                 double texas, double cal, int year) 
    {
        if (texas > cal) 
        {
            return year;
        }
        System.out.printf("Year %d -> Texas: %.2fM | California: %.2fM%n",
                          year, texas, cal);
        return comparePop(texRate, calRate,
                texas * (1 + texRate / 100),
                cal * (1 + calRate / 100),
                year + 1);
    }
}