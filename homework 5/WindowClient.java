// INSYIRAH BINTI HAMZAH
// 24000157
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class WindowClient extends Application {
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

        // Set up the scene and stage
        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Client Window");
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddClient(String name, String phone, String street, String city, String state, String zipcode) {
        // Your existing code for adding a client to the database and showing alerts
    }

    // Other methods for handling database operations, alerts, and main method
}