//INSYIRAH BINTI HAMZAH
// 24000157
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuWindow extends Application {

    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";


    @Override
    public void start(Stage stage) {
        stage.setTitle("Menu");

        GridPane menuPane = new GridPane();
        menuPane.setPadding(new Insets(10, 10, 10, 10));
        menuPane.setVgap(10);
        menuPane.setHgap(20);

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT item_name, price FROM menu")) {

            System.out.println("Connected to the database successfully");

            int row = 0;
            while (rs.next()) {
                String itemName = rs.getString("item_name");
                double price = rs.getDouble("price");

                System.out.println("Retrieved item: " + itemName + " with price: RM " + price);

                menuPane.add(new Label(itemName), 0, row);
                menuPane.add(new Label(String.format("RM %.2f", price)), 1, row);
                row++;
            }

            if (row == 0) {
                System.out.println("No data found in the menu table");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unexpected error: " + e.getMessage());
        }

        Scene menuScene = new Scene(menuPane, 200, 250);
        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}