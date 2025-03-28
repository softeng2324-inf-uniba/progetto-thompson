package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command play.
 */
public final class PlayCommandC extends CommandC {

    /**
     * Attributes of the class PlayCommandC.
     */
    private static final String COMMAND = "/gioca";
    private static final String DESCRIPTION = "Inizia una nuova partita";
    private static final int ARGUMENT_COUNT = 0;
    private static final PlayCommandC INSTANCE = new PlayCommandC();

    /**
     * Constructor for the class PlayCommandC.
     */
    private PlayCommandC() { }

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
     * @return INSTANCE The instance of PlayCommandC
     */
    public static PlayCommandC getInstance() {
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

        if (MainControl.getMatch() == null) {
            MainControl.initMatch();
            CommunicateInteractionMessageB.printTitle("TAVOLIERE INIZIALE");
            PrintBoardB.printBoard(MainControl.getMatch().getBoard());
        } else {
            CommunicateErrorB.printMatchNotNull();
        }

        return CommandStatus.SUCCESSFUL;
    }
}
