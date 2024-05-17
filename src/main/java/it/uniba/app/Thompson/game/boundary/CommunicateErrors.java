package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.util.ErrorMessages;

/**
 * << Boundary >>
 * Class to communicate errors.
 */
public final class CommunicateErrors {
    /**
     * Constructor for CommunicateErrors.
     */
    private CommunicateErrors() { }
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
}
