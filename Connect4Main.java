import java.util.Scanner;

public class Connect4Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connect4Game game = new Connect4Game();

        char currentPlayer = 'X';
        boolean gameEnded = false;

        System.out.println("Welcome to Connect 4!\nTo win, connect 4 pieces in a row vertically, horizontally, or diagonally!");
        game.printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Choose a column (0-6): ");
            
            int column;
            try {
                column = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (!game.makeMove(column, currentPlayer)) {
                System.out.println("Invalid move. Try a different column.");
                continue;
            }

            game.printBoard();

            if (game.isGameOver(currentPlayer)) {
                if (game.isBoardFull() && !game.checkWinner(currentPlayer)) {
                    System.out.println("Draw!");
                } else {
                    System.out.println("Player " + currentPlayer + " wins!");
                }
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }
}
