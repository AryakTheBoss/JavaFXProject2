package cs213p4;

import java.util.Objects;

public class MenuItem {

public int quantity;

public MenuItem(int quantity){
    this.quantity = quantity;
}

public int getQuantity(){
    return quantity;
}
public void incrementQuantity(){
    quantity++;
}
    public void setQuantity(int q){
        quantity = q;
    }

    @Override
    public String toString() {
        return "("+quantity+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;
        MenuItem menuItem = (MenuItem) o;
        return quantity == menuItem.quantity;
    }



    public float itemPrice(){
        return 0.0f;
    }
}
