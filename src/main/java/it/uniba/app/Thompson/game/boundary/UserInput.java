package main.java.it.uniba.app.Thompson.game.boundary;
import java.util.Scanner;
/**
 * << Boundary >>
 * Class to get user input.
 */
public final class UserInput {
    /**
     * Constructor for UserInput.
     */
    private UserInput() { }
    /**
     * Get input.
     * @return The input from the user.
     */
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
