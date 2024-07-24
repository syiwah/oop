//NUR ALYA SYAZWINA BINTI SAMSUL BAHRIN
//24000088

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.control.*;

public class WindowItem extends Application {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";

    
    private Items rlist = new Items();
    private TextField nametf = new TextField();
    private TextField supplierPricetf = new TextField();
    private TextField quantitytf = new TextField();
    private TextField supplierNametf = new TextField();

    @Override
    public void start(Stage stage) {
        // Create UI components
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        Label nameLabel = new Label("Name");
        Label supplierPriceLabel = new Label("Supplier Price");
        Label quantityLabel = new Label("Quantity");
        Label supplierNameLabel = new Label("Supplier Name");

        // Create layout
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        // Set actions for buttons
        okButton.setOnAction(this::handleOkButton);
        cancelButton.setOnAction(this::handleCancelButton);

        // Add components to layout
        pane.add(nameLabel, 0, 0);
        pane.add(nametf, 1, 0);
        pane.add(supplierPriceLabel, 0, 1);
        pane.add(supplierPricetf, 1, 1);
        pane.add(quantityLabel, 0, 2);
        pane.add(quantitytf, 1, 2);
        pane.add(supplierNameLabel, 0, 3);
        pane.add(supplierNametf, 1, 3);
        pane.add(okButton, 0, 4);
        pane.add(cancelButton, 1, 4);

        // Set up scene and stage
        Scene scene = new Scene(pane);
        stage.setTitle("Item");
        stage.setScene(scene);
        stage.show();
    }

    private void handleOkButton(ActionEvent event) {
        try {
            String name = nametf.getText().trim();
            double supplierPrice = Double.parseDouble(supplierPricetf.getText().trim());
            int quantity = Integer.parseInt(quantitytf.getText().trim());
            String supplierName = supplierNametf.getText().trim();

            Item newItem = new Item(name, supplierPrice, quantity, supplierName);
            rlist.add(newItem);

            // Clear fields
            nametf.clear();
            supplierPricetf.clear();
            quantitytf.clear();
            supplierNametf.clear();

        } catch (NumberFormatException e) {
            // Handle invalid number format
            showAlert("Invalid Input", "Please enter valid numbers for price and quantity.");
        }
    }

    private void handleCancelButton(ActionEvent event) {
        // Close the window or clear fields
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        // Display an alert dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
