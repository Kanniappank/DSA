package designProblems.tictactoe.GameState.ConcreteStates;

import designProblems.tictactoe.GameState.IGameState;
import designProblems.tictactoe.GameState.Context.GameContext;
import designProblems.tictactoe.CommonEnums.Symbols;

public class XTurnState implements IGameState {

    @Override
    public void next(GameContext context) {
        context.setState(new OTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

}
