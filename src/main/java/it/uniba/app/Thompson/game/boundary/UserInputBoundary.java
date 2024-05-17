package it.uniba.app.Thompson.game.boundary;
import java.util.Scanner;

/**
 * << Boundary >>
 * Class to get user input.
 */
public final class UserInputBoundary {
    /**
     * Constructor for UserInput.
     */
    private UserInputBoundary() { }
    /**
     * Get input.
     * @return The input from the user.
     */
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
