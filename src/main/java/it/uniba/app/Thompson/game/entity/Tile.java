package it.uniba.app.Thompson.game.entity;
/**
 * <<Entity>>
 *  Class Tile.
 */
public class Tile {

    /**
     * Attributes of Tile.
     */
    private final int x;
    private final int y;
    private boolean invalid = false;
    private boolean occupied = false;

    /**
     * Method getX.
     * @return x int
     */
    public int getX() {
        return x;
    }

    /**
     * Method getY.
     * @return y int
     */
    public int getY() {
        return y;
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
    public void setInvalid(boolean state) {
        this.invalid = state;
    }

    /**
     * Method isOccupied.
     * @param occupied boolean
     */
    public void isOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    /**
     * Costructor Tile.
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
