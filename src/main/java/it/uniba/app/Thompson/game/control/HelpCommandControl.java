package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Implementation of the help command.
 */
public final class HelpCommandControl extends CommandControl {
    /**
     * Attributes initialization and instance.
     */
    private final String command = "/help";
    private static HelpCommandControl instance = new HelpCommandControl();

    /**
     * Constructor for HelpCommandControl.
     */
    private HelpCommandControl() { }

    /**
     * @return The instance of the HelpCommandControl.
     */
    static HelpCommandControl getInstance() {
        return instance;
    }

    /**
     * Override of the getCommand method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getCommand() {
        return command;
    }

    /**
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        return CommandStatus.SUCCESSFUL;
    }
}
