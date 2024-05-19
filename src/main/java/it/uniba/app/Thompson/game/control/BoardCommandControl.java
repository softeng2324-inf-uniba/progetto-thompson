package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;

/**
 * {@literal << Control >>}
 * Class to manage the command board.
 */
public final class BoardCommandControl extends CommandControl {

    /**
     * Attributes of the class BoardCommandControl.
     */
    private static final String COMMAND = "/tavoliere";
    private static final String DESCRIPTION = "Mostra il tavoliere di gioco.";
    private static final BoardCommandControl INSTANCE = new BoardCommandControl();

    /**
     * Constructor for the class BoardCommandControl.
     */
    private BoardCommandControl() { }

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
     * @return DESCRIPTION The description of the command
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of BoardCommandControl
     */
    public static BoardCommandControl getInstance() {
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
            CommunicateErrorsBoundary.printSuggestMatchInit();
        } else {
            PrintBoardBoundary.printBoard(MainControl.getMatch().getBoard());
        }
        return CommandStatus.SUCCESSFUL;
    }
}
