package chap13_ex;

public class Apartment implements Comparable<Apartment> {
    private String streetAddress;
    private String apartmentNumber;
    private double rentAmount;
    private int bedrooms;

    public Apartment(String streetAddress, String apartmentNumber, double rentAmount, int bedrooms) {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.rentAmount = rentAmount;
        this.bedrooms = bedrooms;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    @Override
    public String toString() {
        return String.format("Apt %s at %s (%d BR) - $%.2f", 
                apartmentNumber, streetAddress, bedrooms, rentAmount);
    }

    @Override
    public int compareTo(Apartment other) {
        // Compare based on rent value
        if (this.rentAmount < other.rentAmount) return -1;
        if (this.rentAmount > other.rentAmount) return 1;
        return 0;
    }
}