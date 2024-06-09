package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command void.
 */
public final class VoidCommandC extends CommandC {

    /**
     * Attributes of the class VoidCommandC.
     */
    private static final String COMMAND = "/vuoto";
    private static final String DESCRIPTION = "Stampa del tavoliere vuoto.";
    private static final int ARGUMENT_COUNT = 0;
    private static final VoidCommandC INSTANCE = new VoidCommandC();

    /**
     * Constructor for the class VoidCommandC.
     */
    private VoidCommandC() { }

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
     * @return INSTANCE The instance of VoidCommandC
     */
    public static VoidCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command
     */
    @Override
    public CommandStatus executeCommand(final String... args) throws InvalidArguments {
        if (getArgumentCount() != args.length) {
            throw new InvalidArguments();
        }

        CommunicateInteractionMessagesB.printTitle("TAVOLIERE VUOTO");

        BoardE board = new BoardE(false);
        PrintBoardB.printBoard(board);
        return CommandStatus.SUCCESSFUL;
    }
}
