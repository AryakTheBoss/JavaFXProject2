package cs213p4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController{


    @FXML

    public void orderCoffee(){
        Parent root = null;
        Stage newWindow = new Stage();
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("OrderCoffee.fxml"));
            newWindow.setTitle("Order Coffee");
            newWindow.setScene(new Scene(root, 431, 488));
            newWindow.setAlwaysOnTop(true);
            newWindow.show();
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
            newWindow.setScene(new Scene(root, 590, 475));
            newWindow.setAlwaysOnTop(true);
            newWindow.show();
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
            newWindow.setScene(new Scene(root, 590, 475));
            newWindow.setAlwaysOnTop(true);
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML

    public void storeOrders(){
        Parent root = null;
        Stage newWindow = new Stage();
        try { //open main menu
            root = FXMLLoader.load(getClass().getResource("StoreOrders.fxml"));
            newWindow.setTitle("Store Orders");
            newWindow.setScene(new Scene(root, 590, 475));
            newWindow.setAlwaysOnTop(true);
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
