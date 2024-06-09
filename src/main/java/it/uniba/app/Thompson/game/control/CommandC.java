package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Abstract class to define a general command.
 */
public abstract class CommandC {

    /**
     * Attributes of the class CommandC.
     */
    private static final String[] ALIASES = {};

    /**
     * Method getCommand.
     * @return COMMAND The command
     */
    public abstract String getCommand();

    /**
     * Method getAliases.
     * @return ALIASES The aliases of the command
     */
    public String[] getAliases() {
        return ALIASES;
    };

    /**
     * Method getDescription.
     * @return DESCRIPTION The description of the command
     */
    public abstract String getDescription();

    /**
     * Method getArgumentCount.
     * @return ARGUMENT_COUNT The number of arguments of the command
     */
    public abstract int getArgumentCount();

    /**
     * Method executeCommand.
     * @return Returns the status of the command
     */
    abstract CommandStatus executeCommand(final String... args);
}