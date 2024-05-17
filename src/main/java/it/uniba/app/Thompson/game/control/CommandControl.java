package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Controls for command constants.
 */
public abstract class CommandControl {
    private String command;
    private String[] aliases;
    private String description;

    /**
     * Method that returns command.
     * @return Name of the command.
     */
    String getCommand() {
        return command;
    }

    /**
     * Return description of command.
     * @return Description
     */
    String getDescription() {
        return description;
    }

    /**
     * Return aliases of command.
     * @return Description
     */
    String[] getAliases() {
        return aliases;
    }

    /**
     * Method that executes some instructions and return a CommandStatus.
     * @return Instance of CommandStatus.
     */
    CommandStatus executeCommand() {
        return CommandStatus.SUCCESSFUL;
    }
}
