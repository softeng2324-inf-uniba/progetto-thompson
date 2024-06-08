package it.uniba.app.Thompson.game.util;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@literal << Util >>}
 * Class to manage of the coordinates.
 */
public final class Coordinate {

    /**
     * Attributes of the class Coordinate.
     */
    private final int x;
    private final int y;
    private static final String BLOCK = "[a-z|A-Z][1-9]";

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
     * @return Returns the sum of the two sets of coordinates
     */
    public static Coordinate plus(final Coordinate x, final Coordinate y) {
        return new Coordinate(x.getX() + y.getX(), x.getY() + y.getY());
    }

    /**
     * Method abs, elaborates the new coordinates.
     * @param x The first set of coordinates
     * @param y The second set of coordinates
     * @return Returns the absolute value of the sum of the two sets of coordinates
     */
    public static Coordinate abs(final Coordinate x, final Coordinate y) {
        return new Coordinate(Math.abs(x.getX() - y.getX()), Math.abs(x.getY() - y.getY()));
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

    /**
     * Method toCoordinate.
     * @param stringCoordinate The first coordinate in string
     * @return Returns a new coordinate made of the two characters
     */
    public static Coordinate toCoordinate(final String stringCoordinate) throws InvalidCoordinate {
        Pattern pattern = Pattern.compile(BLOCK);
        Matcher matcher = pattern.matcher(stringCoordinate);

        if (!matcher.matches()) {
            throw new InvalidCoordinate();
        }

        int letter = stringCoordinate.charAt(0) - 'a';
        int number = Character.getNumericValue(stringCoordinate.charAt(1)) - 1;

        return new Coordinate(letter, number);
    }

    /**
     * Method toString, stringify a coordinate.
     * @return Returns coordinate to string
     */
    public String toString() {
        final int asciiCharValue = 65;
        char xChar = (char) (x + asciiCharValue);

        return Character.toLowerCase(xChar) + "" + (y + 1);
    }

    /*
     * Method equals.
     * Override of the equals method of the Object class.
     * @param obj The object to compare
     * @return Returns true if the coordinates are equal, false otherwise
     */
    @Override
    public boolean equals(final Object obj) {
        boolean equal = false;
        if (obj instanceof Coordinate cord) {
            if (this.getX() == cord.x && this.getY() == cord.y) {
                equal = true;
            }
        }
        return equal;
    }

    /**
     * Method hashCode.
     * Override of the hashCode method of the Object class.
     * @return Returns the hash code of the coordinates
     */
    @Override
    public int hashCode() {
        return x + y;
    }
}



