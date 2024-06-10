package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command board.
 */
public final class BoardCommandC extends CommandC {

    /**
     * Attributes of the class BoardCommandC.
     */
    private static final String COMMAND = "/tavoliere";
    private static final String DESCRIPTION = "Mostra il tavoliere di gioco.";
    private static final int ARGUMENT_COUNT = 0;
    private static final BoardCommandC INSTANCE = new BoardCommandC();

    /**
     * Constructor for the class BoardCommandC.
     */
    private BoardCommandC() { }

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
     * @return DESCRIPTION The description of the command
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
     * @return INSTANCE The instance of BoardCommandC
     */
    public static BoardCommandC getInstance() {
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
            CommunicateErrorB.printSuggestMatchInit();
        } else {
            CommunicateInteractionMessageB.printTitle("TAVOLIERE ATTUALE");

            PrintBoardB.printBoard(MainControl.getMatch().getBoard());
        }
        return CommandStatus.SUCCESSFUL;
    }
}
