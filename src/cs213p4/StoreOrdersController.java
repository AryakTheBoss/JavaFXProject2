package cs213p4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class StoreOrdersController {

    @FXML private ComboBox<Integer> orderNum;
    @FXML private TextField total;
    @FXML private ListView<String> ordersList;
    private DecimalFormat format = new DecimalFormat("$#,##0.00");
    private final int FIRSTINDEX = 0;

    @FXML
    public void initialize(){
        ArrayList<Order> orders = References.orders.getOrders();
        total.setText("$0.00");
        if(orders.isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("There are currently no Orders!");
            a.setHeaderText("No Orders");
            a.showAndWait();
            Stage stage = (Stage) ordersList.getScene().getWindow(); //get the current stage
            stage.close(); //close it
            return;
        }
        for(Order o:orders){
            orderNum.getItems().add(o.getOrderNumber());
        }

        orderNum.getSelectionModel().select(FIRSTINDEX);
        ArrayList<Order> temp = References.orders.getOrders();
        ordersList.getItems().clear();
        for(MenuItem mi: temp.get(FIRSTINDEX).getItems()){
            ordersList.getItems().add(mi.toString());
        }

        total.setText(format.format(temp.get(FIRSTINDEX).orderTotal()));
    }

    @FXML
    public void cancel(){
        //culture
        int save = orderNum.getSelectionModel().getSelectedItem();
        ArrayList<Order> temp = References.orders.getOrders();
        for(int i = 0;i<temp.size();i++){
            if(temp.get(i).getOrderNumber() == save){
                ordersList.getItems().clear();
                temp.remove(i);
                orderNum.getSelectionModel().select(FIRSTINDEX);
                for(MenuItem mi: temp.get(FIRSTINDEX).getItems()){
                    ordersList.getItems().add(mi.toString());
                }
            }
        }
    }

    @FXML
    public void exportOrder(){

    }

    @FXML
    public void changeOrderList(){
        int save = orderNum.getSelectionModel().getSelectedItem();
        ArrayList<Order> temp = References.orders.getOrders();
        for(int i = 0;i<temp.size();i++){
            if(temp.get(i).getOrderNumber() == save){
                ordersList.getItems().clear();
                for(MenuItem mi: temp.get(i).getItems()){
                    ordersList.getItems().add(mi.toString());
                }
                total.setText(format.format(temp.get(i).orderTotal()));
            }
        }

    }

}
