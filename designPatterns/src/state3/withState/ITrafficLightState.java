package state3.withState;

public interface ITrafficLightState {
    void next(TrafficLightContext context);
    String getColor();
}
