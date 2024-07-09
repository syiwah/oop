import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of JavaFX class FrontEndInsyi here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FrontEndInsyi extends Application {

    private TextField fnametf = new TextField();
    private TextField lnametf = new TextField();
    private TextField phonetf = new TextField();
    private TextField addresstf = new TextField();
    private TextField ordertf = new TextField();
    private TextArea outputtf = new TextArea();

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
        Label fnamelbl = new Label("First Name:");
        grid.add(fnamelbl, 0, 0);
        grid.add(fnametf, 1, 0);

        Label lnamelbl = new Label("Last Name:");
        grid.add(lnamelbl, 0, 1);
        grid.add(lnametf, 1, 1);

        Label phonelbl = new Label("Phone Number:");
        grid.add(phonelbl, 0, 2);
        grid.add(phonetf, 1, 2);

        Label addresslbl = new Label("Address:");
        grid.add(addresslbl, 0, 3);
        grid.add(addresstf, 1, 3);

        Label orderlbl = new Label("Order Item:");
        grid.add(orderlbl, 0, 4);
        grid.add(ordertf, 1, 4);

        Button addButton = new Button("Add Client");
        grid.add(addButton, 0, 5);

        Button removeButton = new Button("Remove Client");
        grid.add(removeButton, 1, 5);

        Button printButton = new Button("Print Clients Details");
        grid.add(printButton, 0, 6);

        grid.add(outputtf, 0, 7, 2, 1);
        outputtf.setPrefHeight(200);

        // Set event handlers
        addButton.setOnAction(this::handleAddClient);
        removeButton.setOnAction(this::handleRemoveClient);
        printButton.setOnAction(this::handlePrintClientsDetails);

        stage.setTitle("Insyi");
        Scene scene = new Scene(grid, 400, 450);
        stage.setScene(scene);
        stage.show();
    }

    private void handleAddClient(javafx.event.ActionEvent event) {
        addClient();
    }

    private void handleRemoveClient(javafx.event.ActionEvent event) {
        removeClient();
    }

    private void handlePrintClientsDetails(javafx.event.ActionEvent event) {
        printClientsDetails();
    }

    private void addClient() {
        String fName = fnametf.getText();
        String lName = lnametf.getText();
        String phoneNumber = phonetf.getText();
        Clients.Address address = new Clients.Address(addresstf.getText());
        List<Clients.Order> orders = new ArrayList<>();

        Clients.Client client = new Clients.Client(fName + " " + lName, phoneNumber, orders, address);
        clients.addClient(client);
        clearFields();
    }

    private void removeClient() {
        String fname = fnametf.getText();
        String lname = lnametf.getText();
        clients.removeClient(fname + " " + lname);
        clearFields();
    }

    private void printClientsDetails() {
        outputtf.setText(clients.getClientsDetails());
    }

    private void clearFields() {
        fnametf.clear();
        lnametf.clear();
        phonetf.clear();
        addresstf.clear();
        ordertf.clear();
    }
}
