package chap9_ex1;

class ElectricBlanket extends Blanket {
    private int numSettings;
    private boolean hasShutoff;

    private static final int DEFAULT_SETTINGS = 1;
    private static final int MAX_SETTINGS = 5;
    private static final double SHUTOFF_PREMIUM = 5.75;

    public ElectricBlanket() {
        super(); 
        this.numSettings = DEFAULT_SETTINGS;
        this.hasShutoff = false;
    }

    public int getNumSettings() {
        return numSettings;
    }

    public void setNumSettings(int settings) {
        if (settings >= 1 && settings <= MAX_SETTINGS) {
            this.numSettings = settings;
        } else {
            // Nếu không hợp lệ, sử dụng giá trị mặc định
            this.numSettings = DEFAULT_SETTINGS;
        }
    }

    public boolean isHasShutoff() {
        return hasShutoff;
    }

void setHasShutoff(boolean hasShutoff) {
        this.hasShutoff = hasShutoff;
        updatePrice();
    }
    
    @Override
    protected void updatePrice() {
        super.updatePrice();
        if (this.hasShutoff) {
            this.price += SHUTOFF_PREMIUM;
        }
    }
    
    protected void resetToDefaults() {
        super.resetToDefaults();
        
        this.numSettings = DEFAULT_SETTINGS;
        this.hasShutoff = false;
    }

    public String toString() {
        String parentString = super.toString();
        
        String shutoffStatus;
        if (this.hasShutoff) {
            shutoffStatus = "Có";
        } else {
            shutoffStatus = "Không";
        }
        return parentString +
               "\n\tCài đặt nhiệt: " + this.numSettings +
               "\n\tTự động tắt: " + shutoffStatus;
    }
}
