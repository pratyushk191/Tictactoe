public class Main {

    static char[][] board = new char[3][3];

    /**
     * Entry point of the program. Places a sample move
     * and prints the updated cell value to verify.
     */
    public static void main(String[] args) {

        // Initialise all cells with '-'
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = '-';

        System.out.println("Before placing move:");
        printBoard();

        // Place 'X' at row=0, col=0
        placeMove(0, 0, 'X');
        // Place 'O' at row=1, col=1
        placeMove(1, 1, 'O');
        // Place 'X' at row=2, col=2
        placeMove(2, 2, 'X');

        System.out.println("After placing moves:");
        printBoard();
    }

    /**
     * Updates the board by placing the given symbol at
     * the specified row and column.
     * Input  : Row, Column, Symbol
     * Hint   : Assume the move is already validated (UC5).
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
        System.out.println("Placed '" + symbol + "' at Row=" + row + ", Col=" + col);
    }

    /**
     * Helper method to print the current state of the board.
     */
    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println();
            System.out.println("-------------");
        }
    }
}