package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when there are too many blocked tiles.
 */
public class ExcessBlockedTile extends Exception {

    /**
     * Constructor for the class ExcessBlockedTile.
     */
    public ExcessBlockedTile() {
        super("EXCESS_BLOCKED_TILE_ERROR");
    }
}
