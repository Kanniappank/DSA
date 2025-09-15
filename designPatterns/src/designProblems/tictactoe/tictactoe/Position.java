package tictactoe;
class Position {
    public int row;
    public int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

}