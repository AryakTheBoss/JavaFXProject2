package cs213p4;

/**
 * Class to contain constants for Donut types
 * @author mss390 amp487
 *
 */
public enum DonutType {
    YEAST,CAKE,DONUT_HOLE;

    /**
     * method to convert donut type into a string to be displayed
     * @return the string of donut type
     */
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
