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
    private final Board board;
    private final boolean isGameBoard = true;

    /**
     * Constructor for the class Match.
     */
    public Match() {
        board = new Board(isGameBoard);
    }

    /**
     * Method to set the move.
     * @param move The move.
     */
    public void setMove(final Move move) {
        this.moves.push(move);
    }

    /**
     * Method to get the moves.
     * @return The moves stack.
     */
    public Stack<Move> getMoves() {
        Stack<Move> clonedMoves = new Stack<>();
        clonedMoves.addAll(this.moves);
        return clonedMoves;
    }
}
