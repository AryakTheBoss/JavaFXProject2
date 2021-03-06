package cs213p4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to control the Main Menu GUI
 * @author mss390 amp487
 *
 */
public class MainMenuController{


@FXML private Button orderCoffee;
@FXML private Button buyDonuts;
@FXML private Button myOrder;
@FXML private Button storeOrders;
    private final int WINDOWWIDTH = 479;
    private final int WINDOWHEIGHT = 488;


    /**
     * called by order coffe button
     */
    @FXML
    public void orderCoffee(){ //called by order coffee button
        Parent root = null;
        Stage newWindow = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("OrderCoffee.fxml"));
            newWindow.setTitle("Order Coffee");
            newWindow.setScene(new Scene(root, WINDOWWIDTH, WINDOWHEIGHT));
            newWindow.setResizable(false);
            //disable all buttons
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait(); //show the menu and wait
            //re-enable the buttons once the menu closes
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);

        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unable to open window.");
            a.setHeaderText("idk what happend");
            a.show();
        }
    }

    /**
     * called by order donuts button
     */
    @FXML

    public void orderDonuts(){
        Parent root = null;
        Stage newWindow = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("OrderDonuts.fxml"));
            newWindow.setTitle("Order Donuts");
            newWindow.setScene(new Scene(root, WINDOWWIDTH, WINDOWHEIGHT));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();//show the menu and wait
            //re-enable the buttons once the menu closes
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unable to open window.");
            a.setHeaderText("idk what happend");
            a.show();
        }
    }

    /**
     * called by my order button
     */
    @FXML

    public void myOrder(){
        Parent root = null;
        Stage newWindow = new Stage();
        ArrayList<MenuItem> items = References.customerOrder.getItems();
        if(items.isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Your order is empty. Please add items by clicking on\n Donuts or Coffee.");
            a.setHeaderText("No Items");
            a.show();

            return;
        }
        try {
            root = FXMLLoader.load(getClass().getResource("MyOrder.fxml"));
            newWindow.setTitle("My Order");
            newWindow.setScene(new Scene(root, WINDOWWIDTH, WINDOWHEIGHT));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();//show the menu and wait
            //re-enable the buttons once the menu closes
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unable to open window.");
            a.setHeaderText("idk what happend");
            a.show();
        }
    }

    /**
     * called by store orders button
     */
    @FXML

    public void storeOrders(){
        Parent root = null;
        Stage newWindow = new Stage();
        ArrayList<Order> orders = References.orders.getOrders();
        if(orders.isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("There are currently no Orders!");
            a.setHeaderText("No Orders");
            a.show();

             return;
        }

        try {
            root = FXMLLoader.load(getClass().getResource("StoreOrders.fxml"));
            newWindow.setTitle("Store Orders");
            newWindow.setScene(new Scene(root, WINDOWWIDTH, WINDOWHEIGHT));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();//show the menu and wait
            //re-enable the buttons once the menu closes
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Unable to open window.");
            a.setHeaderText("idk what happend");
            a.show();
        }
    }

}
