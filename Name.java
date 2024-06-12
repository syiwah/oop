//EVE DELLYIENNA WAHIDI

public class Name {
    
    //define attributes that are only visible within this class
    private String firstName;
    private String lastName;
    
    //constructors - to initialize objects
    public Name(String firstName , String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //assigning getters and setters for attribute
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    
    }
    
    public String getfirstName( ) {
        return firstName;
    }
    
    public void setlastName(String lastName) {
        this.lastName = lastName;
    
    }
    
    public String getlastName( ) {
        return lastName;
    }
    
    //method to display Name
    public void displayName() {
        System.out.println("Client's name: " + firstName + lastName);
    }
}