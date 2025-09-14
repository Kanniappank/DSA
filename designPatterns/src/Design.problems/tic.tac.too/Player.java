package Design.problems.tic.tac.too;

public class Player {
    Symbols symbol;
    IPlayerStatergy statergy;

    public Player(Symbols symbol, IPlayerStatergy statergy) {
        this.symbol = symbol;
        this.statergy = statergy;
    }

    public Symbols getSymbol() {
        return this.symbol;
    }

    public IPlayerStatergy getStatergy() {
        return statergy;
    }
}
