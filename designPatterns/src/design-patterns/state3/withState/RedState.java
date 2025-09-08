package state3.withState;

public class RedState implements ITrafficLightState {


    @Override
    public void next(TrafficLightContext context) {
        System.out.println("Green on, Lets go");
        context.setState(new GreenState());
    }

    @Override
    public String getColor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
