package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.error.NegativeTime;

/**
 * {@literal << Control >>}
 * Class to manage the command time.
 */
public final class TimeCommandC extends CommandC {

    /**
     * Attributes of the class TimeCommandC.
     */
    private static final String COMMAND = "/tempo";
    private static final String DESCRIPTION = "Mostra il tempo trascorso dalla partenza della partita.";
    private static final int ARGUMENT_COUNT = 0;
    private static final TimeCommandC INSTANCE = new TimeCommandC();

    /**
     * Constructor for the class TimeCommandC.
     */
    private TimeCommandC() { }

    /**
     * Method getCommand.
     * Override of the getCommand method of the abstract class CommandC.
     * @return COMMAND The command
     */
    @Override
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Method getDescription.
     * Override of the getDescription method of the abstract class CommandC.
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
     * @return INSTANCE The instance of VoidCommandC.
     */
    public static TimeCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command
     */
    @Override
    public CommandStatus executeCommand(final String... args) throws InvalidArguments {
        if (getArgumentCount() != args.length) {
            throw new InvalidArguments();
        }

        if (MainControl.getMatch() == null) {
            CommunicateErrorB.printSuggestMatchInit();
            return CommandStatus.SUCCESSFUL;
        }
        CommunicateInteractionMessageB.printTitle("TEMPO TRASCORSO");
        try {
            CommunicateInteractionMessageB.printGameTime(MainControl.getMatch().getFormattedTime());
        } catch (NegativeTime e) {
            CommunicateErrorB.printNegativeTime();
            return CommandStatus.FAILED;
        }
        return CommandStatus.SUCCESSFUL;
    }
}
