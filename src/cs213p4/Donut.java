package cs213p4;

public class Donut extends MenuItem{

    private DonutType type;
    private Flavor flavor;
    private float YEAST_PRICE = 1.39f;
    private float CAKE_PRICE = 1.59f;
    private float HOLE_PRICE = 0.33f;



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
    public String toString() {
        return type.toString()+super.toString()+" Flavor: "+flavor;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Donut)) return false;
        Donut other = (Donut) o;
        return other.getFlavor() == flavor && other.getType() == type;
    }

    @Override
    public float itemPrice() {
        if(type == null){
            return 0;
        }
        switch(type){
            case YEAST:
            return YEAST_PRICE*super.getQuantity();
            case CAKE:
                return CAKE_PRICE*super.getQuantity();
            case DONUT_HOLE:
                return HOLE_PRICE*super.getQuantity();
            default:
                return 0;
        }
    }
}
