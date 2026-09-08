package examples.builder2;

public class BicycleDirector {
    public Bicycle createMountainBike(IBicycleBuilder builder){
        builder.reset();
        builder.setColor("black");
        builder.setHeight("30");
        builder.setRoadType("off road");

        return builder.getBicycleInstance();
    }

    public Bicycle createRoadBike(IBicycleBuilder builder){
        builder.reset();
        builder.setColor("red");
        builder.setHeight("32");
        builder.setRoadType("road");

        return builder.getBicycleInstance();
    }
}
