//EVE DELLYIENNA WAHIDI 24000632
//Nur fatihah binti Mohd Noor 24000227

import java.util.ArrayList;
import java.util.List;

public class Client {
    
    String name;
    String phoneNumber;
    List<Order> orders;
    private Name privateName;
    private Address address;

    public Client(String name, String phoneNumber,Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address ;
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
