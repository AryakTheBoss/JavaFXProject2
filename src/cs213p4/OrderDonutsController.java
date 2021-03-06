package cs213p4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * Class to control the Order Donut GUI
 * @author mss390 amp487
 *
 */
public class OrderDonutsController {

    private ToggleGroup typeGroup = new ToggleGroup();

    @FXML private RadioButton yeastRB;
    @FXML private RadioButton cakeRB;
    @FXML private RadioButton holeRB;
    @FXML private ChoiceBox<Flavor> flavorBox; //THIS IS A CHOICE BOX, COMBO BOX IS USED IN STORE ORDERS CONTROLLER (no time to chaneg this)
    @FXML private Spinner<Integer> qty;
    @FXML private TextField currentTotalBox;
    @FXML private TextField totalBox;
    @FXML private ListView<String> donutList;
    @FXML private Button addO;

    private ArrayList<Donut> donuts = new ArrayList<>();
    private Donut currentDonut = null;
    private DecimalFormat format = new DecimalFormat("$#,##0.00");
    private final int DEFAULT = 1;
    private final int DOESNOTEXIST = -1;
    private final int NONE = 0;
    private final int QTY_MIN = 1;
    private final int QTY_MAX = 100;

    /**
     * initialize the menu
     */
    @FXML
    public void initialize(){
        yeastRB.setToggleGroup(typeGroup);
        cakeRB.setToggleGroup(typeGroup); //add radios to a type group
        holeRB.setToggleGroup(typeGroup);
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(QTY_MIN, QTY_MAX); //set the qty box range to something between 1 and 100
        qty.setValueFactory(valueFactory);
        qty.getValueFactory().setValue(DEFAULT); //set default value, it is not editable
        currentTotalBox.setText("$0.00");
        totalBox.setText("$0.00");
        flavorBox.setDisable(true);
        qty.valueProperty().addListener((obs, oldValue, newValue) -> {
            if(currentDonut != null){
                currentDonut.setQuantity(newValue);
            }else{
                currentDonut = new Donut(null,null,newValue);
            }
            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
        });

        typeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)typeGroup.getSelectedToggle(); //get currently selected button

                if (rb != null) {
                    String s = rb.getId();
                    switch (s) {
                        case "yeastRB": //if yeast is selected
                            flavorBox.getSelectionModel().clearSelection();
                            flavorBox.getItems().clear();
                            flavorBox.getItems().add(Flavor.BLUEBERRY);
                            flavorBox.getItems().add(Flavor.STRAWBERRY);
                            flavorBox.getItems().add(Flavor.PLAIN);
                            if(currentDonut != null) {
                                currentDonut.setType(DonutType.YEAST);
                            }else{
                                currentDonut = new Donut(DonutType.YEAST,null,DEFAULT);
                            }
                            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
                            flavorBox.setDisable(false);
                            break;
                        case "cakeRB": //if cake is selected
                            flavorBox.getSelectionModel().clearSelection();
                            flavorBox.getItems().clear();
                            flavorBox.getItems().add(Flavor.CHOCOLATE_FROSTED);
                            flavorBox.getItems().add(Flavor.MAPLE_SYRUP_FROSTED);
                            flavorBox.getItems().add(Flavor.JELLY_FILLED);
                            flavorBox.getItems().add(Flavor.BOSTON_CREAM);
                            if(currentDonut != null) {
                                currentDonut.setType(DonutType.CAKE);
                            }else{
                                currentDonut = new Donut(DonutType.CAKE,null,DEFAULT);
                            }
                            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
                            flavorBox.setDisable(false);
                            break;
                        case "holeRB": //if donut hole is selected
                            flavorBox.getSelectionModel().clearSelection();
                            flavorBox.getItems().clear();
                            flavorBox.getItems().add(Flavor.GLAZED);
                            flavorBox.getItems().add(Flavor.POWDERED_SUGAR);
                            flavorBox.getItems().add(Flavor.DOUBLE_CHOCOLATE);
                            if(currentDonut != null) {
                                currentDonut.setType(DonutType.DONUT_HOLE);
                            }else{
                                currentDonut = new Donut(DonutType.DONUT_HOLE,null,DEFAULT);
                            }
                            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
                            flavorBox.setDisable(false);
                            break;
                    }

                }
            }
        });

    }

    /**
     * adds the donut to the list
     */
    @FXML
    public void add(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(flavorBox.getSelectionModel().getSelectedItem() == null){
            a.setContentText("You did not select a flavor!");
            a.setHeaderText("No flavor selected");
            a.show();
            return;
        }
        if(!typeGroup.getSelectedToggle().isSelected()){
            a.setContentText("You did not select a type!");
            a.setHeaderText("No type selected");
            a.show();
            return;
        }
        currentDonut.setFlavor(flavorBox.getSelectionModel().getSelectedItem());
        donuts.add(currentDonut); //add the coffee to the internal arraylist
        donutList.getItems().add(currentDonut.toString()); //add to the display list

        currentDonut = null;
        totalBox.setText(format.format(getTotal())); //update total
        clearForm();
    }

    /**
     * removes a donut from the list, shows alert if theres an error
     */
    @FXML
    public void remove(){
        if(donutList.getSelectionModel().getSelectedIndex() == DOESNOTEXIST){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("No Donuts are Selected");
            a.setHeaderText("No Selection");
            a.show();
            return;
        }
        donuts.remove(donutList.getSelectionModel().getSelectedIndex());
        donutList.getItems().remove(donutList.getSelectionModel().getSelectedIndex());
        totalBox.setText(format.format(getTotal()));
    }

    /**
     * gets the total of the donuts in the list without tax
     * @return the total
     */
    private float getTotal(){
        float total = NONE;
        for (Donut donut : donuts) {
            total += donut.itemPrice();
        }
        return total;
    }

    /**
     * clears the form for the next donut to be added
     */
    private void clearForm(){
        typeGroup.getSelectedToggle().setSelected(false);
        flavorBox.getSelectionModel().clearSelection();
        flavorBox.setDisable(true);
        qty.getValueFactory().setValue(DEFAULT);
        currentTotalBox.setText("$0.00");
    }

    /**
     * adds all the donuts to the order.
     */
    @FXML
    public void addToOrder(){
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(donuts.isEmpty()){
            a.setContentText("There are no Donuts in the list! try hitting \">>\"");
            a.setHeaderText("No Donuts");
            a.show();
            return;
        }

        for (Donut donut : donuts) {
            References.customerOrder.add(donut); //add the donut to the order
        }
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("All donuts were added to the Order!");
        a.setHeaderText("Added to Order");
        a.showAndWait();
        Stage stage = (Stage) addO.getScene().getWindow(); //get the current stage

        stage.close(); //close it
    }

}
