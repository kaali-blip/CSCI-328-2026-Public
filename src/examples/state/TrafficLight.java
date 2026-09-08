package examples.state;

public class TrafficLight {
    // Context class
    private TrafficLightState currentState;
    // Optional style for pattern
    // private TrafficLightState redState;
    // private TrafficLightState yellowState;
    // private TrafficLightState greenState;

    public TrafficLight() {
        // Initial state
        // redState = new RedLightState();
        // yellowState = new YellowLightState();
        // greenState = new GreenLightState();
        // this.currentState = redState; 
        this.currentState = new RedLightState(); 
    }

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void changeState() {
        currentState.handleRequest(this);
    }
}
