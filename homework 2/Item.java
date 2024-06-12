// INSYIRAH BINTI HAMZAH 24000157
public class Item {
    
    String name;
    double supplierPrice;
    int quantity;
    String supplierName;

    public Item(String name, double supplierPrice, int quantity, String supplierName) {
        this.name = name;
        this.supplierPrice = supplierPrice;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }
    
    // INSYIRAH BINTI HAMZAH 24000157
    // setter & getter for name
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // setter & getter for supplierPrice
    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
    
    public double getSupplierPrice() {
        return supplierPrice;
    }
    
    // setter & getter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    // setter & getter for supplierName
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public String getSupplierName() {
        return supplierName;
    }
}
