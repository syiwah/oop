
//INSYIRAH BINTI HAMZAH
// 24000157import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.*;

public class FrontEnd extends Application {
    private static final String URL = "jdbc:mysql://localhost:3306/Java_Chip";
    private static final String USERNAME = "syirahh.hamzah@gmail.com"; 
    private static final String PASSWORD = "Shinystar10@";

    @Override
    public void start(Stage stage) {
        // Create labels for the welcome message
        Label welcomeLabel1 = new Label("Welcome to Java Chip ˗ˏˋ☕ˎˊ˗");
        welcomeLabel1.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        welcomeLabel1.setTextFill(Color.WHITE);

        Label welcomeLabel2 = new Label("How may I help you?");
        welcomeLabel2.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        welcomeLabel2.setTextFill(Color.WHITE);

        // Create buttons for each window
        Button btnNameAddress = new Button("Open Name & Address Window");
        Button btnItem = new Button("Open Item Window");
        Button btnOrder = new Button("Open Order Window");
        Button btnClient = new Button("Open Client Window");
        Button btnMenu = new Button("View Menu");

        // Set event handlers for buttons
        btnNameAddress.setOnAction(this::openNameAddressWindow);
        btnItem.setOnAction(this::openItemWindow);
        btnOrder.setOnAction(this::openOrderWindow);
        btnClient.setOnAction(this::openClientWindow);
        btnMenu.setOnAction(this::openMenuWindow);

        // Create a grid pane for the main window
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(400, 200);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);

        // Add buttons to the pane
        pane.add(btnNameAddress, 0, 0);
        pane.add(btnItem, 0, 1);
        pane.add(btnOrder, 0, 2);
        pane.add(btnClient, 0, 3);
        pane.add(btnMenu, 0, 4);

        // Create a VBox to hold the labels and the grid pane
        VBox vbox = new VBox(10, welcomeLabel1, welcomeLabel2, pane);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: #F2B8C6;"); // prettier shade of pink

        // Set up the scene and stage
        Scene scene = new Scene(vbox, 450, 350);
        stage.setTitle("Main Application");
        stage.setScene(scene);
        stage.show();
    }

    private void openNameAddressWindow(ActionEvent event) {
        WindowNameAddress nameAddress = new WindowNameAddress();
        Stage stage = new Stage();
        nameAddress.start(stage);
    }

    private void openItemWindow(ActionEvent event) {
        WindowItem item = new WindowItem();
        Stage stage = new Stage();
        item.start(stage);
    }

    private void openOrderWindow(ActionEvent event) {
        WindowOrder order = new WindowOrder();
        Stage stage = new Stage();
        order.start(stage);
    }

    private void openClientWindow(ActionEvent event) {
        WindowClient client = new WindowClient();
        Stage stage = new Stage();
        client.start(stage);
    }

    private void openMenuWindow(ActionEvent event) {
        MenuWindow menuWindow = new MenuWindow();
        Stage stage = new Stage();
        menuWindow.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
