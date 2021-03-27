package cs213p4;

import java.util.ArrayList;

public class StoreOrders implements Customizable{

    private ArrayList<Order> orders;

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }
}
