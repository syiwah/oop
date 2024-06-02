import java.util.List;
import java.util.ArrayList;

public class Order {
    
    String item;
    double price;
    String date;
    String time;
    
    public Order(String item, double price, String date, String time) {
        this.item = item;
        this.price = price;
        this.date = date;
        this.time = time;
    }
}