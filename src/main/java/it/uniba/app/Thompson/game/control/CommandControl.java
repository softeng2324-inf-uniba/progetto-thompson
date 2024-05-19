package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Controls for command constants.
 */
public abstract class CommandControl {
    private static final String COMMAND = "";
    private static final String[] ALIASES = {};
    private static final String DESCRIPTION = "";

    /**
     * Method that returns command.
     * @return Name of the command.
     */
    public String getCommand() {
        return COMMAND;
    }

    /**
     * Return description of command.
     * @return Description
     */
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Return aliases of command.
     * @return Description
     */
    String[] getAliases() {
        return ALIASES;
    }

    /**
     * Method that executes some instructions and return a CommandStatus.
     * @return Instance of CommandStatus.
     */
    CommandStatus executeCommand() {
        return CommandStatus.SUCCESSFUL;
    }
}
