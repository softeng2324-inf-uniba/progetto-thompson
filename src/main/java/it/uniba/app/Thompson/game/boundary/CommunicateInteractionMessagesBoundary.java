package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.FormatterControl;
import it.uniba.app.Thompson.game.control.MainControl;
import it.uniba.app.Thompson.game.util.Color;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.Style;
import it.uniba.app.Thompson.game.util.UserInteractionMessages;

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
     * Method printMessage, prints to stdout the message.
     * @param time The message to print
     */
    public static void printMessage(final String time) {
        System.out.println(FORMATTER_CONTROL.formatText("Il tempo trascorso dalla partenza della partita è: "
                + MainControl.getMatch().getFormattedTime(), Color.BLUE));

    }
}
