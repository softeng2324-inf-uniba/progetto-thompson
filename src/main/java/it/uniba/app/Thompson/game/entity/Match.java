package it.uniba.app.Thompson.game.entity;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * {@literal << Entity >>}
 * Class representing the match entity.
 */
public class Match {

    /**
     * Attributes of the class Match.
     */
    private final Queue<Move> moves = new LinkedList<>();
    private final Board board;
    private static final boolean IS_GAME_BOARD = true;

    /**
     * Constructor for the class Match.
     */
    public Match() {
        board = new Board(IS_GAME_BOARD);
    }

    /**
     * Defensive copy Constructor for the class Match.
     * @param newBoard The original board
     * @param newMoves The original moves
     */
    public Match(final Board newBoard, final Stack<Move> newMoves) {
        board = new Board(newBoard);
        moves.addAll(newMoves);
    }

    /**
     * Method pushMove.
     * @param move The move that will be pushed at the end of the queue
     */
    public void pushMove(final Move move) {
        this.moves.add(move);
    }

    /**
     * Method getBoard.
     * @return board The board
     */
    public Board getBoard() {
        return new Board(board);
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
