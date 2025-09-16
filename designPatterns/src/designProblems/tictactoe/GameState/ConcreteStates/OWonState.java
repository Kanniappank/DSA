package tictactoe.GameState.ConcreteStates;

import tictactoe.GameState.IGameState;

public class OWonState implements IGameState {

    @Override
    public void next(Object context) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }

}
