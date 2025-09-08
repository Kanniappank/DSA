package bridge;

public class Radio implements IDevice {

    @Override
    public void turnOff() {
        System.out.println("Radio turned Off");

    }

    @Override
    public void turnOn() {
        System.out.println("Radio turned On");

    }

}
