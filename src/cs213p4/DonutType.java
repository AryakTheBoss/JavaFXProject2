package cs213p4;

/**
 * Class to contain constants for Donut types
 * @author mss390 amp487
 *
 */
public enum DonutType {
    YEAST,CAKE,DONUT_HOLE;

    @Override
    public String toString() {
        switch(this){
            case YEAST:
                return "Yeast";
            case CAKE:
                return "Cake";
            case DONUT_HOLE:
                return "Donut Hole";
            default:
                return "null";
        }
    }
}
