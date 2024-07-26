//HADHINA SYAHIRA BINTI MUHAMMAD HILMI
//24000291

import java.util.ArrayList;

public class Orders {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    
    private ArrayList<Order> orderList = new ArrayList<>();

    public Orders() {
    }

    public void add(Order order) {
        orderList.add(order);
    }

    public void remove(Order order) {
        orderList.remove(order);
    }

    public void printOrders() {
        for (Order order : orderList) {
            System.out.println("Item: " + order.getItemName() + ", Price: RM " + order.getPrice() + ", Date: " + order.getOrderDate() + ", Time: " + order.getOrderTime());
        }
    }

    public Order find(String itemName) {
        for (Order order : orderList) {
            if (order.getItemName().equalsIgnoreCase(itemName)) {
                return order;
            }
        }
        return null;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Order order : orderList) {
            total += order.getPrice();
        }
        return total;
    }
}
