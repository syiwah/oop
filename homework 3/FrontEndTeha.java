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
public class FrontEnd extends Application
{
 
  private NameList nlist = new NameList() ;
  private AddressList adlist = new AddressList() ;
   TextField fnametf = new TextField("     ");
   TextField lnametf = new TextField("     ");
   TextField mycity = new TextField("     ");
   TextField mystate = new TextField("     ");
   TextField myzipcode = new TextField("     ");
   
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
       Label fnameLabel = new Label("First Name");
       Label lnameLabel = new Label("Last Name");
       Label cityLabel = new Label("City");
       Label stateLabel = new Label("State");
       Label zipcodeLabel = new Label("Zipcode");
 
 
 
       
       // Create a new grid pane
       GridPane pane = new GridPane();
       pane.setPadding(new Insets(10, 10, 10, 10));
       pane.setMinSize(300, 300);
       pane.setVgap(10);
       pane.setHgap(10);
 
       //set an action on the button using method reference
       okButton.setOnAction(this::buttonClick);
 
       // Add the button and label into the pane
       pane.add(fnameLabel, 0, 0);
       pane.add(fnametf, 1, 0);
       pane.add(lnameLabel, 0, 1);
       pane.add(lnametf, 1, 1);
       pane.add(cityLabel, 0, 2);
       pane.add(mycity, 1, 2);
       pane.add(stateLabel, 0, 3);
       pane.add(mystate, 1, 3);
       pane.add(zipcodeLabel, 0, 4);
       pane.add(myzipcode, 1, 4);
       pane.add(okButton, 0,5);
       pane.add(cancelButton, 1,5);
       
 
       // JavaFX must have a Scene (window content) inside a Stage (window)
       Scene scene = new Scene(pane, 300,100);
       stage.setTitle("JavaFX Example");
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
       String fname = fnametf.getText();
       String lname = lnametf.getText();    
       Name newname = new Name(fname, lname);
nlist.addName(newname);
 
 
       
       String city = mycity.getText();
       String state = mystate.getText();
       String zipcode = myzipcode.getText();
Address newaddress = new Address(city,state,zipcode);
adlist.addAddress(newaddress);
 
   
           }
}
