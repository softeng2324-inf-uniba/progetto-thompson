package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is not found.
 */
public class CommandNotFound extends Exception {

    /**
     * Constructor for the class CommandNotFound.
     */
    public CommandNotFound() {
        super("COMMAND_NOT_FOUND_ERROR");
    }
}
