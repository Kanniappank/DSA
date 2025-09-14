package Design.problems.tic.tac.too;

public interface IGameState {

    void next(GameContext context);
    boolean isGameOver();
}
