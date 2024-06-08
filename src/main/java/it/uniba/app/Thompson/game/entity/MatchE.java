package it.uniba.app.Thompson.game.entity;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesB;
import it.uniba.app.Thompson.game.error.NegativeTime;
import it.uniba.app.Thompson.game.util.PawnFigure;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@literal << Entity >>}
 * Class representing the match entity.
 */
public class MatchE {

    /**
     * Attributes of the class MatchE.
     */
    private PawnFigure turn;
    private final Queue<MoveE> moves = new LinkedList<>();
    private final BoardE board;
    private static final boolean IS_GAME_BOARD = true;
    private static long startTime = setStartTime();
    private static String elapsedTime;
    private static final int SECONDS = 60;
    private static final int MILLIS = 1000;

    /**
     * Constructor for the class MatchE.
     * @param blockBoard The board with the blocked tiles
     */
    public MatchE(final BoardE blockBoard) {
        board = new BoardE(blockBoard);
        turn = PawnFigure.BLACK_PAWN;
    }

    /**
     * Defensive copy Constructor for the class MatchE.
     * @param newBoard The original board
     * @param newMoves The original moves
     * @param newTurn The original turn
     */
    public MatchE(final BoardE newBoard, final Queue<MoveE> newMoves, final PawnFigure newTurn) {
        turn = newTurn;
        board = new BoardE(newBoard);
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
    public void pushMove(final MoveE move) {
        this.moves.add(move);
    }

    /**
     * Method getBoard.
     * @return board The board
     */
    public BoardE getBoard() {
        return new BoardE(board);
    }

    /**
     * Method setBoard.
     * @param newBoard The board to be set
     */
    public void setBoard(final BoardE newBoard) {
        board.setTiles(new BoardE(newBoard).getTiles());
    }

    /**
     * Method getMoves.
     * @return clonedMoves The clone of the moves queue
     */
    public Queue<MoveE> getMoves() {
        Queue<MoveE> clonedMoves = new LinkedList<>();
        clonedMoves.addAll(this.moves);
        return clonedMoves;
    }

    /**
     * Method getCurrentTurn.
     * @return Get the match current turn
     */
    public PawnFigure getCurrentTurn() {
        return this.turn;
    }

    /**
     * Method switchTurn, if turn is white it will be changed to black, the same goes with the opposite ones.
     */
    public void switchTurn() {
        PawnFigure newTurn = this.turn == PawnFigure.BLACK_PAWN ? PawnFigure.WHITE_PAWN : PawnFigure.BLACK_PAWN;
        CommunicateInteractionMessagesB.printTitle("ORA TOCCA AL "
                + (newTurn == PawnFigure.BLACK_PAWN ? "NERO" : "BIANCO"));
        this.turn = newTurn;
    }

    /**
     * Method getFormattedTime.
     * @return elapsedTime The formatted time
    */
    public static String getFormattedTime() throws NegativeTime {
        elapsedTime = formatMillis(System.currentTimeMillis() - startTime);
        return elapsedTime;
    }

    /**
     * Method formatMillis.
     * @param millis The milliseconds
     * @return Returns the formatted time
     */
    public static String formatMillis(final long millis) throws NegativeTime {
        if (millis < 0) throw new NegativeTime();

        long totalSeconds = millis / MILLIS;
        long seconds = totalSeconds % SECONDS;
        long totalMinutes = totalSeconds / SECONDS;
        long minutes = totalMinutes % SECONDS;
        long hours = totalMinutes / SECONDS;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
