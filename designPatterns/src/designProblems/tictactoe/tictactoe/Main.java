package tictactoe;

public class Main {
    public static void main(String[] args) {
        HumanPlayerStategy playerXStatergy = new HumanPlayerStategy("PlayerX");
        IPlayerStatergy playerYStatergy = new HumanPlayerStategy("PlayerY");
        TicTacToe ticTacToe = new TicTacToe(playerXStatergy, playerYStatergy, 3, 3);
        ticTacToe.play();
    }
}
