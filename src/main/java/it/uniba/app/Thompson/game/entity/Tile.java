package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * << Entity >>
 *  Class Tile.
 */
public class Tile {

    /**
     * Attributes of Tile.
     */
    private final Coordinate coordinate;
    private boolean occupied = false;
    private boolean invalid = false;

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

    /**
     * Method isOccupied.
     * @return occupied boolean
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Method isOccupied.
     * @param state boolean
     */
    public void setOccupied(final boolean state) {
        occupied = state;
    }
}
