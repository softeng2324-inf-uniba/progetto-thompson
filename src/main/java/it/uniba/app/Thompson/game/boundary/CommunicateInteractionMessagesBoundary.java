package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterControl;
import it.uniba.app.Thompson.game.entity.Move;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.UserInteractionMessages;
import it.uniba.app.Thompson.game.util.Coordinate;
import java.util.Iterator;
import java.util.Queue;

/**
 * {@literal << Boundary >>}
 * Class to communicate interaction messages.
 */
public final class CommunicateInteractionMessagesBoundary {

    /**
     * Attributes of the class CommunicateInteractionMessagesBoundary.
     */
    private static final FormatterControl FORMATTER_CONTROL = new FormatterControl();

    /**
     * Constructor for the class CommunicateInteractionMessages.
     */
    private CommunicateInteractionMessagesBoundary() { }

    /**
     * Method printQuittingPlayer, prints to stdout the quitting player message.
     */
    public static void printQuittingPlayer() {
        System.out.println(UserInteractionMessages.QUITTING_PLAYER);
    }

    /**
     * Method printSureToQuit, prints to stdout the sure to quit message.
     */
    public static void printSureToQuit() {
        System.out.println(UserInteractionMessages.SURE_TO_QUIT);
    }

    /**
     * Method printAbortedQuit, prints to stdout the aborted quit message.
     */
    public static void printAbortedQuit() {
        System.out.println(UserInteractionMessages.ABORTED_QUIT);
    }

    /**
     * Method printWinner, prints to stdout the winner of the game.
     * @param winner The pawn figure of the winner of the game
     * @param winnerPawnCount The number of pawns of the winner
     * @param loserPawnCount The number of pawns of the loser
     */
    public static void printWinner(final PawnFigure winner, final int winnerPawnCount, final int loserPawnCount) {
        String scoreText = "Ha vinto il "
                + (winner == PawnFigure.BLACK_PAWN ? "nero " : "bianco ")
                + winnerPawnCount
                + " a "
                + loserPawnCount;

        System.out.println(FORMATTER_CONTROL.formatText(scoreText, Color.BLUE, Style.ITALIC));
    }

    /**
     * Method printSkipTurn, prints to stdout the skip turn message.
     */
    public static void printSkipTurn(final PawnFigure player) {
        System.out.println(UserInteractionMessages.SKIP_TURN  + (player == PawnFigure.BLACK_PAWN ? "bianco" : "nero"));
    }

     /**
     * Method printDraw, prints to stdout the draw message.
     */
    public static void printDraw(final int blackPawnCount, final int whitePawnCount) {
        System.out.println(FORMATTER_CONTROL.formatText("La partita è finita in pareggio con un punteggio di "
                + blackPawnCount
                + " a "
                + whitePawnCount, Color.BLUE, Style.ITALIC));
    }

    /**
     * Method printTitle, prints to stdout the title.
     * @param title The title to print
     */
    public static void printTitle(final String title) {
        System.out.println(">>>> " + FORMATTER_CONTROL.formatText(title, Style.BOLD) + "\n");
    }

    /**
     * Method printGoodbye.
     */
    public static void printGoodbye() {
        System.out.println(UserInteractionMessages.GOODBYE);
    }

    /**
     * Method printNewLine.
     */
    public static void printNewLine() {
        System.out.println();
    }

    /**
     * Method printMoves, print a queue of moves.
     * @param moves The queue containing all the moves of the game
     */
    public static void printMoves(final Queue<Move> moves) {
        if (moves.isEmpty()) {
            System.out.println(FORMATTER_CONTROL.formatText(
                    "Non sono state ancora effettuate delle mosse",
                    Color.ORANGE)
            );
        } else {

            Iterator<Move> movesIterator = moves.iterator();
            int moveCount = 1;

            // Iterating Queue
            while (movesIterator.hasNext()) {
                Move move = movesIterator.next();
                String stringMove = moveCount + " -> " + move.toString() + " " + (moveCount % 2 == 0 ? "(B)" : "(N)");

                System.out.println(FORMATTER_CONTROL.formatText(stringMove, Color.BLUE));

                moveCount++;
            }
        }
    }

    /**
     * Method printMessage, prints to stdout the message.
     * @param time The message to print
     */
    public static void printGameTime(final String time) {
        System.out.println(FORMATTER_CONTROL.formatText("Il tempo trascorso dalla partenza della partita è: "
                + time, Color.BLUE));

    }

    /**
     * Method printBlockedTile, prints to stdout the coordinates of the blocked tile.
     * @param blockedTile The coordinates of the blocked tile
     */
    public static void printBlockedTile(final Coordinate blockedTile) {
        System.out.println(FORMATTER_CONTROL.formatText("La casella di coordinate "
                + blockedTile.toString()
                + " e' stata bloccata", Color.BLUE));
    }

    /**
     * Method printSkippingTurn, prints to stdout the message of skipping turn.
     * @param player The player who skips the turn
     */
    public static void printSkippingTurn(final PawnFigure player) {
        System.out.println(FORMATTER_CONTROL.formatText("Il giocatore "
                + (player == PawnFigure.BLACK_PAWN ? "nero" : "bianco")
                + " salta il turno. Ora tocca al"
                + (player == PawnFigure.BLACK_PAWN ? "bianco" : "nero"), Color.ORANGE));
    }
}
