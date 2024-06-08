package it.uniba.app.Thompson.game.error;

/**
 * {@literal << Error >>}
 * Class to throw an error when the command is not found.
 */
public class TileIsOccupied extends Exception {

    /**
     * Constructor for the class CommandNotFound.
     */
    public TileIsOccupied() {
        super("TILE_IS_OCCUPIED");
    }
}

