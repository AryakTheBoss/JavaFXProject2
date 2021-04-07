package cs213p4;

/**
 * Class to describe the item type Donut
 * @author mss390 amp487
 *
 */
public class Donut extends MenuItem{

    private DonutType type;
    private Flavor flavor;
    private float YEAST_PRICE = 1.39f;
    private float CAKE_PRICE = 1.59f;
    private float HOLE_PRICE = 0.33f;


    /**
     * constructor for a donut
     * @param type three different types of donuts exist
     * @param flavor nine flavors of donuts exist
     * @param quantity the amount of donuts being ordered at a time
     */
    public Donut(DonutType type, Flavor flavor, int quantity){
        super(quantity);
        this.type = type;
        this.flavor = flavor;
    }

    /**
     * getter method for donut flavor
     * @return the donut flavor
     */
    public Flavor getFlavor(){
        return flavor;
    }

    /**
     * getter for type of donut
     * @return the type of donut
     */
    public DonutType getType(){
        return type;
    }

    /**
     * setter for type of donut
     * @param type the type of donut
     */
    public void setType(DonutType type) {
        this.type = type;
    }

    /**
     * setter for donut flavor
     * @param flavor the donut flavor
     */
    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    /**
     * convert donut details into a string
     * @return the string of donut details
     */
    @Override
    public String toString() {
        return type.toString()+super.toString()+" Flavor: "+flavor;
    }

    /**
     * check if the donut type is the same, to avoid duplicates
     * @param o the donut being checked
     * @return true if the donut details are the same
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Donut)) return false;
        Donut other = (Donut) o;
        return other.getFlavor() == flavor && other.getType() == type;
    }

    /**
     * calculate the price of the donut with type and flavor and quantity included
     * @return the float of the item price in total
     */
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
