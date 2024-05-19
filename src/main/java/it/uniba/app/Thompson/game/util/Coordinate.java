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
     * Method plus, elaborates the new coordinates.
     * @param x The first set of coordinates
     * @param y The second set of coordinates
     * @return Returns the sum of the two sets of coordinates.
     */
    public static Coordinate plus(final Coordinate x, final Coordinate y) {
        return new Coordinate(x.getX() + y.getX(), x.getY() + y.getY());
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
