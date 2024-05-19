package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.HelpBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command help.
 */
public final class HelpCommandControl extends CommandControl {

    /**
     * Attributes of the class HelpCommandControl.
     **/
    private static final String COMMAND = "/help";
    private static final String[] ALIASES = {"--help", "-h"};
    private static final String DESCRIPTION = "Mostra tutti i comandi disponibili";
    private static final HelpCommandControl INSTANCE = new HelpCommandControl();

    /**
     * Constructor for the class HelpCommandControl.
     */
    private HelpCommandControl() { }

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
     * Method getAliases.
     * Override of the getAliases method of the abstract class CommandControl.
     * @return Returns the clone of the command aliases
     */
    @Override
    public String[] getAliases() {
        return ALIASES.clone();
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
     * Method getInstance.
     * @return INSTANCE The instance of HelpCommandControl
     */
    public static HelpCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand() {
        CommunicateInteractionMessagesBoundary.printTitle("COMANDI DISPONIBILI");

        //inserire tutti i comandi disponibili
        HelpBoundary.printCommands(new CommandControl[]{
            HelpCommandControl.getInstance(),
            VoidCommandControl.getInstance(),
            PlayCommandControl.getInstance(),
            AvailableMovesCommandControl.getInstance(),
            BoardCommandControl.getInstance(),
            QuitCommandControl.getInstance(),
            ExitCommandControl.getInstance(),
        });

        return CommandStatus.SUCCESSFUL;
    }
}
