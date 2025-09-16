import Design.problems.tic.tac.too.IGameState;
import tictactoe.CommonEnums.Symbols;
import tictactoe.GameState.Context.GameContext;
import tictactoe.Utility.Player;package tictactoe.GameState.ConcreteStates;
public class OTurnState implements IGameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

        if (hasWon) {
            context.setState(player.getSymbol == Symbols.Y ? new YWonState() : new XWonState());
        } else {
            context.setState(new XTurnState());
        }

    }

    @Override
    public boolean isGameOver() {
        return false;
    }

}
