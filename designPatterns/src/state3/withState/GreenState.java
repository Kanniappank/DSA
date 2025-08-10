package state3.withState;

public class GreenState implements ITrafficLightState{

    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Green turns Yellow , Slow down");
        context.setState(new YellowState());
    }

    @Override
    public String getColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
