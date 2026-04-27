import java.util.Random;

/**
 * UC7: Computer Makes a Random Move (Easy Level)
 * ------------------------------------------------
 * Goal   : Allow the computer to make a random valid move.
 * Actor  : Computer Player
 * Flow   : Computer turn → random slot generated → converted → validated → placed.
 *
 * Key Concepts:
 *   - Random Generation
 *   - Loop Until Valid
 *   - Logic Reuse (UC4 + UC5 + UC6)
 *
 * Key Requirements:
 *   - Generate a slot between 1–9
 *   - Ensure the chosen slot is a valid (empty) cell
 */
public class Main {

    static char[][] board = {
            {'-', '-', '-'},
            {'-', 'X', '-'},
            {'-', '-', '-'}
    };

    static char computerSymbol = 'O';
    static Random random = new Random();

    /**
     * Entry point of the program. Triggers the computer move.
     */
    public static void main(String[] args) {
        System.out.println("Board before computer move:");
        printBoard();

        computerMove();

        System.out.println("Board after computer move:");
        printBoard();
    }

    /**
     * Generates random slot values until a valid move is found,
     * then places the computer symbol on the board.
     * Reuses: getRowFromSlot (UC4), getColFromSlot (UC4),
     *         isValidMove (UC5), placeMove (UC6)
     */
    static void computerMove() {
        int row, col;
        int slot;

        do {
            slot = random.nextInt(9) + 1;   // random slot: 1 to 9
            row  = getRowFromSlot(slot);     // UC4
            col  = getColFromSlot(slot);     // UC4
        } while (!isValidMove(row, col));    // UC5: repeat if cell is occupied

        placeMove(row, col, computerSymbol); // UC6
        System.out.println("Computer chose slot " + slot
                + " → Row=" + row + ", Col=" + col
                + " → Placed '" + computerSymbol + "'");
    }

    // -------------------------------------------------------
    // UC4 – Slot to Index conversion (reused here)
    // -------------------------------------------------------
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    // -------------------------------------------------------
    // UC5 – Move Validation (reused here)
    // -------------------------------------------------------
    static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        return board[row][col] == '-';
    }

    // -------------------------------------------------------
    // UC6 – Place Move (reused here)
    // -------------------------------------------------------
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // -------------------------------------------------------
    // UC1 – Print Board (reused here)
    // -------------------------------------------------------
    static void printBoard() {
        System.out.println("-------------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}