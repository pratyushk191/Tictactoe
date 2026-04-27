/**
 * UC9: Check Winning Condition
 * -----------------------------
 * Goal   : Detect if a player has won the game.
 * Actor  : Game System
 * Flow   : After each move → rows, columns, diagonals checked.
 *
 * Key Concepts:
 *   - Pattern Matching
 *   - Logical Conditions
 *   - Loop-Based Checks
 *
 * Winning Patterns:
 *   3 rows  (0,0–0,2) | (1,0–1,2) | (2,0–2,2)
 *   3 cols  (0,0–2,0) | (0,1–2,1) | (0,2–2,2)
 *   2 diags (0,0–2,2) | (0,2–2,0)
 */
public class Main {

    static char[][] board = new char[3][3];

    /**
     * Entry point of the program. Tests the win-check logic
     * with a pre-filled board where 'X' wins via the top row.
     */
    public static void main(String[] args) {

        // Set up a board where X wins via row 0
        board[0][0] = 'X'; board[0][1] = 'X'; board[0][2] = 'X';
        board[1][0] = 'O'; board[1][1] = 'O'; board[1][2] = '-';
        board[2][0] = '-'; board[2][1] = '-'; board[2][2] = '-';

        System.out.println("Current Board:");
        printBoard();

        System.out.println("Has 'X' won? → " + hasWon('X'));   // true
        System.out.println("Has 'O' won? → " + hasWon('O'));   // false

        // Set up a board where O wins via column 1
        board[0][0] = 'X'; board[0][1] = 'O'; board[0][2] = 'X';
        board[1][0] = '-'; board[1][1] = 'O'; board[1][2] = '-';
        board[2][0] = 'X'; board[2][1] = 'O'; board[2][2] = '-';

        System.out.println("\nUpdated Board:");
        printBoard();
        System.out.println("Has 'O' won? → " + hasWon('O'));   // true

        // Diagonal win test
        board[0][0] = 'X'; board[0][1] = 'O'; board[0][2] = 'O';
        board[1][0] = 'O'; board[1][1] = 'X'; board[1][2] = '-';
        board[2][0] = '-'; board[2][1] = 'O'; board[2][2] = 'X';

        System.out.println("\nDiagonal win Board:");
        printBoard();
        System.out.println("Has 'X' won (diagonal)? → " + hasWon('X'));   // true
    }

    /**
     * Checks all possible winning patterns for the given symbol.
     * Input  : Player symbol ('X' or 'O')
     * Output : true if win detected, false otherwise
     */
    static boolean hasWon(char symbol) {

        // Check all 3 rows
        for (int r = 0; r < 3; r++) {
            if (board[r][0] == symbol &&
                    board[r][1] == symbol &&
                    board[r][2] == symbol) {
                System.out.println("  → Win detected in Row " + r);
                return true;
            }
        }

        // Check all 3 columns
        for (int c = 0; c < 3; c++) {
            if (board[0][c] == symbol &&
                    board[1][c] == symbol &&
                    board[2][c] == symbol) {
                System.out.println("  → Win detected in Column " + c);
                return true;
            }
        }

        // Check main diagonal (top-left → bottom-right)
        if (board[0][0] == symbol &&
                board[1][1] == symbol &&
                board[2][2] == symbol) {
            System.out.println("  → Win detected in Main Diagonal");
            return true;
        }

        // Check anti-diagonal (top-right → bottom-left)
        if (board[0][2] == symbol &&
                board[1][1] == symbol &&
                board[2][0] == symbol) {
            System.out.println("  → Win detected in Anti-Diagonal");
            return true;
        }

        return false;
    }

    // -------------------------------------------------------
    // Helper: print board
    // -------------------------------------------------------
    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++)
                System.out.print(board[row][col] + " | ");
            System.out.println();
            System.out.println("-------------");
        }
    }
}