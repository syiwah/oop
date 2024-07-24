//HADHINA SYAHIRA BINTI MUHAMMAD HILMI
//24000291
import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    
    private String itemName;
    private double price;
    private LocalDate orderDate;
    private LocalTime orderTime;

    public Order(String itemName, double price, LocalDate orderDate, LocalTime orderTime) {
        this.itemName = itemName;
        this.price = price;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }
}
