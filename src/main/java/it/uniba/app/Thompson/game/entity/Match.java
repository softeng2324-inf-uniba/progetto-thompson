package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.util.PawnFigure;
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
    private PawnFigure turn;
    private final Queue<Move> moves = new LinkedList<>();
    private final Board board;
    private static final boolean IS_GAME_BOARD = true;
    private static long startTime = setStartTime();
    private static String elapsedTime;
    private static final int SECONDS = 60;
    private static final int MILLIS = 1000;

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
     * Method setStartTime.
     * @return startTime The start time
     */
    public static long setStartTime() {
        startTime = System.currentTimeMillis();
        return startTime;
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
     * @return clonedMoves The clone of the moves queue
     */
    public Queue<Move> getMoves() {
        Queue<Move> clonedMoves = new LinkedList<>();
        clonedMoves.addAll(this.moves);
        return clonedMoves;
    }

    /**
     * Method getCurrentTurn.
     * @return Get the match current turn
     */
    public PawnFigure getCurrentTurn() {
        return turn;
    }

    /**
     * Method switchTurn, if turn is white it will be changed to black, the same goes with the opposite ones.
     */
    public void switchTurn() {
       this.turn = this.turn == PawnFigure.BLACK_PAWN ? PawnFigure.WHITE_PAWN : PawnFigure.BLACK_PAWN;
    }
      
     /*
     * Method getFormattedTime.
     * @return elapsedTime The formatted time
     */
    public static String getFormattedTime() {
        elapsedTime = formatMillis(System.currentTimeMillis() - startTime);
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
