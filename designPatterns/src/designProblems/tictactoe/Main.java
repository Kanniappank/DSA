package tictactoe;

import tictactoe.Controller.GameController.TicTacToe;
import tictactoe.PlayerStatergy.ConcreteStategies.HumanPlayerStategy;
import tictactoe.PlayerStatergy.IPlayerStatergy;

public class Main {
    public static void main(String[] args) {
        IPlayerStatergy playerXStatergy = new HumanPlayerStategy("PlayerX");
        IPlayerStatergy playerOStatergy = new HumanPlayerStategy("PlayerO");
        TicTacToe ticTacToe = new TicTacToe(playerXStatergy, playerOStatergy, 3, 3);
        ticTacToe.play();
    }
}
