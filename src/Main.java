import java.util.Random;

/**
 * UC2: Toss to Decide First Player and Symbol
 * ---------------------------------------------
 * Goal   : Randomly decide who plays first and assign symbols (X or O).
 * Actor  : Game System
 * Flow   : Game starts → system performs toss → assigns symbols → decides first turn.
 *
 * Key Concepts:
 *   - Random Number Generation
 *   - Conditional Logic
 *   - Game State Variables
 */
public class Main {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program. Executes the toss logic and displays
     * the result of turn and symbol assignment.
     */
    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
    }

    /**
     * Uses random logic to decide the first player and assigns symbols
     * based on the toss outcome. This method initialises the game state.
     * <p>
     * Toss result 0 → Human goes first and gets 'X'
     * Toss result 1 → Computer goes first and gets 'X'
     */
    static void tossAndAssignSymbols() {
        Random random = new Random();
        int toss = random.nextInt(2);   // generates 0 or 1

        if (toss == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        } else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    /**
     * Displays the toss result, indicating who plays first and which
     * symbol is assigned to each player.
     */
    static void displayTossResult() {
        System.out.println("===== TOSS RESULT =====");
        System.out.println("Human    plays : " + humanSymbol);
        System.out.println("Computer plays : " + computerSymbol);
        if (isHumanTurn) {
            System.out.println("Result : Human goes FIRST!");
        } else {
            System.out.println("Result : Computer goes FIRST!");
        }
        System.out.println("=======================");
    }
}