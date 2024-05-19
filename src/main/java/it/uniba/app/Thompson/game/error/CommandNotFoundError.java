package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is not found.
 */
public class CommandNotFoundError extends Exception {

    /**
     * Constructor for the class CommandNotFoundError.
     */
    public CommandNotFoundError() {
        super("COMMAND_NOT_FOUND_ERROR");
    }
}
