package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is followed by command.
 */
public class InvalidCoordinate extends Exception {

    /**
     * Constructor for the class InvalidArguments.
     */
    public InvalidCoordinate() {
        super("INVALID_COORDINATE");
    }
}
