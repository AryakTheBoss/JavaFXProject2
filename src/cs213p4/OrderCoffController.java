package cs213p4;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderCoffController {

    @FXML private ChoiceBox<Size> sizeBox;
    @FXML private CheckBox creamCB;
    @FXML private CheckBox syrupCB;
    @FXML private CheckBox caramelCB;
    @FXML private CheckBox milkCB;
    @FXML private CheckBox whpcreamCB;
    @FXML private Spinner<Integer> qty;
    @FXML private ListView<String> coffeeList;
    @FXML private TextField totalBox;
    @FXML private TextField currentTotal;
    @FXML private Button addToOrder;

    private ArrayList<Coffee> coffees = new ArrayList<>();
    private Coffee currentCoffee = null;
    private DecimalFormat format = new DecimalFormat("$#,##0.00");


    @FXML
    public void initialize(){
       sizeBox.getItems().add(Size.SHORT);
        sizeBox.getItems().add(Size.TALL);
        sizeBox.getItems().add(Size.GRANDE);
        sizeBox.getItems().add(Size.VENTI);
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
        qty.setValueFactory(valueFactory);
        qty.getValueFactory().setValue(1);
        totalBox.setText("$0.00");
        currentTotal.setText("$0.00");
        coffeeList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        creamCB.setDisable(true);
        syrupCB.setDisable(true);
        caramelCB.setDisable(true);
        milkCB.setDisable(true);
        whpcreamCB.setDisable(true);

        sizeBox.setOnAction((event) -> {
            int selectedIndex = sizeBox.getSelectionModel().getSelectedIndex();
            Size selectedItem = sizeBox.getSelectionModel().getSelectedItem();
            creamCB.setDisable(false);
            syrupCB.setDisable(false);
            caramelCB.setDisable(false);
            milkCB.setDisable(false);
            whpcreamCB.setDisable(false);
            if(currentCoffee != null){ //TODO update currentTotal box
                currentCoffee.setSize(selectedItem);
            }else{
                currentCoffee = new Coffee(selectedItem,1);
            }
            currentTotal.setText(format.format(currentCoffee.itemPrice()));
        });
        qty.valueProperty().addListener((obs, oldValue, newValue) -> {
            if(currentCoffee != null){ //TODO update currentTotal Box
                currentCoffee.setQuantity(newValue);
            }else{
                currentCoffee = new Coffee(null,newValue);
            }
            currentTotal.setText(format.format(currentCoffee.itemPrice()));
        });

        creamCB.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

                    if(new_val) { //if the new value is TRUE
                        currentCoffee.add(AddIns.CREAM);
                    }else{ //if the new value is FALSE
                        currentCoffee.remove(AddIns.CREAM);
                    }
                    currentTotal.setText(format.format(currentCoffee.itemPrice()));
                });

        syrupCB.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

                    if(new_val) { //if the new value is TRUE
                        currentCoffee.add(AddIns.SYRUP);
                    }else{ //if the new value is FALSE
                        currentCoffee.remove(AddIns.SYRUP);
                    }
                    currentTotal.setText(format.format(currentCoffee.itemPrice()));
                });

        caramelCB.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {


                    if(new_val) { //if the new value is TRUE
                        currentCoffee.add(AddIns.CARAMEL);
                    }else{ //if the new value is FALSE
                        currentCoffee.remove(AddIns.CARAMEL);
                    }
                    currentTotal.setText(format.format(currentCoffee.itemPrice()));
                });

        milkCB.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

                    if(new_val) { //if the new value is TRUE
                        currentCoffee.add(AddIns.MILK);
                    }else{ //if the new value is FALSE
                        currentCoffee.remove(AddIns.MILK);
                    }
                    currentTotal.setText(format.format(currentCoffee.itemPrice()));
                });

        whpcreamCB.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {

                    if(new_val) { //if the new value is TRUE
                        currentCoffee.add(AddIns.WHIPPED_CREAM);
                    }else{ //if the new value is FALSE
                        currentCoffee.remove(AddIns.WHIPPED_CREAM);
                    }
                    currentTotal.setText(format.format(currentCoffee.itemPrice()));
                });





    }

    @FXML
    public void add(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(sizeBox.getSelectionModel().getSelectedItem() == null){
            a.setContentText("You did not select a size!");
            a.setHeaderText("No Size selected");
            a.show();
            return;
        }
        coffees.add(currentCoffee);
        coffeeList.getItems().add(currentCoffee.toString());

        currentCoffee = null;
        totalBox.setText(format.format(getTotal()));
        clearForm();
    }
    private float getTotal(){
         float total = 0;
        for (Coffee coffee : coffees) {
            total += coffee.itemPrice();
        }
        return total;
    }

    @FXML
    public void remove(){
       coffees.remove(coffeeList.getSelectionModel().getSelectedIndex());
       coffeeList.getItems().remove(coffeeList.getSelectionModel().getSelectedIndex());
        totalBox.setText(format.format(getTotal()));
    }

    private void clearForm(){
        sizeBox.getSelectionModel().clearSelection();
        creamCB.selectedProperty().set(false);
        syrupCB.selectedProperty().set(false);
        caramelCB.selectedProperty().set(false);
        milkCB.selectedProperty().set(false);
        whpcreamCB.selectedProperty().set(false);
        creamCB.setDisable(true);
        syrupCB.setDisable(true);
        caramelCB.setDisable(true);
        milkCB.setDisable(true);
        whpcreamCB.setDisable(true);
        qty.getValueFactory().setValue(1);
        currentTotal.setText("$0.00");
    }

    @FXML
    public void addOrder(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(coffees.isEmpty()){
            a.setContentText("There are no Coffees in the list! try hitting \">>\"");
            a.setHeaderText("No Coffees");
            a.show();
            return;
        }

        for (Coffee coffee : coffees) {
            References.customerOrder.add(coffee);
        }
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("All coffees were added to the Order!");
        a.setHeaderText("Added to Order");
        a.showAndWait();
        Stage stage = (Stage) addToOrder.getScene().getWindow();

        stage.close();
    }

}
