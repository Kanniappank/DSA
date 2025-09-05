package bridge;

public abstract class RemoteControl {

    protected IDevice device;

    public RemoteControl(IDevice device) {
        this.device = device;
    }

    public abstract void pressOn();

    public abstract void pressOff();

}
