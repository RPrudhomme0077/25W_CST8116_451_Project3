public class Connect4Game {
    private final int ROWS = 6;
    private final int COLUMNS = 7;
    private final char[][] board = new char[ROWS][COLUMNS];

    public Connect4Game() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            System.out.print("|");
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }

    public boolean makeMove(int column, char playerSymbol) {
        if (column < 0 || column >= COLUMNS) {
            return false;
        }

        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][column] == ' ') {
                board[row][column] = playerSymbol;
                return true;
            }
        }

        return false;
    }

    public boolean isGameOver(char playerSymbol) {
        return checkWinner(playerSymbol) || isBoardFull();
    }

    public boolean checkWinner(char playerSymbol) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row][col + 1] == playerSymbol &&
                    board[row][col + 2] == playerSymbol &&
                    board[row][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] == playerSymbol &&
                    board[row + 1][col] == playerSymbol &&
                    board[row + 2][col] == playerSymbol &&
                    board[row + 3][col] == playerSymbol) {
                    return true;
                }
            }
        }

        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row - 1][col + 1] == playerSymbol &&
                    board[row - 2][col + 2] == playerSymbol &&
                    board[row - 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLUMNS - 4; col++) {
                if (board[row][col] == playerSymbol &&
                    board[row + 1][col + 1] == playerSymbol &&
                    board[row + 2][col + 2] == playerSymbol &&
                    board[row + 3][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == ' ') {
                return false;
            }
        }
        return true;
    }
}
