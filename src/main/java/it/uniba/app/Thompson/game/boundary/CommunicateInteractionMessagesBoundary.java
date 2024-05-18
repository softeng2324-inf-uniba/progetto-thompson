package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.UserInteractionMessages;

/**
 * << Boundary >>
 * Class to communicate interaction messages.
 */
public final class CommunicateInteractionMessagesBoundary {

    /**
     * Constructor for CommunicateInteractionMessages.
     */
    private CommunicateInteractionMessagesBoundary() { }

    /**
     * Print quitting player.
     * Print to stdout the quitting player message.
     */
    public static void printQuittingPlayer() {
        System.out.println(UserInteractionMessages.QUITTING_PLAYER);
    }

    /**
     * Print sure to quit.
     * Print to stdout the sure to quit message.
     */
    public static void printSureToQuit() {
        System.out.println(UserInteractionMessages.SURE_TO_QUIT);
    }

    /**
     * Print aborted quit.
     * Print to stdout the aborted quit message.
     */
    public static void printAbortedQuit() {
        System.out.println(UserInteractionMessages.ABORTED_QUIT);
    }

    /**
     * Print the winner of the game.
     * Print to stdout the winner of the game.
     */
    public static void printWinner(final PawnFigure winner, final int winnerPawnCount, final int loserPawnCount) {
        System.out.println(
            "Ha vinto il "
            + (winner == PawnFigure.BLACK_PAWN ? "nero " : "bianco ")
            + winnerPawnCount
            + " a "
            + loserPawnCount
        );
    }
}
