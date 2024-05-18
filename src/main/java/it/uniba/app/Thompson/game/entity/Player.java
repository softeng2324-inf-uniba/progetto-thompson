package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * <<Entity>>
 * Class Player.
 */
public final class Player {

    /**
     * Attributes of Player.
     */
    private final Color pawnColor;

    /**
     * Method to set the number of pawns.
     * @param numPedine number of pawns
     */
    private void setNumeroPedine(final int numPedine) {
        this.numeroPedine = numPedine;
    }

    /**
     * Method to get the color of the pawns.
     * @return the color of the pawns
     */
    public Color getColorePedine() {
        return COLOREPEDINE;
    }

    /**
     * Method to invalidate a cell.
     * @param tile the cell to invalidate
     */
    public void invalidateCasella(final Tile tile) {
        tile.setInvalid(true);
    }

    /**
     * Costructor Player.
     */
    private Player() {
    }
}
