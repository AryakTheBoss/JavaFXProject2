package cs213p4;

import java.util.ArrayList;
/**
 * Class to hold the orders of all customers
 * @author mss390 amp487
 *
 */
public class StoreOrders implements Customizable{

    private ArrayList<Order> orders;

    public StoreOrders(){
        orders = new ArrayList<>();
    }

    @Override
    public boolean add(Object obj) {
        if(obj instanceof Order){
            return orders.add((Order)obj);
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Order){
            return orders.remove(obj);
        }else{
            return false;
        }
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
}
