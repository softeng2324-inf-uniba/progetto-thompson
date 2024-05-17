package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * <<Entity>>
 * Class Pawn.
 */
public final class Pawn {

    /**
     * Attributes of Pawn.
     */
    private Color colorePawn;

    /**
     * Method to set the color of the pawn.
     * @param pawnColor color of the pawn
     */
    public void setColorePawn(final Color pawnColor) {
        this.colorePawn = pawnColor;
    }

    /**
     * Method to get the color of the pawn.
     * @return the color of the pawn
     */
    public Color getColorePawn() {
        return this.colorePawn;
    }

    /**
     * Constructor Pawn.
     * @param player The player
     */
    private Pawn(final Player player) {
        this.colorePawn = player.getColorePedine();
    }

    /**
     * Constructor Pawn.
     */
    private Pawn() {
    }
}
