public class ElectricBlanket extends Blanket {
    // Additional Fields
    private int heatSettings;
    private boolean hasAutoShutoff;
    
    // Constants for default and pricing
    private static final int DEFAULT_HEAT_SETTINGS = 1;
    private static final double AUTO_SHUTOFF_PREMIUM = 5.75;

    // Constructor: Calls parent constructor and sets ElectricBlanket defaults.
     
    public ElectricBlanket() {
        super(); // Calls Blanket() constructor
        this.heatSettings = DEFAULT_HEAT_SETTINGS;
        this.hasAutoShutoff = false;
    }

    // Get Methods 

    public int getHeatSettings() {
        return heatSettings;
    }

    public boolean getHasAutoShutoff() {
        return hasAutoShutoff;
    }

    // Set Methods 
    
    public void setHeatSettings(int newSettings) {
        // Validation: Must be between 1 and 5 (inclusive)
        if (newSettings >= 1 && newSettings <= 5) {
            this.heatSettings = newSettings;
        } else {
            this.heatSettings = DEFAULT_HEAT_SETTINGS;
            System.out.println("Invalid heat settings (" + newSettings + "). Defaulting to 1.");
        }
    }

    public void setHasAutoShutoff(boolean shutoff) {
        // Price adjustment logic
        if (shutoff != this.hasAutoShutoff) {
            double currentPrice = super.getPrice();
            if (shutoff) {
                // Add premium
                this.hasAutoShutoff = true;
                currentPrice += AUTO_SHUTOFF_PREMIUM;
            } else {
                // Remove premium
                this.hasAutoShutoff = false;
                currentPrice -= AUTO_SHUTOFF_PREMIUM;
            }
            
        }
    }

    // toString Method 

    @Override
    public String toString() {
        // Call parent's toString and append new fields
        String parentDetails = super.toString();
        
        // Remove the closing price part to insert electric details
        // Find the index of the price: $
        int priceIndex = parentDetails.lastIndexOf(", Price=");
        
        String detailsBeforePrice = parentDetails.substring(0, priceIndex);
        String pricePart = parentDetails.substring(priceIndex);
        
        return detailsBeforePrice +
               ", HeatSettings=" + heatSettings +
               ", AutoShutoff=" + hasAutoShutoff +
               pricePart;
    }
}
