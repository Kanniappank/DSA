package bridge;

public class BridegpatternDemo {

    public static void main(String[] args) {

        IDevice Tv = new Tv();
        RemoteControl remoteControl = new BasicRemoteControl(Tv);

        remoteControl.pressOn();
        remoteControl.pressOff();

        IDevice Radio = new Radio();
        RemoteControl remoteControl1 = new BasicRemoteControl(Radio);

        remoteControl1.pressOn();
        remoteControl1.pressOff();

    }
}
