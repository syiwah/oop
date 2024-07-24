// INSYIRAH BINTI HAMZAH
// 24000157
import java.util.List;

public class Client {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    
    private String name;
    private String phoneNumber;
    private Address address;
    private List<Order> orders;

    public Client(String name, String phoneNumber, Address address, List<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
