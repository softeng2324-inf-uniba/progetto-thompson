package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * << Entity >>
 * Class Pawn.
 */
public final class Pawn {

    /**
     * Attributes of Pawn.
     */
    private Color color;

    /**
     * Constructor for the class Pawn.
     * @param player The player
     */
    private Pawn(final Player player) {
        this.color = player.getColor();
    }

    /**
     * Method to set the color of the pawn.
     * @param pawnColor color of the pawn
     */
    public void setColor(final Color pawnColor) {
        color = pawnColor;
    }

    /**
     * Method to get the color of the pawn.
     * @return the color of the pawn
     */
    public Color getColor() {
        return color;
    }
}
