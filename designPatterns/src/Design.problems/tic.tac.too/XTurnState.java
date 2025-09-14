package Design.problems.tic.tac.too;

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
