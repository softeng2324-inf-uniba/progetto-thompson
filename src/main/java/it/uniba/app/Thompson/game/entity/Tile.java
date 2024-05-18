package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;

/**
 * << Entity >>
 *  Class Tile.
 */
public class Tile {

    /**
     * Attributes of Tile.
     */
    private final Coordinate coordinate;
    private boolean invalid = false;
    private Pawn pawn;

    /**
     * Constructor Tile.
     */
    public Tile(final int coordX, final int coordY) {
        coordinate = new Coordinate(coordX, coordY);
    }

    /**
     * Method getX.
     * @return x int
     */
    public int getX() {
        return coordinate.getX();
    }

    /**
     * Method getY.
     * @return y int
     */
    public int getY() {
        return coordinate.getY();
    }

    /**
     * Method placePawn.
     * @param pawnFigure Figure of the pawn to be placed.
     */
    public void placePawn(final PawnFigure pawnFigure) {
        pawn = new Pawn(pawnFigure);
    }

    /**
     * Method removePawn to displace a pawn from a tile.
     */
    public void removePawn() {
        pawn = null;
    }

    /**
     * Method getPawn.
     * @return pawn Pawn
     */
    public Pawn getPawn() {
        return pawn;
    }

    /**
     * Method isOccupied.
     * @return pawn Return true if tile is occupied by pawn.
     */
    public boolean isOccupied() {
        return pawn != null;
    }

    /**
     * Method isInvalid.
     * @return invalid boolean
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * Method setInvalid.
     * @param state boolean
     */
    public void setInvalid(final boolean state) {
        invalid = state;
    }
}
