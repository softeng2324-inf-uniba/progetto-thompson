package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is not found.
 */
public class TileAlreadyBlocked extends Exception {

    /**
     * Constructor for the class CommandNotFound.
     */
    public TileAlreadyBlocked() {
        super("TILE_ALREADY_BLOCKED");
    }
}
