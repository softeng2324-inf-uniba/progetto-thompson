package it.uniba.app.Thompson.game.boundary;
import java.util.Scanner;

/**
 * << Boundary >>
 * Class to get user input.
 */
public final class UserInputBoundary {

    /**
     * Scanner for input.
     */
    private static final Scanner SCANNER = new Scanner(System.in, "UTF-8");

    /**
     * Constructor for UserInput.
     */
    private UserInputBoundary() { }

    /**
     * Get input.
     * @return The input from the user.
     */
    public static String getInput() {
        System.out.print("\n->");
        return SCANNER.nextLine().trim().toLowerCase();
    }

    /**
     * Closes the SCANNER.
     */
    public static void closeScanner() {
        SCANNER.close();
    }
}
