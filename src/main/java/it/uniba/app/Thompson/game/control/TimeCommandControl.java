package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command time.
 */
public final class TimeCommandControl extends CommandControl {

    /**
     * Attributes of the class TimeCommandControl.
     */
    private static final String COMMAND = "/tempo";
    private static final String DESCRIPTION = "Mostra il tempo trascorso dalla partenza della partita.";
    private static final TimeCommandControl INSTANCE = new TimeCommandControl();

    /**
     * Constructor for the class TimeCommandControl.
     */
    private TimeCommandControl() { }

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
     * @return INSTANCE The instance of VoidCommandControl.
     */
    public static TimeCommandControl getInstance() {
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
            return CommandStatus.SUCCESSFUL;
        }
        CommunicateInteractionMessagesBoundary.printTitle("TEMPO TRASCORSO");
        CommunicateInteractionMessagesBoundary.printMessage(MainControl.getMatch().getFormattedTime());
        return CommandStatus.SUCCESSFUL;
    }
}
