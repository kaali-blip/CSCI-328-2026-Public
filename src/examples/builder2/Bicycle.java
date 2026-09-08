package examples.builder2;

public class Bicycle {
    private String make;
    private String model;
    private String color;
    private String height;
    private String roadType;

    public Bicycle(String make, String model, String color, String height, String roadType){
        this.make = make;
        this.model = model;
        this.color = color;
        this.height = height;
        this.roadType = roadType;
    }

    public String toString(){
        String bicycleDescription = "This is a " 
                                    + color + " " 
                                    + make + " " 
                                    + model 
                                    + " with a height of " 
                                    + height 
                                    + " inches, it is often used as a "
                                    + roadType
                                    + " bicycle.";

        return bicycleDescription;
    }
}
