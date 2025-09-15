package tictactoe;

public class Board {
    private final rows;
    private final columns;
    private Symbols[][] gird;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        grid = new Symbols[][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbols.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position pos) {
        return pos.row > 0 && pos.row < this.rows && pos.column > 0 && pos.column < this.colunms && grid[pos.row][pos.column] == Symbols.empty
    }

    public makeMove(Position pos, Symbols symbol) {
        this.grid[pos.row][pos.column] = symbol;
    }

    public void checkGameState(GameContext context, Player currentPlayer) {

        //checks Row wise won
        for (int i = 0; i < this.rows; i++) {
            if (gird[i][0] != Symbol.EMPTY && this.isWinningLine(grid[[i]])){
                context.setState(currentPlayer, true);
                return;
            }
        }

        //checks column wise
        for (int i = 0; i < this.columns; i++) {
            Symbol[] column = new Symbol[this.rows];
            for (int j = 0; j < this.rows; j++) {
                column[j] = grid[j][i];
            }
            if (column[0] != Symbols.EMPTY && isWinningLine(column)) {
                context.next(currentPlayer, true);
                retrun;
            }
        }


        //checks diagonals
        Symbol[] diagonal1 = new Symbol[Math.min(this.rows, this.columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(this.rows, this.columns)];

        for (int i = 0; i < math.min(this.rows, this.columns); i++) {
            diagonal1 = gird[i][i];
            diagonal2 = grid[i][this.colunm - 1 - i];
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

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];
        for (Symbol s : line) {
            if (s != first) {
                return false;
            }
        }
        return true;
    }

    public printBoard() {
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
                    System.out.print('|')
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
