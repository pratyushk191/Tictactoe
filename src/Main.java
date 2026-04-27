public class Main {

    /**
     * Entry point of the program. Demonstrates slot-to-index conversion
     * using a sample slot value.
     */
    public static void main(String[] args) {
        int slot = 7;   // sample slot to test
        System.out.println("Slot   : " + slot);
        System.out.println("Row    : " + getRowFromSlot(slot));
        System.out.println("Column : " + getColFromSlot(slot));

        // Test all slots 1–9
        System.out.println("\n--- Full Mapping Table ---");
        System.out.println("Slot | Row | Col");
        System.out.println("-----------------");
        for (int s = 1; s <= 9; s++) {
            System.out.println("  " + s + "  |  " + getRowFromSlot(s) + "  |  " + getColFromSlot(s));
        }
    }

    /**
     * Converts slot number into row index using zero-based indexing.
     * Input  : Slot number (1–9)
     * Output : Row index (0–2)
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * Converts slot number into column index using modulo operation.
     * Input  : Slot number (1–9)
     * Output : Column index (0–2)
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }
}