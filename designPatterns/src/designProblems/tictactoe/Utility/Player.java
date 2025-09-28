package designProblems.tictactoe.Utility;

import designProblems.tictactoe.CommonEnums.Symbols;
import designProblems.tictactoe.PlayerStatergy.IPlayerStatergy;

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
