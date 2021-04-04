package cs213p4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderDonutsController {

    private ToggleGroup typeGroup = new ToggleGroup();

    @FXML private RadioButton yeastRB;
    @FXML private RadioButton cakeRB;
    @FXML private RadioButton holeRB;
    @FXML private ChoiceBox<Flavor> flavorBox;
    @FXML private Spinner<Integer> qty;
    @FXML private TextField currentTotalBox;
    @FXML private TextField totalBox;
    @FXML private ListView<String> donutList;

    private ArrayList<Donut> donuts = new ArrayList<>();
    private Donut currentDonut = null;
    private DecimalFormat format = new DecimalFormat("$#,##0.00");

    @FXML
    public void initialize(){
        yeastRB.setToggleGroup(typeGroup);
        cakeRB.setToggleGroup(typeGroup);
        holeRB.setToggleGroup(typeGroup);
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20); //set the qty box range to something between 1 and 20
        qty.setValueFactory(valueFactory);
        qty.getValueFactory().setValue(1); //set default value, it is not editable
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
                            currentDonut.setType(DonutType.YEAST);
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
                            currentDonut.setType(DonutType.CAKE);
                            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
                            flavorBox.setDisable(false);
                            break;
                        case "holeRB": //if donut hole is selected
                            flavorBox.getSelectionModel().clearSelection();
                            flavorBox.getItems().clear();
                            flavorBox.getItems().add(Flavor.GLAZED);
                            flavorBox.getItems().add(Flavor.POWDERED_SUGAR);
                            flavorBox.getItems().add(Flavor.DOUBLE_CHOCOLATE);
                            currentDonut.setType(DonutType.DONUT_HOLE);
                            currentTotalBox.setText(format.format(currentDonut.itemPrice()));
                            flavorBox.setDisable(false);
                            break;
                    }

                }
            }
        });

    }

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
    @FXML
    public void remove(){
        donuts.remove(donutList.getSelectionModel().getSelectedIndex());
        donutList.getItems().remove(donutList.getSelectionModel().getSelectedIndex());
        totalBox.setText(format.format(getTotal()));
    }
    private float getTotal(){
        float total = 0;
        for (Donut donut : donuts) {
            total += donut.itemPrice();
        }
        return total;
    }
    private void clearForm(){
        typeGroup.getSelectedToggle().setSelected(false);
        flavorBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void addToOrder(){

    }

}
