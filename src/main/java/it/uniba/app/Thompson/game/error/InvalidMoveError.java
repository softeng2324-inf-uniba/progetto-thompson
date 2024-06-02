package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the movement is not valid.
 */
public class InvalidMoveError extends Exception {

    /**
     * Constructor for the class InvalidMoveError.
     */
    public InvalidMoveError() {
        super("INVALID_MOVE");
    }
}
