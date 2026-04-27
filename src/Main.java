public class Main {

    // Sample board pre-filled to test validation
    static char[][] board = {
            {'-', 'X', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    /**
     * Entry point of the program. Tests the validation logic
     * using sample row and column values.
     */
    public static void main(String[] args) {

        // Test 1: valid empty cell
        System.out.println("Test (row=0, col=0) → " + isValidMove(0, 0));   // true

        // Test 2: occupied cell
        System.out.println("Test (row=0, col=1) → " + isValidMove(0, 1));   // false (has 'X')

        // Test 3: out of bounds
        System.out.println("Test (row=3, col=0) → " + isValidMove(3, 0));   // false

        // Test 4: negative index
        System.out.println("Test (row=-1,col=0) → " + isValidMove(-1, 0));  // false
    }

    /**
     * Checks if the given row and column are within bounds (0–2)
     * and if the target cell is empty ('-').
     * Input  : Row, Column
     * Output : true if valid, false otherwise
     */
    static boolean isValidMove(int row, int col) {
        // Boundary check
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("  → Out of bounds!");
            return false;
        }
        // Cell occupancy check
        if (board[row][col] != '-') {
            System.out.println("  → Cell already occupied!");
            return false;
        }
        System.out.println("  → Valid move!");
        return true;
    }
}