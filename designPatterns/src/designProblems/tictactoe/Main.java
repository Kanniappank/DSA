package designProblems.tictactoe;

import designProblems.tictactoe.Controller.GameController.TicTacToe;
import designProblems.tictactoe.PlayerStatergy.ConcreteStategies.HumanPlayerStategy;
import designProblems.tictactoe.PlayerStatergy.IPlayerStatergy;

public class Main {
    public static void main(String[] args) {
        IPlayerStatergy playerXStatergy = new HumanPlayerStategy("PlayerX");
        IPlayerStatergy playerOStatergy = new HumanPlayerStategy("PlayerO");
        TicTacToe ticTacToe = new TicTacToe(playerXStatergy, playerOStatergy, 3, 3);
        ticTacToe.play();
    }
}
