package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Implementation of the play command.
 */
public final class PlayCommandControl extends CommandControl {

    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/gioca";
    private static final String DESCRIPTION = "Inizia una nuova partita";
    private static final PlayCommandControl INSTANCE = new PlayCommandControl();

    /**
     * Constructor for PlayCommandControl.
     */
    private PlayCommandControl() { }

    /**
     * @return The instance of the PlayCommandControl.
     */
    public static PlayCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Override of the getCommand method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Override of the getDescription method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        if (MainControl.getMatch() == null) {
            MainControl.initMatch();

            CommunicateInteractionMessagesBoundary.printTitle("TAVOLIERE INIZIALE");
            PrintBoardBoundary.printBoard(MainControl.getMatch().getBoard());
        } else {
            CommunicateErrorsBoundary.printMatchNotNull();
        }

        return CommandStatus.SUCCESSFUL;
    }
}
