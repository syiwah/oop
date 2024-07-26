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
/**
 * Represents a person's name with first and last names.
 *
 * @author NUR FATIHAH 24000227
 * @version 1.0
 */
public class WindowNameAddress extends Application {

    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com";
    private static final String PASSWORD = "Shinystar10@";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Names & Addresses");

        GridPane nameAddPane = new GridPane();
        nameAddPane.setPadding(new Insets(10, 10, 10, 10));
        nameAddPane.setVgap(10);
        nameAddPane.setHgap(20);

        // Add headers for the columns
        nameAddPane.add(new Label("Name"), 0, 0);
        nameAddPane.add(new Label("Phone Number"), 1, 0);
        nameAddPane.add(new Label("Address ID"), 2, 0);
        
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, phone_number,address_id " +
                                              "FROM Clients "
                                              )) {

            System.out.println("Connected to the database successfully");

            int row = 1; // Start from 1 to leave space for headers
            while (rs.next()) {
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address_id");
                

                System.out.println("Retrieved client: " + name + " with phone number: " + phoneNumber +
                                   ", Address: " + address );

                nameAddPane.add(new Label(name), 0, row);
                nameAddPane.add(new Label(phoneNumber), 1, row);
                nameAddPane.add(new Label(address), 2, row);
                
                row++;
            }

            if (row == 1) { // Only headers are present
                nameAddPane.add(new Label("No data found"), 0, row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unexpected error: " + e.getMessage());
        }

        Scene nameScene = new Scene(nameAddPane, 800, 400); 
        stage.setScene(nameScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
