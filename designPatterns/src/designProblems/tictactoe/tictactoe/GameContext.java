package tictactoe;

public class GameContext {
    private IGameState currentState;

    public GameContext() {
        this.currentState = new XTurnState();
    }

    public void setState(IGameState state) {
        this.currentState = state;
    }

    public void next(Player player, boolean hasWon) {
        this.currentState.next(this);
    }

    public boolean isGameOver() {
        return this.currentState.isGameOver();
    }

    public IGameState getCurrentState() {
        return this.currentState;
    }

}
