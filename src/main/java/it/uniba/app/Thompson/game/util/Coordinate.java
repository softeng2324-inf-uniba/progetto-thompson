package it.uniba.app.Thompson.game.util;

/**
 * << Util >>
 * Stores x and y position.
 */
public final class Coordinate {

    /**
     * Attributes of Coordinate.
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
     * Method to get the y coordinate.
     * @return y The y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Method to get the x coordinate.
     * @return x The x coordinate
     */
    public int getX() {
        return x;
    }
}
