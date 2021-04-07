package cs213p4;
/**
 * Class to contain constants for sizes of Coffees
 * @author mss390 amp487
 *
 */
public enum Size {

    SHORT,TALL,GRANDE,VENTI;

    @Override
    public String toString() {
        switch(this){
            case TALL:
                return "Tall";
            case SHORT:
                return "Short";
            case GRANDE:
                return "Grande";
            case VENTI:
                return "Venti";
            default:
                return null;
        }

    }
}
