package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * {@literal << Entity >>}
 * Class representing the move entity.
 */
public final class MoveE {

    /**
     * Attributes of the class MoveE.
     */
    private final Coordinate from;
    private final Coordinate to;

    /**
     * Constructor for the class MoveE.
     * @param start The start coordinate
     * @param end The end coordinate
     */
    public MoveE(final Coordinate start, final Coordinate end) {
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
