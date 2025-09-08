
package command;

import java.util.Stack;

public class RemoteControl {
    private ICommand command;
    private Stack<ICommand> commandHistory = new Stack<>();
    private Stack<ICommand> redoHistory = new Stack<>();

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
        // Clear redo history when new command is executed
        redoHistory.clear();
    }

    public void undoButton() {
        if (!commandHistory.isEmpty()) {
            ICommand lastCommand = commandHistory.pop();
            lastCommand.undo();
            redoHistory.push(lastCommand);
        }
    }

    public void redoButton() {
        if (!redoHistory.isEmpty()) {
            ICommand lastUndoneCommand = redoHistory.pop();
            lastUndoneCommand.execute();
            commandHistory.push(lastUndoneCommand);
        }
    }
}
