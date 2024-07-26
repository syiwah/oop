// HADHINA SYAHIRA BINTI MUHAMMAD HILMI
// 24000291

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class WindowOrder extends Application {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    @Override
    public void start(Stage stage) {
        // Create UI components
        TextField nameField = new TextField();
        nameField.setPromptText("Client Name");

        TextField addressField = new TextField();
        addressField.setPromptText("Client Address");

        TextField itemField = new TextField();
        itemField.setPromptText("Item");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        Button addButton = new Button("Add Order");
        addButton.setOnAction(event -> handleAddOrder(nameField, addressField, itemField, priceField));

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(new Label("Client Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(new Label("Client Address:"), 0, 1);
        gridPane.add(addressField, 1, 1);

        gridPane.add(new Label("Item:"), 0, 2);
        gridPane.add(itemField, 1, 2);

        gridPane.add(new Label("Price:"), 0, 3);
        gridPane.add(priceField, 1, 3);

        gridPane.add(addButton, 1, 4);

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 250);
        stage.setTitle("Order Window");
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddOrder(TextField nameField, TextField addressField, TextField itemField, TextField priceField) {
        String clientName = nameField.getText().trim();
        String clientAddress = addressField.getText().trim();
        String item = itemField.getText().trim();
        String priceString = priceField.getText().trim();

        if (clientName.isEmpty() || clientAddress.isEmpty() || item.isEmpty() || priceString.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Validation Error", "All fields must be filled.");
            return;
        }

        try {
            double price = Double.parseDouble(priceString);
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            // Create order and client
            Address address = new Address(clientAddress, "", "", ""); // Adjust other fields if needed
            Client client = new Client(clientName, "", address, new ArrayList<>());
            Order order = new Order(item, price, date, time);

            // Add client and order
            order.saveToDatabase(client.getName());

            // Clear fields after adding order
            nameField.clear();
            addressField.clear();
            itemField.clear();
            priceField.clear();

        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid number for price.");
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while accessing the database.");
            e.printStackTrace();
        }
    }


    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
