package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command exit.
 */
public final class ExitCommandControl extends CommandControl {

    /**
     * Attributes of the class ExitCommandControl.
     */
    private static final String COMMAND = "/esci";
    private static final String DESCRIPTION = "Termina il programma";
    private static final int ARGUMENT_COUNT = 0;
    private static final ExitCommandControl INSTANCE = new ExitCommandControl();

    /**
     * Constructor for ExitCommandControl.
     */
    private ExitCommandControl() { }

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
     * Method getArgumentCount.
     * Override of the getArgumentCount method of the abstract class CommandControl.
     * @return ARGUMENT_COUNT The number of arguments of the command
     */
    @Override
    public int getArgumentCount() {
        return ARGUMENT_COUNT;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of ExitCommandControl
     */
    public static ExitCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        UserInputBoundary.closeScanner();
        return CommandStatus.SHUTDOWN;
    }
}
