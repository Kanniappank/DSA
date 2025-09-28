package designProblems.tictactoe.Utility;

import designProblems.tictactoe.CommonEnums.Symbols;
import designProblems.tictactoe.GameState.Context.GameContext;

public class Board {
    private final int rows;
    private final int columns;
    private Symbols[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Symbols[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbols.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos) {
        return pos.row > 0 && pos.row < this.rows && pos.column > 0 && pos.column < this.columns
                && grid[pos.row][pos.column] == Symbols.EMPTY;
    }

    public void makeMove(Position pos, Symbols Symbols) {
        this.grid[pos.row][pos.column] = Symbols;
    }

    public void checkGameState(GameContext context, Player currentPlayer) {

        // checks Row wise won
        for (int i = 0; i < this.rows; i++) {
            if (grid[i][0] != Symbols.EMPTY && this.isWinningLine(grid[i])) {
                context.next(currentPlayer, true);
                return;
            }
        }

        // checks column wise
        for (int i = 0; i < this.columns; i++) {
            Symbols[] column = new Symbols[this.rows];
            for (int j = 0; j < this.rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbols.EMPTY && isWinningLine(column)) {
                context.next(currentPlayer, true);
                return;
            }
        }

        // checks diagonals
        Symbols[] diagonal1 = new Symbols[Math.min(this.rows, this.columns)];
        Symbols[] diagonal2 = new Symbols[Math.min(this.rows, this.columns)];

        for (int i = 0; i < Math.min(this.rows, this.columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][this.columns - 1 - i];
        }
        if (diagonal1[0] != Symbols.EMPTY && isWinningLine((diagonal1))) {
            context.next(currentPlayer, true);
            return;
        }
        if (diagonal2[0] != Symbols.EMPTY && isWinningLine((diagonal2))) {
            context.next(currentPlayer, true);
            return;
        }

    }

    private boolean isWinningLine(Symbols[] line) {
        Symbols first = line[0];
        for (Symbols s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                Symbols symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print('X');
                        break;
                    case O:
                        System.out.print('Y');
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < this.columns - 1) {
                    System.out.print('|');
                }

            }
            System.out.println();
            if (i < this.rows - 1) {
                System.out.print("---+---+---");
            }
        }
        System.out.println();
    }
}
