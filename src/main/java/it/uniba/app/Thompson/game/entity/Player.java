package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Color;

/**
 * << Entity >>
 * Class Player.
 */
public final class Player {

    /**
     * Attributes of Player.
     */
    private final Color pawnColor;

    /**
     * Constructor for the class Player.
     */
    private Player(final Color color) {
        pawnColor = color;
    }

    /**
     * Method to get the color of the pawns.
     * @return the color of the pawns
     */
    public Color getColor() {
        return pawnColor;
    }

    /**
     * Method to invalidate a cell.
     * @param tile the cell to invalidate
     */
    public void invalidateTile(final Tile tile) {
        tile.setInvalid(true);
    }

    /*
    /**
     * Method to get the number of pawns.
     * @return the number of pawns
     * /
    public int getPawnNumber() {
        return ;
    }
    /**
     * Method to set the number of pawns.
     * @param numPedine number of pawns
     * /
    private void setPawnNumber(final int numPedine) {
        this.numeroPedine = numPedine;
    }
    */
}
