package chap13;
public class Apartment implements Comparable<Apartment> 
{
    private String streetAddress;
    private int apartmentNumber;
    private double rent;
    private int bedrooms;
    public Apartment(String streetAddress, int apartmentNumber, double rent, int bedrooms) 
    {
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.rent = rent;
        this.bedrooms = bedrooms;
    }
    @Override
    public int compareTo(Apartment other) 
    {
        return Double.compare(this.rent, other.rent);
    }
    @Override
    public String toString() 
    {
        return "Address: " + streetAddress +
               ", Apt#: " + apartmentNumber +
               ", Rent: $" + rent +
               ", Bedrooms: " + bedrooms;
    }
}