package command;

public class TurnOnACCommand implements ICommand{

    AirConditioner AC;


    public TurnOnACCommand(AirConditioner AC) {
        this.AC=AC;
        
    }

    @Override
    public void execute() {
        AC.turnNoAc();
    }

    @Override
    public void undo() {
        AC.turnOffAc();
    }
    
}
