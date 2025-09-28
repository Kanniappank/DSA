package designProblems.tictactoe.GameState.ConcreteStates;

import designProblems.tictactoe.GameState.IGameState;
import designProblems.tictactoe.GameState.Context.GameContext;

public class OWonState implements IGameState {

    @Override
    public void next(GameContext context) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }

}
