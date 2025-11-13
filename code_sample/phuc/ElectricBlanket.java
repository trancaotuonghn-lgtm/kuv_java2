public class ElectricBlanket extends Blanket 
{
    private int heatSettings;
    private boolean hasAutoShutoff;
    public ElectricBlanket() 
    {
        super(); 
        heatSettings = 1;
        hasAutoShutoff = false;
    }
    public void setHeatSettings(int settings) 
    {
        if (settings >= 1 && settings <= 5) 
        {
            this.heatSettings = settings;
        } 
        else {
            this.heatSettings = 1; 
        }
    }
    public void setAutoShutoff(boolean autoShutoff) 
    {
        this.hasAutoShutoff = autoShutoff;
        if (autoShutoff) 
        {
            price += 5.75;
        }
    }
    public int getHeatSettings() 
    {
        return heatSettings;
    }
    public boolean getAutoShutoff() 
    {
        return hasAutoShutoff;
    }
    public String toString() 
    {
        return super.toString() +
               "\nHeat Settings: " + heatSettings +
               "\nAutomatic Shutoff: " + (hasAutoShutoff ? "Yes" : "No");
    }
}