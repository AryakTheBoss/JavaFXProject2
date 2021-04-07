package cs213p4;

import java.util.ArrayList;


/**
 * Class represents the item type Coffee
 * @author mss390 amp487
 *
 */
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
        if(size == null){
            return 0;
        }
        switch(size){

            case SHORT:
                return (SHORT_PRICE + calculateAddons())*super.getQuantity();
            case TALL:
                return (TALL_PRICE + calculateAddons())*super.getQuantity();
            case GRANDE:
                return (GRANDE_PRICE + calculateAddons())*super.getQuantity();
            case VENTI:
                return (VENTI_PRICE + calculateAddons())*super.getQuantity();
            default:
                return 0;
        }

    }

    @Override
    public String toString() {
        return "Coffee"+super.toString()+" "+size+" Addons: "+addons;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Coffee)) return false;
        Coffee other = (Coffee) o;
        return other.getAddons().equals(addons) && other.getSize() == size;
    }

    public ArrayList<AddIns> getAddons(){
        return addons;
    }
    public Size getSize(){
        return size;
    }
    public void setSize(Size s){
        size = s;
    }

    public float calculateAddons(){

        if(addons.isEmpty()){
            return 0;
        }
        return addons.size()*ADDON_PRICE;

    }


}
