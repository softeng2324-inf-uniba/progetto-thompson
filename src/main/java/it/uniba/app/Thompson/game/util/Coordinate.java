package it.uniba.app.Thompson.game.util;

/**
 *  << Util >>
 *  Store x and y position.
 */
public final class Coordinate {

    /**
     * Attributes of Coordinate.
     */
    private final int x;
    private final int y;

    /**
     * Constructor for the class Coordinate.
     * @param initX the x coordinate
     * @param initY the y coordinate
     */
    public Coordinate(final int initX, final int initY) {
        x = initX;
        y = initY;
    }

    /**
     * Method to get the sum of two coordinates.
     * @param x int
     * @param y int
     * @return Coordinate the sum of the two coordinates.
     */
    public static Coordinate plus(final Coordinate x, final Coordinate y) {
        return new Coordinate(x.getX() + y.getX(), x.getY() + y.getY());
    }

    /**
     * Method to get the y coordinate.
     * @return y int
     */
    public int getY() {
        return y;
    }

    /**
     * Method to get the x coordinate.
     * @return x int
     */
    public int getX() {
        return x;
    }
}
