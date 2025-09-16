package tictactoe.GameState.ConcreteStates;

import tictactoe.GameState.IGameState;
import tictactoe.GameState.Context.GameContext;
import tictactoe.Utility.Player;

public class XTurnState implements IGameState {

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setState(player.getSymbol() == Symbol.X ? new XWonState() : new OWonState());
        } else {
            context.setState(new OTurnState());
        }

    }

    @Override
    public boolean isGameOver() {
        return false;
    }

}
