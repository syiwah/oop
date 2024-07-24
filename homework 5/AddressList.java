/**
 * Write a description of class Name here.
 *
 * @NUR FATIHAH 24000227
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class AddressList {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    private ArrayList<Address> addresses;

    public AddressList() {
        this.addresses = new ArrayList<>();
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    // Optional: Add a method to display all addresses
    public void displayAddresses() {
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    // Optional: Add a method to get all addresses
    public ArrayList<Address> getAddresses() {
        return addresses;
    }
}

// Assuming you have an Address class, here is a simple example
class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}
