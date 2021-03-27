package cs213p4;

public enum AddIns {
CREAM,SYRUP,MILK,CARAMEL,WHIPPED_CREAM;

    @Override
    public String toString() {
        switch(this){
            case MILK:
                return "Milk";
            case CREAM:
                return "Cream";
            case SYRUP:
                return "Syrup";
            case CARAMEL:
                return "Caramel";
            case WHIPPED_CREAM:
                return "Whipped Cream";
            default:
                return "null";
        }
    }
}
