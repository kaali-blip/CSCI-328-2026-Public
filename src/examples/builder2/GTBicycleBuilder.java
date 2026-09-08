package examples.builder2;

public class GTBicycleBuilder implements IBicycleBuilder {
    private String color = "not set";
    private String height = "not set";
    private String roadType = "not set";
    
    public Bicycle getBicycleInstance(){
        return new Bicycle("GT", "Avalance", color, height, roadType);
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setHeight(String height){
        this.height = height;
    }

    public void setRoadType(String roadType){
        this.roadType = roadType;
    }

    public void reset(){
        this.color = "not set";
        this.height = "not set";
        this.roadType = "not set";
    }
}
