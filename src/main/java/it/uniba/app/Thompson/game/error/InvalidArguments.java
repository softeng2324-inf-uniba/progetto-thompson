package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is followed by command.
 */
public class InvalidArguments extends Exception {

    /**
     * Constructor for the class InvalidArguments.
     */
    public InvalidArguments() {
        super("INVALID_ARGUMENTS");
    }
}
