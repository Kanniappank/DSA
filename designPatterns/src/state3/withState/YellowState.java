package state3.withState;

public class YellowState implements ITrafficLightState {

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Yello Turns Red, Stop");
        context.setState(new RedState());
    }

    @Override
    public String getColor() {
        return "Yellow";
    }

}
