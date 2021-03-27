package cs213p4;

public class MenuItem {

public int quantity;

public MenuItem(int quantity){
    this.quantity = quantity;
}

protected int getQuantity(){
    return quantity;
}

    @Override
    public String toString() {
        return "("+quantity+")";
    }

    public float itemPrice(){
        return 0.0f;
    }
}
