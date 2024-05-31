package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * {@literal << Entity >>}
 * Class representing the move entity.
 */
public final class Move {

    /**
     * Attributes of the class Move.
     */
    private final Coordinate from;
    private final Coordinate to;

    /**
     * Constructor for the class Move.
     * @param start The start coordinate
     * @param end The end coordinate
     */
    private Move(final Coordinate start, final Coordinate end) {
        from = start;
        to = end;
    }

    /**
     * Method getFrom, to get the starting position of the move.
     * @return from The starting position
     */
    public Coordinate getFrom() {
        return  from;
    }

    /**
     * Method getTo, to get the arrival position of the move.
     * @return to The arrival position
     */
    public Coordinate getTo() {
        return  to;
    }

    /**
     * Method toString, stringify a move.
     * @return Returns move to string
     */
    public String toString() {
        return from.toString() + "-" + to.toString();
    }
}
