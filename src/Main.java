import java.util.Random;
import java.util.Scanner;

/**
 * UC8: Continuous Turn-Based Game Loop
 * --------------------------------------
 * Goal   : Continue gameplay until a win or draw is detected.
 * Actor  : Game System
 * Flow   : Turn starts → player move → check win/draw → switch turn → repeat.
 *
 * Key Concepts:
 *   - While Loop
 *   - Game State Flags
 *   - Turn Switching
 *
 * Key Requirements:
 *   - Alternate turns between human and computer
 *   - Stop the loop when win or draw is detected
 *
 * Note: Win (UC9) and Draw (UC10) checks are stubbed here with
 *       placeholder methods so UC8 can be demonstrated independently.
 *       Replace the stubs with full implementations when integrating.
 */
public class Main {

    static char[][] board = new char[3][3];

    static boolean isHumanTurn = true;   // will be set by UC2 toss
    static boolean gameOver    = false;

    static char humanSymbol    = 'X';
    static char computerSymbol = 'O';

    static Scanner scanner = new Scanner(System.in);
    static Random  random  = new Random();

    /**
     * Entry point of the program. Demonstrates the structure
     * of a continuous game loop.
     */
    public static void main(String[] args) {

        initializeBoard();   // UC1
        printBoard();        // UC1

        // UC8 – game loop
        while (!gameOver) {

            if (isHumanTurn) {
                System.out.println("=== YOUR TURN ('" + humanSymbol + "') ===");
                humanTurn();
            } else {
                System.out.println("=== COMPUTER'S TURN ('" + computerSymbol + "') ===");
                computerTurn();
            }

            printBoard();

            // Determine whose symbol was just placed
            char currentSymbol = isHumanTurn ? humanSymbol : computerSymbol;

            // UC9 – check win (stub: replace with full hasWon() from UC9)
            if (hasWon(currentSymbol)) {
                if (isHumanTurn) {
                    System.out.println("You win! Congratulations!");
                } else {
                    System.out.println("Computer wins! Better luck next time.");
                }
                gameOver = true;

                // UC10 – check draw (stub: replace with full isDraw() from UC10)
            } else if (isDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;

            } else {
                // Switch turn
                isHumanTurn = !isHumanTurn;
            }
        }

        System.out.println("Game over. Thanks for playing!");
        scanner.close();
    }

    // -------------------------------------------------------
    // Human turn: read slot, convert, validate, place
    // -------------------------------------------------------
    static void humanTurn() {
        int row, col;
        while (true) {
            System.out.print("Enter slot (1-9): ");
            int slot = scanner.nextInt();

            if (slot < 1 || slot > 9) {
                System.out.println("Please enter a number between 1 and 9.");
                continue;
            }

            row = (slot - 1) / 3;   // UC4
            col = (slot - 1) % 3;   // UC4

            if (isValidMove(row, col)) {   // UC5
                board[row][col] = humanSymbol;  // UC6
                break;
            } else {
                System.out.println("Cell occupied or invalid. Try again.");
            }
        }
    }

    // -------------------------------------------------------
    // Computer turn: random valid slot (UC7)
    // -------------------------------------------------------
    static void computerTurn() {
        int row, col;
        do {
            int slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (!isValidMove(row, col));

        board[row][col] = computerSymbol;
        System.out.println("Computer placed '" + computerSymbol + "'.");
    }

    // -------------------------------------------------------
    // UC1 helpers
    // -------------------------------------------------------
    static void initializeBoard() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                board[r][c] = '-';
    }

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

    // -------------------------------------------------------
    // UC5 helper
    // -------------------------------------------------------
    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row <= 2 && col >= 0 && col <= 2 && board[row][col] == '-');
    }

    // -------------------------------------------------------
    // UC9 stub – win check (full version in UC9_CheckWin.java)
    // -------------------------------------------------------
    static boolean hasWon(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    // -------------------------------------------------------
    // UC10 stub – draw check (full version in UC10_DrawCondition.java)
    // -------------------------------------------------------
    static boolean isDraw() {
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                if (board[r][c] == '-') return false;
        return true;
    }
}