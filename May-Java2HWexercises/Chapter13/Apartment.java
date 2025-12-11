//ex5a
public class Apartment implements Comparable<Apartment> {
    
    // Fields
    private String streetAddress;
    private int apartmentNumber;
    private double monthlyRent;
    private int numberOfBedrooms;

    // Constructor
    public Apartment(String address, int aptNum, double rent, int bedrooms) {
        this.streetAddress = address;
        this.apartmentNumber = aptNum;
        this.monthlyRent = rent;
        this.numberOfBedrooms = bedrooms;
    }

    // Getters (needed for Ex5c elimination)
    public String getStreetAddress() {
        return streetAddress;
    }

    // toString() method to display Apartment values nicely
    @Override
    public String toString() {
        return "Apartment [Address: " + streetAddress + 
               " Apt #" + apartmentNumber + 
               ", Rent: $" + String.format("%.2f", monthlyRent) + 
               ", Beds: " + numberOfBedrooms + "]";
    }

    @Override
    public int compareTo(Apartment other) {
        return Double.compare(this.monthlyRent, other.monthlyRent);
    }
}
