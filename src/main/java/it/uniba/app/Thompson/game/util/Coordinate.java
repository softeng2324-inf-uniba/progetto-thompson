package it.uniba.app.Thompson.game.util;

/**
 * {@literal << Util >>}
 * Class for the management of the coordinates.
 */
public final class Coordinate {

    /**
     * Attributes of the class Coordinate.
     */
    private final int x;
    private final int y;

    /**
     * Constructor for the class Coordinate.
     * @param initX The x coordinate
     * @param initY The y coordinate
     */
    public Coordinate(final int initX, final int initY) {
        x = initX;
        y = initY;
    }

    /**
     * Method getX.
     * @return x The x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Method getY.
     * @return y The y coordinate
     */
    public int getY() {
        return y;
    }
}
