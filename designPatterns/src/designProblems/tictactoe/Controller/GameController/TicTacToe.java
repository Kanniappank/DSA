package designProblems.tictactoe.Controller.GameController;

import designProblems.tictactoe.CommonEnums.Symbols;
import designProblems.tictactoe.Controller.*;
import designProblems.tictactoe.GameState.ConcreteStates.OWonState;
import designProblems.tictactoe.GameState.ConcreteStates.XWonState;
import designProblems.tictactoe.GameState.Context.GameContext;
import designProblems.tictactoe.GameState.IGameState;
import designProblems.tictactoe.PlayerStatergy.IPlayerStatergy;
import designProblems.tictactoe.Utility.Board;
import designProblems.tictactoe.Utility.Player;
import designProblems.tictactoe.Utility.Position;

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
        } while (!context.isGameOver());

        anounceResult();

    }

    private void switchPlayer() {
        this.currentPlayer = this.playerX == this.currentPlayer ? this.playerO : this.playerX;
    }

    private void anounceResult() {
        IGameState state = context.getCurrentState();

        if (state instanceof XWonState) {
            System.out.println("Player X won the game");
        } else if (state instanceof OWonState) {
            System.out.println("Player O won the game");
        } else {
            System.out.println("Game is draw");
        }

    }

}