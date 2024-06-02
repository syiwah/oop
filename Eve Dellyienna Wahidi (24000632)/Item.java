import java.util.List;
import java.util.ArrayList;

public class Item {
    
    String itemName;
    double supplierPrice;
    int quantity;
    String supplierName;
    
    public Item(String itemName, double supplierPrice, int quantity, String supplierName) {
        this.itemName = itemName;
        this.supplierPrice = supplierPrice;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }
}