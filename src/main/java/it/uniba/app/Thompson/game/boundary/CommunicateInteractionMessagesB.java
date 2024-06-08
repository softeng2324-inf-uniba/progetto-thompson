package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterC;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.UserInteractionMessage;

import java.util.Iterator;
import java.util.Queue;

/**
 * {@literal << Boundary >>}
 * Class to communicate interaction messages.
 */
public final class CommunicateInteractionMessagesB {

    /**
     * Attributes of the class CommunicateInteractionMessagesB.
     */
    private static final FormatterC FORMATTER_CONTROL = new FormatterC();

    /**
     * Constructor for the class CommunicateInteractionMessages.
     */
    private CommunicateInteractionMessagesB() { }

    /**
     * Method printQuittingPlayer, prints to stdout the quitting player message.
     */
    public static void printQuittingPlayer() {
        System.out.println(UserInteractionMessage.QUITTING_PLAYER);
    }

    /**
     * Method printSureToQuit, prints to stdout the sure to quit message.
     */
    public static void printSureToQuit() {
        System.out.println(UserInteractionMessage.SURE_TO_QUIT);
    }

    /**
     * Method printAbortedQuit, prints to stdout the aborted quit message.
     */
    public static void printAbortedQuit() {
        System.out.println(UserInteractionMessage.ABORTED_QUIT);
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
     * Method printDraw, prints to stdout the draw message.
      * @param blackPawnCount Black pawn
      * @param whitePawnCount White pawn
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
        System.out.println(UserInteractionMessage.GOODBYE);
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
    public static void printMoves(final Queue<MoveE> moves) {
        if (moves.isEmpty()) {
            System.out.println(FORMATTER_CONTROL.formatText(
                    "Non sono state ancora effettuate delle mosse",
                    Color.ORANGE)
            );
        } else {

            Iterator<MoveE> movesIterator = moves.iterator();
            int moveCount = 1;

            // Iterating Queue
            while (movesIterator.hasNext()) {
                MoveE move = movesIterator.next();
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
        System.out.println(FORMATTER_CONTROL.formatText("Il tempo trascorso dalla partenza della partita e': "
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
                + " salta il turno. Ora tocca al "
                + (player == PawnFigure.BLACK_PAWN ? "bianco" : "nero"), Color.ORANGE));
    }
}
