// NUR ALYA SYAZWINA BINTI SAMSUL BAHRIN
// 24000088

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Item {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";
    
    private String name;
    private double supplierPrice;
    private int quantity;
    private String supplierName;

    public Item(String name, double supplierPrice, int quantity, String supplierName) {
        this.name = name;
        this.supplierPrice = supplierPrice;
        this.quantity = quantity;
        this.supplierName = supplierName;
    }

    public String getName() {
        return name;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void saveToDatabase() throws SQLException {
        String sql = "INSERT INTO items (name, supplier_price, quantity, supplier_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.name);
            pstmt.setDouble(2, this.supplierPrice);
            pstmt.setInt(3, this.quantity);
            pstmt.setString(4, this.supplierName);
            pstmt.executeUpdate();
        }
    }
}
