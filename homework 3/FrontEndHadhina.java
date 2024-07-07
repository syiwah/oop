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
public class FrontEndHadhina extends Application
{
    private Orders orderCatalog = new Orders();
    TextField itemtf = new TextField("        ");
    TextField pricetf = new TextField("        ");
    TextField datetf = new TextField("        ");
    TextField timetf = new TextField("        ");

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
        Label itemLabel = new Label("Item:");
        Label priceLabel = new Label("Price:");
        Label dateLabel = new Label("Date:");
        Label timeLabel = new Label("Time:");

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
        pane.add(itemLabel, 0, 0);
        pane.add(itemtf, 2, 0);
        pane.add(priceLabel, 0, 1);
        pane.add(pricetf, 2, 1);
        pane.add(dateLabel, 0, 2);
        pane.add(datetf, 2, 2);
        pane.add(timeLabel, 0, 3);
        pane.add(timetf, 2, 3);
        pane.add(okButton, 0, 4);
        pane.add(cancelButton, 3, 4);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("Hadhina");
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
        String item = itemtf.getText();
        String price = pricetf.getText(); 
        String date = datetf.getText();
        String time = timetf.getText();
        Order newOrder = new Order(item,price,date,time);
        orderCatalog.add(newOrder);
        
    }
}


