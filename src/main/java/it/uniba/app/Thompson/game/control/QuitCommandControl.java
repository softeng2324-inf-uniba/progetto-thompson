package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.PawnFigure;

import java.util.Arrays;

/**
 * {@literal << Control >>}
 * Class to manage the command quit.
 */
public final class QuitCommandControl extends CommandControl {

    /**
     * Attributes of the class QuitCommandControl.
     */
    private static final String COMMAND = "/abbandona";
    private static final String DESCRIPTION = "Abbandona la partita corrente";
    private static final QuitCommandControl INSTANCE = new QuitCommandControl();

    /**
     * Constructor for the class QuitCommandControl.
     */
    private QuitCommandControl() { }

    /**
     * Method getCommand.
     * @return COMMAND The command
     */
    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Return description of command.
     * @return DESCRIPTION The command description
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of QuitCommandControl
     */
    public static QuitCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * @return Returns the status of the command
     */
    @Override
    public CommandStatus executeCommand() {
        if (MainControl.getMatch() == null) {
            CommunicateErrorsBoundary.printMatchNull();
        } else {
            this.askToQuitGame();
        }

        return CommandStatus.SUCCESSFUL;
    }

    /**
     * Method askToQuitGame, asks which player wants to quit the game.
     */
    private void askToQuitGame() {
        CommunicateInteractionMessagesBoundary.printQuittingPlayer();
        String whichPlayer = UserInputBoundary.getInput().trim().toLowerCase();
        String[] acceptableResponse = new String[] { "n", "b" };

        if(Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(whichPlayer))) {
            CommunicateErrorsBoundary.printInvalidPlayer();

            return;
        }

        this.askConfirmation(whichPlayer);
    }

    /**
     * Method askConfirmation, asks for confirmation to quit the game.
     * @param player The player who wants to quit the game
     */
    private void askConfirmation(String player) {
        CommunicateInteractionMessagesBoundary.printSureToQuit();
        String confirmation = UserInputBoundary.getInput().trim().toLowerCase();
        String[] acceptableResponse = new String[] { "n", "s" };

        if(Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(confirmation))) {
            CommunicateErrorsBoundary.printInvalidChoice();

            return;
        }

        if (confirmation.equals("s")) {
            this.quitMatch(player.equals("b") ? PawnFigure.BLACK_PAWN : PawnFigure.WHITE_PAWN);
        } else {
            CommunicateInteractionMessagesBoundary.printAbortedQuit();
        }
    }

    /**
     * Method quitMatch, communicates the winner and quits the match.
     * @param winnerPawn The pawn figure of the winner
     */
    private void quitMatch(PawnFigure winnerPawn) {
        CommunicateInteractionMessagesBoundary.printWinner(
                winnerPawn,
                MainControl.getMatch().getBoard().countPawns(winnerPawn),
                0
        );

        MainControl.removeMatch();
    }
}
