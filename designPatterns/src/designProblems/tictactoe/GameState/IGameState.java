package designProblems.tictactoe.GameState;

import designProblems.tictactoe.GameState.Context.GameContext;

public interface IGameState {

    void next(GameContext context);
    boolean isGameOver();
}
