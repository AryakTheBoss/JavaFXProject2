package cs213p4;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable{

    private ArrayList<AddIns> addons;
    private Size size;
    private final float SHORT_PRICE = 1.99f;
    private final float TALL_PRICE = 2.49f;
    private final float GRANDE_PRICE = 2.99f;
    private final float VENTI_PRICE = 3.49f;
    private final float ADDON_PRICE = 0.2f;

    public Coffee(Size size, int quantity){
        super(quantity);
        this.size=size;
        addons = new ArrayList<>();
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof AddIns) {
            return addons.add((AddIns)obj);
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof AddIns) {
            return addons.remove(obj);
        }else{
            return false;
        }
    }

    @Override
    public float itemPrice() {
        switch(size){

            case SHORT:
                return SHORT_PRICE + calculateAddons();
            case TALL:
                return TALL_PRICE + calculateAddons();
            case GRANDE:
                return GRANDE_PRICE + calculateAddons();
            case VENTI:
                return VENTI_PRICE + calculateAddons();
            default:
                return -1;
        }

    }

    @Override
    public String toString() {
        return "Coffee"+super.toString()+" "+size+" "+addons;
    }

    public float calculateAddons(){

        if(addons.isEmpty()){
            return 0;
        }
        return addons.size()*ADDON_PRICE;

    }


}
