package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command void.
 */
public final class VoidCommandControl extends CommandControl {

    /**
     * Attributes of the class VoidCommandControl.
     */
    private static final String COMMAND = "/vuoto";
    private static final String DESCRIPTION = "Stampa del tavoliere vuoto.";
    private static final int ARGUMENT_COUNT = 0;
    private static final VoidCommandControl INSTANCE = new VoidCommandControl();

    /**
     * Constructor for the class VoidCommandControl.
     */
    private VoidCommandControl() { }

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
     * Method getDescription.
     * Override of the getDescription method of the abstract class CommandControl.
     * @return DESCRIPTION The command description
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Method getArgumentCount.
     * Override of the getArgumentCount method of the abstract class CommandControl.
     * @return ARGUMENT_COUNT The number of arguments of the command
     */
    @Override
    public int getArgumentCount() {
        return ARGUMENT_COUNT;
    }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of VoidCommandControl.
     */
    public static VoidCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand(String... args) {
        CommunicateInteractionMessagesBoundary.printTitle("TAVOLIERE VUOTO");

        Board board = new Board(false);
        PrintBoardBoundary.printBoard(board);
        return CommandStatus.SUCCESSFUL;
    }
}
