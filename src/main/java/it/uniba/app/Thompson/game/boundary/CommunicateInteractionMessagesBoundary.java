package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.util.PawnFigure;
import it.uniba.app.Thompson.game.util.UserInteractionMessages;

/**
 * {@literal << Boundary >>}
 * Class to communicate interaction messages.
 */
public final class CommunicateInteractionMessagesBoundary {

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
        System.out.println(
            "Ha vinto il "
            + (winner == PawnFigure.BLACK_PAWN ? "nero " : "bianco ")
            + winnerPawnCount
            + " a "
            + loserPawnCount
        );
    }
}
