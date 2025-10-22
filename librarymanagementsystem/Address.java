package librarymanagementsystem;

public class Address {
    String street;
    String city;
    String state;
    int zip;
    String country;
    public Address(String street, String city, String state, int zip, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
}
