package it.uniba.app.Thompson.game.entity;
import java.util.Stack;

/**
 * << Entity >>
 * Class Match.
 */
public class Match {

    /**
     * Attributes of Match.
     */
    private final Stack<Move> moves = new Stack<>();

    /**
     * Constructor for the class Match.
     */
    public Match() {

    }

    /**
     * Method to set the move.
     * @param move the move
     */
    public void setMove(final Move move) {
        this.moves.push(move);
    }

    /**
     * Method to get the moves.
     * @return the moves stack
     */
    public Stack<Move> getMoves() {
        return this.moves;
    }
}
