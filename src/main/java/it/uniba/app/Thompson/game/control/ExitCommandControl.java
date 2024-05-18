package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;
/**
 * << Control >>
 * Implementation of the exit command.
 */
public final class ExitCommandControl extends CommandControl {

    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/esci";
    private static final ExitCommandControl INSTANCE = new ExitCommandControl();
    private static final String DESCRIPTION = "Termina il programma";

    /**
     * Override of the getDescription method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Constructor for ExitCommandControl.
     */
    private ExitCommandControl() { }

    /**
     * @return The instance of the ExitCommandControl.
     */
    public static ExitCommandControl getInstance() {
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
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        return CommandStatus.SHUTDOWN;
    }
}
