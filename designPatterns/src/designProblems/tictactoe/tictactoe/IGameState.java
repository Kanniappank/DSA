package tictactoe;

public interface IGameState {

    void next(GameContext context);
    boolean isGameOver();
}
