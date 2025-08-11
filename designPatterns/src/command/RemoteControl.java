package command;

public class RemoteControl {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }

    public void undoButton(){
        command.undo();
    }
}
