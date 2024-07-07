import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class FrontEndInsyi extends Application {

    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField phoneField = new TextField();
    private TextField addressField = new TextField();
    private TextField orderField = new TextField();
    private TextArea outputArea = new TextArea();

    private Clients clients = new Clients();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Create UI components
        Label firstNameLabel = new Label("First Name:");
        GridPane.setConstraints(firstNameLabel, 0, 0);
        GridPane.setConstraints(firstNameField, 1, 0);

        Label lastNameLabel = new Label("Last Name:");
        GridPane.setConstraints(lastNameLabel, 0, 1);
        GridPane.setConstraints(lastNameField, 1, 1);

        Label phoneLabel = new Label("Phone Number:");
        GridPane.setConstraints(phoneLabel, 0, 2);
        GridPane.setConstraints(phoneField, 1, 2);

        Label addressLabel = new Label("Address:");
        GridPane.setConstraints(addressLabel, 0, 3);
        GridPane.setConstraints(addressField, 1, 3);

        Label orderLabel = new Label("Order Item:");
        GridPane.setConstraints(orderLabel, 0, 4);
        GridPane.setConstraints(orderField, 1, 4);

        Button addButton = new Button("Add Client");
        GridPane.setConstraints(addButton, 0, 5);

        Button removeButton = new Button("Remove Client");
        GridPane.setConstraints(removeButton, 1, 5);

        Button printButton = new Button("Print Clients Details");
        GridPane.setConstraints(printButton, 0, 6);

        GridPane.setConstraints(outputArea, 0, 7, 2, 1);
        outputArea.setPrefHeight(200);

        // Add components to the grid
        grid.getChildren().addAll(firstNameLabel, firstNameField, lastNameLabel, lastNameField,
                phoneLabel, phoneField, addressLabel, addressField, orderLabel, orderField,
                addButton, removeButton, printButton, outputArea);

        addButton.setOnAction(event -> addClient());
        removeButton.setOnAction(event -> removeClient());
        printButton.setOnAction(event -> printClientsDetails());

        stage.setTitle("Insyi");
        Scene scene = new Scene(grid, 400, 450);
        stage.setScene(scene);
        stage.show();
    }

    private void addClient() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneField.getText();
        Clients.Address address = new Clients.Address(addressField.getText());
        List<Clients.Order> orders = new ArrayList<>();

        Clients.Client client = new Clients.Client(firstName + " " + lastName, phoneNumber, orders, address);
        clients.addClient(client);
        clearFields();
    }

    private void removeClient() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        clients.removeClient(firstName + " " + lastName);
        clearFields();
    }

    private void printClientsDetails() {
        outputArea.setText(clients.getClientsDetails());
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        phoneField.clear();
        addressField.clear();
        orderField.clear();
    }
}
