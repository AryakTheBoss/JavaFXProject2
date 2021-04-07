package cs213p4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Class to control the Store Orders GUI
 * @author mss390 amp487
 *
 */
public class StoreOrdersController {

    @FXML private ComboBox<Integer> orderNum;
    @FXML private TextField total;
    @FXML private ListView<String> ordersList;
    private DecimalFormat format = new DecimalFormat("$#,##0.00");
    private final int FIRSTINDEX = 0;

    /**
     * initialize the menu with teh 1st order selected by default and populating the list
     */
    @FXML
    public void initialize(){
        ArrayList<Order> orders = References.orders.getOrders();
        total.setText("$0.00");

        for(Order o:orders){
            orderNum.getItems().add(o.getOrderNumber());
        }

        orderNum.getSelectionModel().select(FIRSTINDEX); //select 1st index by default
        ArrayList<Order> temp = References.orders.getOrders();
        ordersList.getItems().clear();

            for (MenuItem mi : temp.get(FIRSTINDEX).getItems()) { //populate the list of items using the first index
                ordersList.getItems().add(mi.toString());
            }
            total.setText(format.format(temp.get(FIRSTINDEX).orderTotal()));



    }

    /**
     * cancels the current order that is selected i.e. removes it from the store orders list
     */
    @FXML
    public void cancel(){
        //culture
        ArrayList<Order> orders = References.orders.getOrders();
        if(orders.isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("There are currently no Orders!");
            a.setHeaderText("No Orders");
            a.show();
            return;
        }
        int save = orderNum.getSelectionModel().getSelectedItem();
        ArrayList<Order> temp = References.orders.getOrders();
        for(int i = 0;i<temp.size();i++){
            if(temp.get(i).getOrderNumber() == save){
                try {
                    ordersList.getItems().clear();
                    temp.remove(i);
                    orderNum.getItems().clear();
                    for (Order o : temp) {
                        orderNum.getItems().add(o.getOrderNumber());
                    }
                    orderNum.getSelectionModel().select(FIRSTINDEX);

                    References.orders.setOrders(temp);
                }catch(IndexOutOfBoundsException | NullPointerException e){
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("There are no more Orders left!");
                    a.setHeaderText("No Orders");
                    a.show();
                    Stage stage = (Stage) orderNum.getScene().getWindow(); //get the current stage

                    stage.close(); //close it
                    return;
                }
                break;

            }
        }
       temp = References.orders.getOrders();
        if(temp.isEmpty()){
            total.setText("$0.00");
        }
    }

    /**
     * exports all orders and writes them to a text file using a file chooser
     */
    @FXML
    public void exportOrder(){
        ArrayList<Order> orders = References.orders.getOrders();
        if(orders.isEmpty()){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("There are currently no Orders!");
            a.setHeaderText("No Orders");
            a.show();
            return;
        }
        FileChooser dialog = new FileChooser();
        dialog.setInitialFileName("store_orders.txt");
        dialog.setTitle("Export Orders");
        File f = dialog.showSaveDialog(orderNum.getScene().getWindow()); //open the dialog


            try {
                if(f.createNewFile()){
                    //file created successfully, write the stuff
                    FileWriter myWriter = new FileWriter(f); //filewriter to write to a file
                    ArrayList<Order> temp = References.orders.getOrders();
                    for(Order o : temp){//for each order, write to file

                            myWriter.write(o.toString()); //convert their information to string
                            myWriter.write("\n"); //write a new line to file

                    }
                    myWriter.flush(); //close and write to the file
                    myWriter.close();
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("File was saved.");
                    a.setHeaderText("Done.");
                    a.show();

                }else{ //file could not be created
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setContentText("File already exists.");
                    a.setHeaderText("Error");
                    a.show();
                }
            } catch (IOException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("There was an IO Error.");
                a.setHeaderText("Error");
                a.show();
            }


    }

    /**
     * called by the order number combo box. refreshes the item list based on what order is selected.
     */
    @FXML
    public void changeOrderList(){
        try {
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
        }catch(NullPointerException e){
            // nothing
        }


    }

}
