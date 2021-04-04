package cs213p4;

public enum Flavor {
    CHOCOLATE_FROSTED,STRAWBERRY,GLAZED,BOSTON_CREAM,JELLY_FILLED,BLUEBERRY,POWDERED_SUGAR,PLAIN,MAPLE_SYRUP_FROSTED,DOUBLE_CHOCOLATE;

    @Override
    public String toString() {
        switch(this){
            case CHOCOLATE_FROSTED:
                return "Choc Frosted";
            case GLAZED:
                return "Glazed";
            case MAPLE_SYRUP_FROSTED:
                return "Map Syrp Frstd";
            case BLUEBERRY:
                return "Blueberry";
            case STRAWBERRY:
                return "Strawberry";
            case PLAIN:
                return "Plain";
            case BOSTON_CREAM:
                return "Bstn Cream";
            case JELLY_FILLED:
                return "Jelly";
            case POWDERED_SUGAR:
                return "Sugar";
            case DOUBLE_CHOCOLATE:
                return "Double Chocolate";
            default:
                return "invalid";
        }
    }
}
