package designProblems.tictactoe.GameState.ConcreteStates;

import designProblems.tictactoe.GameState.IGameState;
import designProblems.tictactoe.GameState.Context.GameContext;

public class OTurnState implements IGameState {
    @Override
    public void next(GameContext context) {
        context.setState(new XTurnState());
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

}
