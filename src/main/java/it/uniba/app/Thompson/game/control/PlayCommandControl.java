package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * << Control >>
 * Implementation of the play command.
 */
public final class PlayCommandControl extends CommandControl {

    /**
     * Attributes initialization and instance.
     */
    private static final String COMMAND = "/gioca";
    private static final String DESCRIPTION = "Inizia una nuova partita";
    private static final PlayCommandControl INSTANCE = new PlayCommandControl();

    /**
     * Constructor for PlayCommandControl.
     */
    private PlayCommandControl() { }

    /**
     * @return The instance of the PlayCommandControl.
     */
    public static PlayCommandControl getInstance() {
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
        return CommandStatus.SUCCESSFUL;
    }
}
