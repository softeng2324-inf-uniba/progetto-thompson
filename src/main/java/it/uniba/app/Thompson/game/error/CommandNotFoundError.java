package it.uniba.app.Thompson.game.error;

/**
 * Error to be displayed when an inserted command is not recognized
 */
public class CommandNotFoundError extends Exception {
    public CommandNotFoundError() {
        super("COMMAND_NOT_FOUND_ERROR");
    }
}