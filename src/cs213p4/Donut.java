package cs213p4;

public class Donut extends MenuItem{

    private DonutType type;
    private Flavor flavor;
    private float YEAST_PRICE = 1.39f;
    private float CAKE_PRICE = 1.59f;
    private float HOLE_PRICE = 0.33f;

    @Override
    public String toString() {
        return type.toString()+super.toString()+" Flavor: "+flavor;
    }

    public Donut(DonutType type, Flavor flavor, int quantity){
        super(quantity);
        this.type = type;
        this.flavor = flavor;
    }

    public Flavor getFlavor(){
        return flavor;
    }
    public DonutType getType(){
        return type;
    }

    @Override
    public float itemPrice() {
        switch(type){
            case YEAST:
            return YEAST_PRICE;
            case CAKE:
                return CAKE_PRICE;
            case DONUT_HOLE:
                return HOLE_PRICE;
            default:
                return -1;
        }
    }
}
