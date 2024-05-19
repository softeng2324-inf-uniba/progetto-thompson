package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Implementation of the play command.
 */
public final class VoidCommandControl extends CommandControl {

    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/vuoto";
    private static final String DESCRIPTION = "Stampa del tavoliere vuoto.";
    private static final VoidCommandControl INSTANCE = new VoidCommandControl();

    /**
     * Constructor for VoidCommandControl.
     */
    private VoidCommandControl() { }

    /**
     * @return The instance of the VoidCommandControl.
     */
    public static VoidCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Override of the getCommand method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
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
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        Board board = new Board(false);
        PrintBoardBoundary.printBoard(board);
        return CommandStatus.SUCCESSFUL;
    }
}
