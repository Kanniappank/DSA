package bridge;

public class BasicRemoteControl extends RemoteControl {

    public BasicRemoteControl(IDevice device) {
        super(device);

    }

    @Override
    public void pressOff() {
        device.turnOff();

    }

    @Override
    public void pressOn() {
        device.turnOn();

    }

}
