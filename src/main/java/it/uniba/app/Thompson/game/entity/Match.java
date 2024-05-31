package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * {@literal << Entity >>}
 * Class representing the match entity.
 */
public class Match {

    /**
     * Attributes of the class Match.
     */
    private PawnFigure turn;
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
    public Match(final Board newBoard, final Queue<Move> newMoves) {
        turn = PawnFigure.BLACK_PAWN;
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
    public Queue<Move> getMoves() {
        Queue<Move> clonedMoves = new LinkedList<>();
        clonedMoves.addAll(this.moves);
        return clonedMoves;
    }

    /**
     * Get current turn
     * @return Get the match current turn
     */
    public PawnFigure getCurrentTurn() {
        return turn;
    }
}
