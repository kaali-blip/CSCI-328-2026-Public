package examples.state;

public class TrafficLightExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.changeState(); // Red -> Green
        trafficLight.changeState(); // Green -> Yellow
        trafficLight.changeState(); // Yellow -> Red
        trafficLight.changeState(); // Red -> Green
    }
}
