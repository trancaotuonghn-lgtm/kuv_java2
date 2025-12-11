public class Blanket {
    // Fields
    private String size;
    private String color;
    private String material;
    private double price;

    // Constants for default and pricing
    private static final String DEFAULT_SIZE = "Twin";
    private static final String DEFAULT_COLOR = "white";
    private static final String DEFAULT_MATERIAL = "cotton";
    private static final double BASE_PRICE = 30.00;

    public Blanket() {
        this.size = DEFAULT_SIZE;
        this.color = DEFAULT_COLOR;
        this.material = DEFAULT_MATERIAL;
        this.price = BASE_PRICE;
    }

    // Set Methods 

    public void setSize(String newSize) {
        String lowerCaseSize = newSize.toLowerCase();
        double priceAdjustment = 0;
        
        // Determine price adjustment based on valid size
        if (lowerCaseSize.equals("twin")) {
            priceAdjustment = 0;
        } else if (lowerCaseSize.equals("double")) {
            priceAdjustment = 10.00;
        } else if (lowerCaseSize.equals("queen")) {
            priceAdjustment = 25.00;
        } else if (lowerCaseSize.equals("king")) {
            priceAdjustment = 40.00;
        } else {
            // Invalid size: reset to default
            this.size = DEFAULT_SIZE;
            this.price = BASE_PRICE;
            System.out.println("Invalid size entered. Resetting to default: Twin and $" + BASE_PRICE);
            // After resetting to BASE_PRICE, we must re-calculate material price if it was set
            setMaterial(this.material); 
            return;
        }
        
        // Only update size if valid
        this.size = newSize;

        // Reset price and apply current material price
        this.price = BASE_PRICE + priceAdjustment;
        setMaterial(this.material); // Re-apply current material price after size change
    }

    public void setColor(String newColor) {
        this.color = newColor;
    }

    public void setMaterial(String newMaterial) {
        String lowerCaseMaterial = newMaterial.toLowerCase();
        double materialPremium = 0;
        
        // Determine material premium based on valid material
        if (lowerCaseMaterial.equals("cotton")) {
            materialPremium = 0;
        } else if (lowerCaseMaterial.equals("wool")) {
            materialPremium = 20.00;
        } else if (lowerCaseMaterial.equals("cashmere")) {
            materialPremium = 45.00;
        } else {
            // Invalid material: reset to default
            this.material = DEFAULT_MATERIAL;
            // Recalculate price: base price + size premium + default material price (0)
            this.price = BASE_PRICE;
            setSize(this.size); // Recalculate price based on current size
            System.out.println("Invalid material entered. Resetting to default: cotton.");
            return;
        }
        
        // Only update material if valid
        this.material = newMaterial;
        
        // Calculate current size premium (needs to be done dynamically)
        // Note: For simplicity and to avoid circular logic, we will rely on setSize
        // being called last, OR manually recalculate the size premium here.
        double sizePremium = calculateSizePremium(this.size);
        
        this.price = BASE_PRICE + sizePremium + materialPremium;
    }
    
    // Helper method to calculate size premium for setMaterial logic
    private double calculateSizePremium(String currentSize) {
        String lowerCaseSize = currentSize.toLowerCase();
        if (lowerCaseSize.equals("double")) return 10.00;
        if (lowerCaseSize.equals("queen")) return 25.00;
        if (lowerCaseSize.equals("king")) return 40.00;
        return 0; // Twin or default
    }


    // toString Method 

    @Override
    public String toString() {
        return "Blanket Details: Size=" + size + 
               ", Color=" + color + 
               ", Material=" + material + 
               String.format(", Price=$%.2f", price);
    }
    
    // Get Methods (Optional, but good practice) 
    public double getPrice() {
        return price;
    }
}
