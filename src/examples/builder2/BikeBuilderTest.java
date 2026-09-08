package examples.builder2;

public class BikeBuilderTest {
    public static void main(String[] args) {
        Bicycle bike;
        BicycleDirector director = new BicycleDirector();
        IBicycleBuilder builder = new GTBicycleBuilder();

        bike = director.createMountainBike(builder);

        System.out.println(bike);

        builder = new BenelliBicycleBuilder();
        bike = director.createRoadBike(builder);

        System.out.println(bike);
    }
}
