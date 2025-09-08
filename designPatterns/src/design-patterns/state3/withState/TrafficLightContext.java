package state3.withState;

public class TrafficLightContext {
    private ITrafficLightState currentState;

    public TrafficLightContext() {
        currentState = new RedState();
    }

    public void setState(ITrafficLightState state) {
        this.currentState = state;
    }

    public void next() {
        currentState.next(this);
    }

    public String getColor() {
        return currentState.getColor();
    }

}
