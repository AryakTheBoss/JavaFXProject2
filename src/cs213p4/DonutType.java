package cs213p4;

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
