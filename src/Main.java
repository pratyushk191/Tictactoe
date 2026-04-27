import java.util.Scanner;

/**
 * UC3: Accept User Slot Input (1–9)
 * -----------------------------------
 * Goal   : Allow the user to enter a slot number between 1 and 9.
 * Actor  : Human Player
 * Flow   : User enters slot number → program reads input → control returns to game logic.
 *
 * Key Concepts:
 *   - User Input Handling
 *   - Method Creation
 *   - Separation of Concerns
 */
public class Main {

    /**
     * Entry point of the program. Reads slot input and prints it back
     * to verify correct user input handling.
     */
    public static void main(String[] args) {
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    /**
     * Reads an integer slot value from the user.
     * Input  : Scanner object (console)
     * Output : Slot number (1–9)
     * Hint   : Validation will be added in later use cases (UC5).
     */
    static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your slot number (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }
}