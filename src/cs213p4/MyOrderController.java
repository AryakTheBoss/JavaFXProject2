package cs213p4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Ref;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyOrderController {

    @FXML private ListView<String> listOfOrders;
    @FXML private TextField subtotal;
    @FXML private TextField tax;
    @FXML private TextField total;
    @FXML private TextField orderNumber;

    private DecimalFormat format = new DecimalFormat("$#,##0.00");
//TODO price bugs need to fix
    @FXML
    public void initialize(){

        ArrayList<MenuItem> mi = References.customerOrder.getItems();
        for(MenuItem i : mi) {
            listOfOrders.getItems().add(i.toString());
        }
        subtotal.setText(format.format(References.customerOrder.orderSubTotal()));
        total.setText(format.format(References.customerOrder.orderTotal()));
        tax.setText(format.format((Order.SALES_TAX-1)*References.customerOrder.orderSubTotal()));
        orderNumber.setText("Your Order#: "+References.customerOrder.getOrderNumber());
    }

    @FXML
    public void remove(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        int index = listOfOrders.getSelectionModel().getSelectedIndex();
        if(index == -1){
            a.setContentText("You did not select an item!");
            a.setHeaderText("No item selected");
            a.show();
            return;
        }
        ArrayList<MenuItem> mi = References.customerOrder.getItems();
        mi.remove(index);
        References.customerOrder.setItems(mi);
        mi = References.customerOrder.getItems();
        listOfOrders.getItems().clear();
        for(MenuItem i : mi) {
            listOfOrders.getItems().add(i.toString());
        }
        subtotal.setText(format.format(References.customerOrder.orderSubTotal()));
        total.setText(format.format(References.customerOrder.orderTotal()));
        tax.setText(format.format((Order.SALES_TAX-1)*References.customerOrder.orderSubTotal()));

    }

    @FXML
    public void placeOrder(){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        if(References.customerOrder.getItems().isEmpty()){
            a.setAlertType(Alert.AlertType.WARNING);
            a.setContentText("Order is empty!");
            a.setHeaderText("No items");
            a.show();
            return;
        }
        References.orders.add(References.customerOrder);
        //alert that it was added
        References.customerOrder = new Order();
        a.setContentText("Order was placed.");
        a.setHeaderText("Placed");
        a.showAndWait();
        //close window
        Stage stage = (Stage) listOfOrders.getScene().getWindow(); //get the current stage

        stage.close(); //close it
    }


}
