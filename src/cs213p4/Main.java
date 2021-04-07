package cs213p4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



/**
 * Main class
 * @author mss390 amp487
 *
 */
public class Main extends Application {

    private final int WINDOWWIDTH = 590;
    private final int WINDOWHEIGHT = 475;

    /**
     * begin the program
     * @param args String arguments (none)
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * method to start the program
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        Parent root = null;
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            primaryStage.setTitle("RU Cafe");
            primaryStage.setScene(new Scene(root, WINDOWWIDTH, WINDOWHEIGHT));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

