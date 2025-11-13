import java.util.Scanner;
public class DemoBlankets 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Blanket blanket = new Blanket();
        System.out.println("\nStarting Blanket:\n" + blanket);
        while (true) {
            System.out.print("\nEnter blanket material (cotton, wool, cashmere) or 'quit' to stop: ");
            String material = input.nextLine();
            if (material.equalsIgnoreCase("quit"))
                break;
            blanket.setMaterial(material);
            System.out.print("Enter blanket size (Twin, Double, Queen, King): ");
            String size = input.nextLine();
            blanket.setSize(size);
            System.out.println("\nUpdated Blanket:\n" + blanket);
        }
        ElectricBlanket eBlanket = new ElectricBlanket();
        System.out.println("\nStarting Electric Blanket:\n" + eBlanket);
        while (true) {
            System.out.print("\nEnter electric blanket material (cotton, wool, cashmere) or 'quit' to stop: ");
            String material = input.nextLine();
            if (material.equalsIgnoreCase("quit"))
                break;
            eBlanket.setMaterial(material);
            System.out.print("Enter electric blanket size (Twin, Double, Queen, King): ");
            String size = input.nextLine();
            eBlanket.setSize(size);
            System.out.print("Enter number of heat settings (1–5): ");
            int settings = input.nextInt();
            input.nextLine(); 
            eBlanket.setHeatSettings(settings);
            System.out.print("Does it have automatic shutoff? (yes/no): ");
            String shutoff = input.nextLine();
            eBlanket.setAutoShutoff(shutoff.equalsIgnoreCase("yes"));
            System.out.println("\nUpdated Electric Blanket:\n" + eBlanket);
        }
        input.close();
    }
}