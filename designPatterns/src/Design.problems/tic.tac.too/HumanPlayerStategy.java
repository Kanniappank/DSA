package Design.problems.tic.tac.too;

import java.util.Scanner;

public class HumanPlayerStategy implements IPlayerStatergy {

    private Scanner scanner;
    private String playerName;

    public HumanPlayerStategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {
        while (true) {
            System.out.println("%s Enter your move (row[0-2] column[0-2]): " + playerName);
            try {
                int row = scanner.nextInt();
                int column = scanner.nextInt();

                Position move = new Position(row, column);

                if (board.isValidMove(move)) {
                    return move;
                }

                System.out.println("Invalid Move Please try again!");

            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter numbers for row and column.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

}
