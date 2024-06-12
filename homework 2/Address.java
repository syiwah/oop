//EVE DELLYIENNA WAHIDI

//class for Address
public class Address {
    
    //defining attributes for the Address class
    private String city;
    private String state;
    private String zipcode;
    
    //constructors - to initialize objects
    public Address(String city, String state, String zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    //assigning getters and setters for attributes
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    //method to display Address
    public void displayAddress() {
        System.out.println("Address: " + city + ", " + state + ", " + zipcode);
    }
}