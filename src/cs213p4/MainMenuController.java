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


    @FXML
    public void orderCoffee(){
        Parent root = null;
        Stage newWindow = new Stage();
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("OrderCoffee.fxml"));
            newWindow.setTitle("Order Coffee");
            newWindow.setScene(new Scene(root, 479, 488));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML

    public void orderDonuts(){
        Parent root = null;
        Stage newWindow = new Stage();
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("OrderDonuts.fxml"));
            newWindow.setTitle("Order Donuts");
            newWindow.setScene(new Scene(root, 479, 488));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML

    public void myOrder(){
        Parent root = null;
        Stage newWindow = new Stage();
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("MyOrder.fxml"));
            newWindow.setTitle("My Order");
            newWindow.setScene(new Scene(root, 479, 488));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("StoreOrders.fxml"));
            newWindow.setTitle("Store Orders");
            newWindow.setScene(new Scene(root, 590, 475));
            newWindow.setResizable(false);
            orderCoffee.setDisable(true);
            buyDonuts.setDisable(true);
            myOrder.setDisable(true);
            storeOrders.setDisable(true);
            newWindow.showAndWait();
            orderCoffee.setDisable(false);
            buyDonuts.setDisable(false);
            myOrder.setDisable(false);
            storeOrders.setDisable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
