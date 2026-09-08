package examples.state;

public class GreenLightState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLight context) {
        System.out.println("Traffic Light is GREEN. Go!");
        // context.setState(context.getYellowLightState()); // Transition to Yellow
        context.setState(new YellowLightState()); // Transition to Yellow
    }
}
