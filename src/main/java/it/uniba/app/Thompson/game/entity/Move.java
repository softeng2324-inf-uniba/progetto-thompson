package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.MoveTypes;

/**
 * <<Entity>>
 * Class Move.
 */
public final class Move {

    /**
     * Attributes of Move.
     */
    private final Coordinate from;
    private final Coordinate to;

    /**
     * Constructor for the class Move.
     * @param start the start coordinate
     * @param end the end coordinate
     */
    private Move(final Coordinate start, final Coordinate end) {
        from = start;
        to = end;
    }
}
