package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is followed by command.
 */
public class InvalidArgumentsError extends Exception {

    /**
     * Constructor for the class InvalidArgumentsError.
     */
    public InvalidArgumentsError() {
        super("INVALID_ARGUMENTS");
    }
}
