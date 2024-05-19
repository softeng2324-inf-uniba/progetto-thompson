package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.util.ErrorMessages;

/**
 * << Boundary >>
 * Class to communicate errors.
 */
public final class CommunicateErrorsBoundary {

    /**
     * Constructor for CommunicateErrors.
     */
    private CommunicateErrorsBoundary() { }

    /**
     * Print match not null.
     * Print to stdout the match not null message.
     */
    public static void printMatchNotNull() {
        System.out.println(ErrorMessages.MATCH_NOT_NULL);
    }

    /**
     * Print match null.
     * Print to stdout the match null message.
     */
    public static void printMatchNull() {
        System.out.println(ErrorMessages.MATCH_NULL);
    }

    /**
     * Print invalid player.
     * Print to stdout the invalid player message.
     */
    public static void printInvalidPlayer() {
        System.out.println(ErrorMessages.INVALID_PLAYER);
    }

    /**
     * Print invalid choice.
     * Print to stdout the invalid choice message.
     */
    public static void printInvalidChoice() {
        System.out.println(ErrorMessages.INVALID_CHOICE);
    }
     
    /**
     * Print suggest match init.
     * Print to stdout the suggest match init message.
     */
    public static void printSuggestMatchInit() {
        System.out.println(ErrorMessages.SUGGEST_MATCH_INIT);
    }

    /**
     * Print suggest match init.
     * Print to stdout command not found message
     */
    public static void printCommandNotFound() {
        System.out.println("\n" + ErrorMessages.COMMAND_NOT_FOUND);
    }

    /**
     * Print suggest match init.
     * Print to stdout a generic error message
     */
    public static void printArgumentNotFound(String parameter) {
        System.out.println("\n" + parameter + "\t\t " + ErrorMessages.ARGUMENT_NOT_FOUND);
    }

    /**
     * Print suggest match init.
     * Print to stdout a generic error message
     */
    public static void printGenericError() {
        System.out.println("\n" + ErrorMessages.GENERIC_ERROR);
    }
}
