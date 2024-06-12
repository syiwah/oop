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
    
    // setter & getter for item
    public void setItem(String item) {
        this.item = item;
    }
    
    public String getItem() {
        return item;
    }
    
    // setter & getter for price
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    // setter & getter for date
    public void setDate(String item) {
        this.date = date;
    }
    
    public String getDate() {
        return date;
    }
    // setter & getter for time
    public void setTime(String time) {
        this.time = time;
    }
    
    public String getTime() {
        return time;
    }

}