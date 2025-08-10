package command;

public class TurnOffACCommand implements ICommand{
    AirConditioner AC;

    public TurnOffACCommand(AirConditioner AC) {
        this.AC = AC;
    }

    @Override
    public void execute() {
        AC.turnOffAc();
    }

    @Override
    public void undo() {
       AC.turnNoAc();
    }
    
}
