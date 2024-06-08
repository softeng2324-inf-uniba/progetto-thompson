package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.UserInputB;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command exit.
 */
public final class ExitCommandC extends CommandC {

    /**
     * Attributes of the class ExitCommandC.
     */
    private static final String COMMAND = "/esci";
    private static final String DESCRIPTION = "Termina il programma";
    private static final int ARGUMENT_COUNT = 0;
    private static final ExitCommandC INSTANCE = new ExitCommandC();

    /**
     * Constructor for ExitCommandC.
     */
    private ExitCommandC() { }

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
     * @return INSTANCE The instance of ExitCommandC
     */
    public static ExitCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command
     */
    @Override
    public CommandStatus executeCommand(final String... args) {
        UserInputB.closeScanner();
        return CommandStatus.SHUTDOWN;
    }
}
