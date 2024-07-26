// HADHINA SYAHIRA BINTI MUHAMMAD HILMI
// 24000291

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
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

    public void saveToDatabase(String clientName) throws SQLException {
        String sql = "INSERT INTO orders (item_name, price, order_date, order_time, client_name) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.itemName);
            pstmt.setDouble(2, this.price);
            pstmt.setDate(3, java.sql.Date.valueOf(this.orderDate));
            pstmt.setTime(4, java.sql.Time.valueOf(this.orderTime));
            pstmt.setString(5, clientName);
            pstmt.executeUpdate();
        }
    }
}
