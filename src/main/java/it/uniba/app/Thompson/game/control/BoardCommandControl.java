package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;
/**
 * << Control >>
 * Implementation of the board command.
 */
public final class BoardCommandControl extends CommandControl {

    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/tavoliere";
    private static final BoardCommandControl INSTANCE = new BoardCommandControl();
    private static final String DESCRIPTION = "Stampa il tavoliere";

    /**
     * Override of the getDescription method of the abstract class CommandControl.
     * @return The command string.
     */
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    /**
     * Constructor for ExitCommandControl.
     */
    private BoardCommandControl() { }

    /**
     * @return The instance of the ExitCommandControl.
     */
    public static BoardCommandControl getInstance() {
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
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return The status of the command.
     */
    @Override
    CommandStatus executeCommand() {
        System.out.println("Tavoliere");

        return CommandStatus.SUCCESSFUL;
    }
}
