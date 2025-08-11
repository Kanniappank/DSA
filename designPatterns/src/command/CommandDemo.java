package command;

public class CommandDemo {
    public static void main(String[] args) {

        AirConditioner AC = new AirConditioner();
        TurnOnACCommand turnOnACCommand = new TurnOnACCommand(AC);
        TurnOffACCommand turnOffACCommand = new TurnOffACCommand(AC);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOnACCommand);
        remote.pressButton();
        remote.undoButton();

        remote.setCommand(turnOffACCommand);
        remote.undoButton();
        remote.pressButton();

    }
}
