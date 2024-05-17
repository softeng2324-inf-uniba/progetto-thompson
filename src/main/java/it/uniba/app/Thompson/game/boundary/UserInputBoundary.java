package it.uniba.app.Thompson.game.boundary;
import java.util.Scanner;

/**
 * << Boundary >>
 * Class to get user input.
 */
public final class UserInputBoundary {
    private static final Scanner SCANNER = new Scanner(System.in);
    /**
     * Constructor for UserInput.
     */
    private UserInputBoundary() { }
    /**
     * Get input.
     * @return The input from the user.
     */
    public static String getInput() {
        return SCANNER.nextLine();
    }
    /**
     * Close the SCANNER.
     */
    public static void closeScanner() {
        SCANNER.close();
    }
}
