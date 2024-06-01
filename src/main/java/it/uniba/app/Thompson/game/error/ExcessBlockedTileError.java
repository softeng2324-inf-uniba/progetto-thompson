package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when there are too many blocked tiles.
 */
public class ExcessBlockedTileError extends Exception {

    /**
     * Constructor for the class ExcessBlockedTileError.
     */
    public ExcessBlockedTileError() {
        super("EXCESS_BLOCKED_TILE_ERROR");
    }
}
