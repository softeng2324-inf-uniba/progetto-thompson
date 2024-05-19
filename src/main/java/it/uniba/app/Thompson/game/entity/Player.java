package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * {@literal << Entity >>}
 * Class representing the player entity.
 */
public final class Player {

    /**
     * Attributes of the class Player.
     */
    private final Color pawnColor;

    /**
     * Constructor for the class Player.
     */
    private Player(final Color color) {
        pawnColor = color;
    }

    /**
     * Method getColor.
     * @return pawnColor The color of the pawn
     */
    public Color getColor() {
        return pawnColor;
    }

    /**
     * Method invalidateTile.
     * @param tile The tile to invalidate
     */
    public void invalidateTile(final Tile tile) {
        tile.setInvalid();
    }
}
