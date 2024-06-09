package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.boundary.UserInputB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.PawnFigure;

import java.util.Arrays;

/**
 * {@literal << Control >>}
 * Class to manage the command quit.
 */
public final class QuitCommandC extends CommandC {

    /**
     * Attributes of the class QuitCommandC.
     */
    private static final String COMMAND = "/abbandona";
    private static final String DESCRIPTION = "Abbandona la partita corrente";
    private static final int ARGUMENT_COUNT = 0;
    private static final QuitCommandC INSTANCE = new QuitCommandC();

    /**
     * Constructor for the class QuitCommandC.
     */
    private QuitCommandC() { }

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
     * Method getArgumentCount.
     * Override of the getArgumentCount method of the abstract class CommandC.
     * @return ARGUMENT_COUNT The number of arguments of the command
     */
    @Override
    public int getArgumentCount() {
        return ARGUMENT_COUNT;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of QuitCommandC
     */
    public static QuitCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * @return Returns the status of the command
     */
    @Override
    public CommandStatus executeCommand(final String... args) {
        if (MainControl.getMatch() == null) {
            CommunicateErrorB.printMatchNull();
        } else {
            this.askToQuitGame();
        }
        return CommandStatus.SUCCESSFUL;
    }

    /**
     * Method askToQuitGame, asks which player wants to quit the game.
     */
    private void askToQuitGame() {
        CommunicateInteractionMessageB.printQuittingPlayer();
        String whichPlayer = UserInputB.getInput().trim().toLowerCase();
        String[] acceptableResponse = new String[] {"n", "b"};

        CommunicateInteractionMessageB.printNewLine();

        if (Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(whichPlayer))) {
            CommunicateErrorB.printInvalidPlayer();
            return;
        }

        this.askConfirmation(whichPlayer);
    }

    /**
     * Method askConfirmation, asks for confirmation to quit the game.
     * @param player The player who wants to quit the game
     */
    private void askConfirmation(final String player) {
        CommunicateInteractionMessageB.printSureToQuit();
        String confirmation = UserInputB.getInput().trim().toLowerCase();
        String[] acceptableResponse = new String[] {"n", "s" };

        CommunicateInteractionMessageB.printNewLine();

        if (Arrays.stream(acceptableResponse).noneMatch(a -> a.equals(confirmation))) {
            CommunicateErrorB.printInvalidChoice();

            return;
        }

        if (confirmation.equals("s")) {
            this.quitMatch(player.equals("b") ? PawnFigure.BLACK_PAWN : PawnFigure.WHITE_PAWN);
        } else {
            CommunicateInteractionMessageB.printAbortedQuit();
        }
    }

    /**
     * Method quitMatch, communicates the winner and quits the match.
     * @param winnerPawn The pawn figure of the winner
     */
    private void quitMatch(final PawnFigure winnerPawn) {
        CommunicateInteractionMessageB.printWinner(
                winnerPawn,
                MainControl.getMatch().getBoard().countPawns(winnerPawn),
                0
        );

        MainControl.removeMatch();
        MainControl.setBoard(new BoardE(true));
    }
}
