package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.HelpBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Implementation of the help command.
 */
public final class HelpCommandControl extends CommandControl {
    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/help";
    private static final String DESCRIPTION = "Mostra tutti i comandi disponibili";
    private static final HelpCommandControl INSTANCE = new HelpCommandControl();
    private static final String[] ALIASES = {"--help", "-h"};

    /**
     * Constructor for HelpCommandControl.
     */
    private HelpCommandControl() { }

    /**
     * @return The instance of the HelpCommandControl.
     */
    public static HelpCommandControl getInstance() {
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
     * Override of the getAliases method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String[] getAliases() {
        return ALIASES.clone();
    }

    /**
     * Override of the getDescription method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        HelpBoundary.printCommands();

        return CommandStatus.SUCCESSFUL;
    }
}
