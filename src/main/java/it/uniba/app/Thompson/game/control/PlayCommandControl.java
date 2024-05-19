package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command play.
 */
public final class PlayCommandControl extends CommandControl {

    /**
     * Attributes of the class PlayCommandControl.
     */
    private static final String COMMAND = "/gioca";
    private static final String DESCRIPTION = "Inizia una nuova partita";
    private static final PlayCommandControl INSTANCE = new PlayCommandControl();

    /**
     * Constructor for the class PlayCommandControl.
     */
    private PlayCommandControl() { }

    /**
     * Method getCommand.
     * Override of the getCommand method of the abstract class CommandControl.
     * @return COMMAND The command
     */
    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Method getDescription.
     * Override of the getDescription method of the abstract class CommandControl.
     * @return DESCRIPTION The command description
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of PlayCommandControl
     */
    public static PlayCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand() {
        if (MainControl.getMatch() == null) {
            MainControl.initMatch();
            PrintBoardBoundary.printBoard(MainControl.getMatch().getBoard());
        } else {
            CommunicateErrorsBoundary.printMatchNotNull();
        }

        return CommandStatus.SUCCESSFUL;
    }
}
