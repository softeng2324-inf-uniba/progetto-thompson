package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.util.ErrorMessages;

/**
 * {@literal << Boundary >>}
 * Class to communicate errors.
 */
public final class CommunicateErrorsBoundary {

    /**
     * Constructor for the class CommunicateErrors.
     */
    private CommunicateErrorsBoundary() { }

    /**
     * Method printInvalidCommand, prints to stdout the invalid command message.
     */
    public static void printInvalidCommand() {
        System.out.println(ErrorMessages.INVALID_COMMAND);
    }

    /**
     * Method printInvalidArgument, prints to stdout the invalid argument message.
     */
    public  static void printInvalidArgument() {
        System.out.println(ErrorMessages.INVALID_ARGUMENT);
    }

    /**
     * Method printMatchNotNull, prints to stdout the match not null message.
     */
    public static void printMatchNotNull() {
        System.out.println(ErrorMessages.MATCH_NOT_NULL);
    }

    /**
     * Method printMatchNull, prints to stdout the match null message.
     */
    public static void printMatchNull() {
        System.out.println(ErrorMessages.MATCH_NULL);
    }

    /**
     * Method printInvalidPlayer, prints to stdout the invalid player message.
     */
    public static void printInvalidPlayer() {
        System.out.println(ErrorMessages.INVALID_PLAYER);
    }

    /**
     * Method printInvalidChoice, prints to stdout the invalid choice message.
     */
    public static void printInvalidChoice() {
        System.out.println(ErrorMessages.INVALID_CHOICE);
    }

    /**
     * Method printSuggestMatchInit, prints to stdout the suggest match init message.
     */
    public static void printSuggestMatchInit() {
        System.out.println(ErrorMessages.SUGGEST_MATCH_INIT);
    }

    /**
     * Print suggest match init.
     * Print to stdout command not found message
     */
    public static void printCommandNotFound() {
        System.out.println(ErrorMessages.COMMAND_NOT_FOUND);
    }

    /**
     * Print suggest match init.
     * Print to stdout a generic error message
     */
    public static void printArgumentNotFound(String parameter) {
        System.out.println(parameter + "\t\t " + ErrorMessages.ARGUMENT_NOT_FOUND);
    }

    /**
     * Print suggest match init.
     * Print to stdout a generic error message
     */
    public static void printGenericError() {
        System.out.println(ErrorMessages.GENERIC_ERROR);
    }
}
