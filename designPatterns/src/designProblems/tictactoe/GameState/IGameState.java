package tictactoe.GameState;

import tictactoe.GameState.Context.GameContext;

public interface IGameState {

    void next(GameContext context);
    boolean isGameOver();
}
