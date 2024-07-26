// INSYIRAH BINTI HAMZAH
// 24000157
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WindowClient extends Application {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com";
    private static final String PASSWORD = "Shinystar10@";

    @Override
    public void start(Stage stage) {
        // Create UI components
        TextField nameField = new TextField();
        nameField.setPromptText("Client Name");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Phone Number");

        TextField streetField = new TextField();
        streetField.setPromptText("Street");

        TextField cityField = new TextField();
        cityField.setPromptText("City");

        TextField stateField = new TextField();
        stateField.setPromptText("State");

        TextField zipcodeField = new TextField();
        zipcodeField.setPromptText("Zipcode");

        Button addButton = new Button("Add Client");
        addButton.setOnAction(event -> handleAddClient(
                nameField.getText(),
                phoneField.getText(),
                streetField.getText(),
                cityField.getText(),
                stateField.getText(),
                zipcodeField.getText()
        ));
        
        Button removeButton = new Button("Remove Client");
        removeButton.setOnAction(event -> handleRemoveClient(nameField.getText()));

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(new Label("Client Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);

        gridPane.add(new Label("Phone Number:"), 0, 1);
        gridPane.add(phoneField, 1, 1);

        gridPane.add(new Label("Street:"), 0, 2);
        gridPane.add(streetField, 1, 2);

        gridPane.add(new Label("City:"), 0, 3);
        gridPane.add(cityField, 1, 3);

        gridPane.add(new Label("State:"), 0, 4);
        gridPane.add(stateField, 1, 4);

        gridPane.add(new Label("Zipcode:"), 0, 5);
        gridPane.add(zipcodeField, 1, 5);

        gridPane.add(addButton, 1, 6);
        gridPane.add(removeButton, 1, 7);

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 350);
        stage.setTitle("Client Window");
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddClient(String name, String phone, String street, String city, String state, String zipcode) {
        String insertAddressSQL = "INSERT INTO addresses (street, city, state, zipcode) VALUES (?, ?, ?, ?)";
        String insertClientSQL = "INSERT INTO clients (name, phone_number, address_id) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(false); // Start transaction

            // Insert address
            try (PreparedStatement pstmtAddress = connection.prepareStatement(insertAddressSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmtAddress.setString(1, street);
                pstmtAddress.setString(2, city);
                pstmtAddress.setString(3, state);
                pstmtAddress.setString(4, zipcode);
                pstmtAddress.executeUpdate();

                // Retrieve generated address ID
                ResultSet generatedKeys = pstmtAddress.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int addressId = generatedKeys.getInt(1);

                    // Insert client with address ID
                    try (PreparedStatement pstmtClient = connection.prepareStatement(insertClientSQL)) {
                        pstmtClient.setString(1, name);
                        pstmtClient.setString(2, phone);
                        pstmtClient.setInt(3, addressId);
                        pstmtClient.executeUpdate();

                        connection.commit(); // Commit transaction
                        showAlert(Alert.AlertType.INFORMATION, "Success", "Client added successfully!");
                    }
                } else {
                    connection.rollback(); // Rollback transaction if no address ID was retrieved
                    showAlert(Alert.AlertType.ERROR, "Database Error", "Failed to retrieve address ID.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error adding client to database: " + e.getMessage());
        }
    }

    private void handleRemoveClient(String name) {
        String selectClientSQL = "SELECT id, address_id FROM clients WHERE name = ?";
        String deleteClientSQL = "DELETE FROM clients WHERE id = ?";
        String deleteAddressSQL = "DELETE FROM addresses WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(false); // Start transaction

            try (PreparedStatement pstmtSelect = connection.prepareStatement(selectClientSQL)) {
                pstmtSelect.setString(1, name);
                ResultSet resultSet = pstmtSelect.executeQuery();

                if (resultSet.next()) {
                    int clientId = resultSet.getInt("id");
                    int addressId = resultSet.getInt("address_id");

                    // Delete client
                    try (PreparedStatement pstmtDeleteClient = connection.prepareStatement(deleteClientSQL)) {
                        pstmtDeleteClient.setInt(1, clientId);
                        pstmtDeleteClient.executeUpdate();
                    }

                    // Delete address
                    try (PreparedStatement pstmtDeleteAddress = connection.prepareStatement(deleteAddressSQL)) {
                        pstmtDeleteAddress.setInt(1, addressId);
                        pstmtDeleteAddress.executeUpdate();
                    }

                    connection.commit(); // Commit transaction
                    showAlert(Alert.AlertType.INFORMATION, "Success", "Client removed successfully!");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error", "Client not found.");
                }
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error removing client from database: " + e.getMessage());
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
