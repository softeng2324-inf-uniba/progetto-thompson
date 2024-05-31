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
    private static final boolean IS_GAME_BOARD = true;
    private static String startTime;
    private static String elapsedTime;
    private static final int SECONDS = 60;
    private static final int MILLIS = 1000;

    /**
     * Constructor for the class Match.
     */
    public Match() {
        board = new Board(IS_GAME_BOARD);
        startTime = String.valueOf(System.currentTimeMillis());
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

    /**
     * Method getFormattedTime.
     * @return elapsedTime The formatted time
     */
    public static String getFormattedTime() {
        elapsedTime = formatMillis(System.currentTimeMillis() - Long.parseLong(startTime));
        return elapsedTime;
    }

    /**
     * Method formatMillis.
     * @param millis The milliseconds
     * @return Returns the formatted time
     */
    public static String formatMillis(final long millis) {
        long totalSeconds = millis / MILLIS;
        long seconds = totalSeconds % SECONDS;
        long totalMinutes = totalSeconds / SECONDS;
        long minutes = totalMinutes % SECONDS;
        long hours = totalMinutes / SECONDS;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
