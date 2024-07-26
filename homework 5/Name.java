/**
 * Represents a person's name with first and last names.
 *
 * @author NUR FATIHAH 24000227
 * @version 1.0
 */
public class Name {
    // Instance variables
    private String firstName;
    private String lastName;

    /**
     * Constructs a Name object with the given first and last names.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Displays the full name.
     */
    public void displayName() {
        System.out.println("Client's name: " + firstName + " " + lastName);
    }
}
