/**
 * Write a description of class Name here.
 *
 * @NUR FATIHAH 24000227
 * @version (a version number or a date)
 */
public class Name
{
    // instance variables - replace the example below with your own
    protected String firstName, lastName;

    /**
     * Constructor for objects of class Name
     */
    public Name(String firstName, String lastName)
    {
         this.firstName = firstName;
         this.lastName = lastName;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void displayName()
    {
         System.out.println("Client's name: " + firstName + lastName);
    }
}
