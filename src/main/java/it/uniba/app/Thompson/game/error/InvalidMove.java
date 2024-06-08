package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the movement is not valid.
 */
public class InvalidMove extends Exception {

    /**
     * Constructor for the class InvalidMove.
     */
    public InvalidMove() {
        super("INVALID_MOVE");
    }
}
