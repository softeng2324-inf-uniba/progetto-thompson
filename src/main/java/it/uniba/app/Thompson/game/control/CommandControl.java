package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Abstract class to define a general command.
 */
public abstract class CommandControl {

    /**
     * Attributes of the class CommandControl.
     */
    private static final String COMMAND = "";
    private static final String[] ALIASES = {};
    private static final String DESCRIPTION = "";
    private static final int ARGUMENT_COUNT = 0;

    /**
     * Method getCommand.
     * @return COMMAND The command
     */
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Method getAliases.
     * @return ALIASES The aliases of the command
     */
    String[] getAliases() {
        return ALIASES;
    }

    /**
     * Method getDescription.
     * @return DESCRIPTION The description of the command
     */
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getArgumentCount.
     * @return ARGUMENT_COUNT The number of arguments of the command
     */
    int getArgumentCount() {
        return ARGUMENT_COUNT;
    }

    /**
     * Method executeCommand.
     * @return Returns the status of the command
     */
    CommandStatus executeCommand(String... args) {
        return CommandStatus.SUCCESSFUL;
    }
}
