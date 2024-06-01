package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;

/**
 * {@literal << Entity >>}
 * Class representing the tile entity.
 */
public class Tile {

    /**
     * Attributes of the class Tile.
     */
    private final Coordinate coordinate;
    private boolean invalid = false;
    private Pawn pawn;

    /**
     * Constructor for the class Tile.
     * @param coordX The x coordinate of the tile
     * @param coordY The y coordinate of the tile
     */
    public Tile(final int coordX, final int coordY) {
        coordinate = new Coordinate(coordX, coordY);
    }

    /**
     * Constructor for the class Tile.
     * @param coordX The x coordinate of the tile
     * @param coordY The y coordinate of the tile
     */
    public Tile(final int coordX, final int coordY, boolean isTileInvalid) {
        coordinate = new Coordinate(coordX, coordY);
        invalid = isTileInvalid;
    }

    /**
     * Method getX.
     * @return x The x coordinate of the tile
     */
    public int getX() {
        return coordinate.getX();
    }

    /**
     * Method getY.
     * @return y The y coordinate of the tile
     */
    public int getY() {
        return coordinate.getY();
    }

    /**
     * Method getCoordinate.
     * @return coordinate of the tile.
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Method placePawn.
     * @param pawnFigure The figure of the pawn to be placed
     */
    public void placePawn(final PawnFigure pawnFigure) {
        pawn = new Pawn(pawnFigure);
    }

    /**
     * Method removePawn.
     */
    public void removePawn() {
        pawn = null;
    }

    /**
     * Method getPawn.
     * @return pawn The pawn on the tile
     */
    public Pawn getPawn() {
        return new Pawn(pawn.getFigure());
    }

    /**
     * Method isOccupied.
     * @return pawn Returns true if tile is occupied by a pawn
     */
    public boolean isOccupied() {
        return pawn != null;
    }

    /**
     * Method isInvalid.
     * @return invalid Returns true if tile is invalid
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * Method setInvalid.
     */
    public void setInvalid() {
        invalid = true;
    }
}
