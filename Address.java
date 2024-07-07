/**
 * Write a description of class Address here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Address
{
    // instance variables - replace the example below with your own
protected String city,state,zipcode;

    /**
     * Constructor for objects of class Address
     */
    public Address(String city,String state,String zipcode)
    {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void displayAddress() {
    
    System.out.println("Address: " + city + ", " + state + ", " + zipcode);

    }
}
