public class Item {
    
    String name;
    String supplierPrice;
    String quantity;
    String supplierName;

    public Item(String name, String supplierPrice, String quantity, String supplierName) {
        this.name = name;
        this.supplierPrice = supplierPrice;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }
    
    // setter & getter for name
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    // setter & getter for supplierPrice
    public void setSupplierPrice(String supplierPrice) {
        this.supplierPrice = supplierPrice;
    }
    
    public String getSupplierPrice() {
        return supplierPrice;
    }
    
    // setter & getter for quantity
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public String getQuantity() {
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
