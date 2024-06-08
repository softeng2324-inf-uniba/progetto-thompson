package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * {@literal << Entity >>}
 * Class representing the player entity.
 */
public final class PlayerE {

    /**
     * Attributes of the class PlayerE.
     */
    private final Color pawnColor;

    /**
     * Constructor for the class PlayerE.
     */
    private PlayerE(final Color color) {
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
    public void invalidateTile(final TileE tile) {
        tile.setInvalid();
    }
}
