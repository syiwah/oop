import java.util.ArrayList;
import java.util.List;

public class Client {
    String name;
    String phoneNumber;
    List<Order> orders;

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
    }

    public void removeOrder(Order order) {
    }

    public void printClientDetails() {
    }

    public Order findOrder(String itemName) {
        return null;
    }
}
