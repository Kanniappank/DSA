package bridge;

public class Tv implements IDevice {

    @Override
    public void turnOff() {
        System.out.println("Turn On TV");

    }

    @Override
    public void turnOn() {
        System.out.println("Turn Off TV");

    }

}
