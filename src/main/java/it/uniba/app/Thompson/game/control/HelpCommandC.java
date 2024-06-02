package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesB;
import it.uniba.app.Thompson.game.boundary.HelpB;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command help.
 */
public final class HelpCommandC extends CommandC {

    /**
     * Attributes of the class HelpCommandC.
     **/
    private static final String COMMAND = "/help";
    private static final String[] ALIASES = {"--help", "-h"};
    private static final String DESCRIPTION = "Mostra tutti i comandi disponibili";
    private static final int ARGUMENT_COUNT = 0;
    private static final HelpCommandC INSTANCE = new HelpCommandC();

    /**
     * Constructor for the class HelpCommandC.
     */
    private HelpCommandC() { }

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
     * Method getAliases.
     * Override of the getAliases method of the abstract class CommandC.
     * @return Returns the clone of the command aliases
     */
    @Override
    public String[] getAliases() {
        return ALIASES.clone();
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
     * @return INSTANCE The instance of HelpCommandC
     */
    public static HelpCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        CommunicateInteractionMessagesB.printTitle("COMANDI DISPONIBILI");

        //inserire tutti i comandi disponibili
        HelpB.printCommands(
            "Mossa : Per eseguire una mossa scrivi "
                + "ad esempio a1-a3 (pedina-casella finale)",
            new CommandC[]{
                HelpCommandC.getInstance(),
                VoidCommandC.getInstance(),
                BlockCommandC.getInstance(),
                PlayCommandC.getInstance(),
                AvailableMovesCommandC.getInstance(),
                BoardCommandC.getInstance(),
                MovesCommandC.getInstance(),
                QuitCommandC.getInstance(),
                ExitCommandC.getInstance(),
                TimeCommandC.getInstance()
            }
        );

        return CommandStatus.SUCCESSFUL;
    }
}
