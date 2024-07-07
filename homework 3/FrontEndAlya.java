import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * Write a description of JavaFX class FrontEnd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FrontEndAlya extends Application
{
    // We keep track of the count, and label displaying the count:
    private Items rlist = new Items();
    TextField nametf = new TextField("     ");
    TextField supplierPricetf = new TextField("     ");
    TextField quantitytf = new TextField("     ");
    TextField supplierNametf = new TextField("     ");
    
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        // Create a Button or any control item
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Cancel");
        Label nameLabel = new Label("Name");
        Label supplierPriceLabel = new Label("Supplier Price");
        Label quantityLabel = new Label("Quantity");
        Label supplierNameLabel = new Label("Supplier Name");
        
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        okButton.setOnAction(this::buttonClick);
        cancelButton.setOnAction(this::buttonClick);

        // Add the button and label into the pane
        pane.add(nameLabel, 0, 0);
        pane.add(nametf, 1, 0);
        pane.add(supplierPriceLabel, 0, 1);
        pane.add(supplierPricetf, 1, 1);
        pane.add(quantityLabel, 0, 2);
        pane.add(quantitytf, 1, 2);
        pane.add(supplierNameLabel, 0, 3);
        pane.add(supplierNametf, 1, 3);
        pane.add(okButton, 0,4);
        pane.add(cancelButton, 1,4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,200);
        stage.setTitle("Alya");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        String name = nametf.getText();
        String supplierPrice = supplierPricetf.getText();
        String quantity = quantitytf.getText();
        String supplierName = supplierNametf.getText();    
        Item newItem = new Item(name, supplierPrice, quantity, supplierName);
        
        rlist.add(newItem);
    }
}
