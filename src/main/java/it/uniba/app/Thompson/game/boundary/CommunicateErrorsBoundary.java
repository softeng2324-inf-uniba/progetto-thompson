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
     * Print invalid command.
     * Print to stdout the invalid command message.
     */
    public void printInvalidCommand() {
        System.out.println(ErrorMessages.INVALID_COMMAND);
    }

    /**
     * Print invalid input.
     * Print to stdout the invalid input message.
     */
    public void printInvalidInput() {
        System.out.println(ErrorMessages.INVALID_INPUT);
    }

    /**
     * Print match not null.
     * Print to stdout the match not null message.
     */
    public static void printMatchNotNull() {
        System.out.println(ErrorMessages.MATCH_NOT_NULL);
    }

    /**
     * Print suggest match init.
     * Print to stdout the suggest match init message.
     */
    public static void printSuggestMatchInit() {
        System.out.println(ErrorMessages.SUGGEST_MATCH_INIT);
    }
}
