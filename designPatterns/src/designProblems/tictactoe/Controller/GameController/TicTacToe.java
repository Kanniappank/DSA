package tictactoe.Controller.GameController;

import tictactoe.CommonEnums.Symbols;
import tictactoe.GameState.IGameState;
import tictactoe.GameState.ConcreteStates.OWonState;
import tictactoe.GameState.ConcreteStates.XWonState;
import tictactoe.GameState.Context.GameContext;
import tictactoe.PlayerStatergy.IPlayerStatergy;
import tictactoe.Utility.Board;
import tictactoe.Utility.Player;
import tictactoe.Controller.*;


public class TicTacToe implements IBoardGames {

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext context;

    public TicTacToe(IPlayerStatergy xStatergy, IPlayerStatergy yStatergy, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.playerX = new Player(Symbols.X, xStatergy);
        this.playerO = new Player(Symbols.O, yStatergy);
        this.currentPlayer = playerX;
        this.context = new GameContext();
    }

    @Override
    public void play() {
        do {
            this.board.printBoard();

            Position move = currentPlayer.getStatergy().makeMove(board);

            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(context, currentPlayer);

            this.switchPlayer();
        } while (!context.isGameOver()){
            anounceResult();
        }

    }

    private void switchPlayer() {
        this.currentPlayer = this.playerX == this.currentPlayer ? this.playerO : this.playerX;
    }

    private void anounceResult() {
        IGameState state = context.getState();

        if (state instanceof XWonState) {
            System.out.println("Player X won the game");
        } else if (state instanceof OWonState) {
            System.out.println("Player O won the game");
        } else {
            System.out.println("Game is draw");
        }

    }

}