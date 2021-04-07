package cs213p4;

import java.util.ArrayList;
/**
 * Class to hold customer order
 * @author mss390 amp487
 *
 */
public class Order implements Customizable{

    private int orderNumber;
    private static int totalOrders = 0; //used to keep track of how many order instances have been created
    private ArrayList<MenuItem> items;
    public static final float SALES_TAX = 1.06625f;

    public Order(){
        items = new ArrayList<>();
        totalOrders++;
        orderNumber = totalOrders;
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof MenuItem){
            for(MenuItem i : items){
                if(i.equals(obj)){
                    i.incrementQuantity();
                    return true;
                }
            }
            return items.add((MenuItem)obj);
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof MenuItem){
            return items.remove(obj);
        }else{
            return false;
        }
    }

    public ArrayList<MenuItem> getItems(){
        return items;
    }

    public void setItems(ArrayList<MenuItem> mi){
        items = mi;
    }

    public float orderSubTotal(){
        float price = 0.0f;
        for(MenuItem i : items){
            price += i.itemPrice();
        }
        return price;
    }

    public float orderTotal(){
        return orderSubTotal()*SALES_TAX;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

}
