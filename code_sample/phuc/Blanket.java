public class Blanket 
{
    protected String size;
    protected String color;
    protected String material;
    protected double price;
    public Blanket() 
    {
        size = "Twin";
        color = "white";
        material = "cotton";
        price = 30.00;
    }
    public void setSize(String size) 
    {
        if (size.equalsIgnoreCase("Twin")) 
        {
            this.size = "Twin";
            price = 30.00;
        } else if (size.equalsIgnoreCase("Double")) 
        {
            this.size = "Double";
            price = 30.00 + 10.00;
        } else if (size.equalsIgnoreCase("Queen")) 
        {
            this.size = "Queen";
            price = 30.00 + 25.00;
        } else if (size.equalsIgnoreCase("King")) 
        {
            this.size = "King";
            price = 30.00 + 40.00;
        } else {
            resetToDefault();
        }
    }
    public void setColor(String color) 
    {
        this.color = color;
    }

    public void setMaterial(String material) 
    {
        if (material.equalsIgnoreCase("cotton")) 
        {
            this.material = "cotton";
        } else if (material.equalsIgnoreCase("wool")) 
        {
            this.material = "wool";
            price += 20.00;
        } else if (material.equalsIgnoreCase("cashmere")) 
        {
            this.material = "cashmere";
            price += 45.00;
        } 
        else {
            resetToDefault();
        }
    }
    private void resetToDefault() 
    {
        size = "Twin";
        color = "white";
        material = "cotton";
        price = 30.00;
    }
    public String toString() 
    {
        return "Blanket Details:\n" +
               "Size: " + size +
               "\nColor: " + color +
               "\nMaterial: " + material +
               "\nPrice: $" + String.format("%.2f", price);
    }
}