package it.uniba.app.Thompson.game.boundary;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * {@literal << Boundary >>}
 * Class to get user input.
 */
public final class UserInputBoundary {

    /**
     * Attributes of the class UserInputBoundary.
     */
    private static final Scanner SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * Constructor for the class UserInputBoundary.
     */
    private UserInputBoundary() { }

    /**
     * Method getInput.
     * @return Returns the input from the user
     */
    public static String getInput() {
        System.out.print("\n>");
        return SCANNER.nextLine().trim().toLowerCase();
    }

    /**
     * Method getCommandAndArguments.
     * @return Returns array of string from user input split by blank space
     */
    public static String[] getCommandAndArguments() {
        System.out.print("\n>");
        return SCANNER.nextLine().toLowerCase().split(" ");
    }

    /**
     * Method closeScanner.
     */
    public static void closeScanner() {
        SCANNER.close();
    }
}
