package it.uniba.app.Thompson.game.boundary;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * {@literal << Boundary >>}
 * Class to get user input.
 */
public final class UserInputB {

    /**
     * Attributes of the class UserInputB.
     */
    private static Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * Constructor for the class UserInputB.
     */
    private UserInputB() { }

    /**
     * Method resetStdin.
     */
    public static void resetStdin() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    /**
     * Method getInput.
     * @return Returns the input from the user
     */
    public static String getInput() {
        System.out.print("\n>");
        return scanner.nextLine().trim().toLowerCase();
    }

    /**
     * Method getCommandAndArguments.
     * @return Returns array of string from user input split by blank space
     */
    public static String[] getCommandAndArguments() {
        System.out.print("\n>");

        return Arrays.stream(scanner.nextLine().toLowerCase().split(" "))
                .filter(s -> !s.isEmpty())
                .toList()
                .toArray(new String[0]);
    }

    /**
     * Method closeScanner.
     */
    public static void closeScanner() {
        scanner.close();
    }
}
