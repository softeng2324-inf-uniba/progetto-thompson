package it.uniba.app.Thompson.game.entity;
import java.util.Stack;

/**
 * {@literal << Entity >>}
 * Class representing the match entity.
 */
public class Match {

    /**
     * Attributes of the class Match.
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
     * Method setMove.
     * @param move The move
     */
    public void setMove(final Move move) {
        this.moves.push(move);
    }

    /**
     * Method getBoard.
     * @return board The board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Method getMoves.
     * @return clonedMoves The clone of the moves stack
     */
    public Stack<Move> getMoves() {
        Stack<Move> clonedMoves = new Stack<>();
        clonedMoves.addAll(this.moves);
        return clonedMoves;
    }
}
