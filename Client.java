import java.util.List;

public class Client {
    private String name;
    private String phoneNumber;
    private List<Order> orders;
    private Address address;

    public Client(String name, String phoneNumber, List<Order> orders, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Address getAddress() {
        return address;
    }
}
