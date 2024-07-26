//INSYIRAH BINTI HAMZAH
// 24000157
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "syirahh.hamzah@gmail.com";
    private static final String PASSWORD = "Shinystar10@"; // Replace with the actual password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver", e);
        } catch (SQLException e) {
            throw new SQLException("Error connecting to the database: " + e.getMessage(), e);
        }
    }
}
