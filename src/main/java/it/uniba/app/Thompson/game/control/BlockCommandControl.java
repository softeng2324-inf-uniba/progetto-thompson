package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * {@literal << Control >>}
 * Class to manage the command block.
 */
public final class BlockCommandControl extends CommandControl {

    /**
     * Attributes of the class BlockCommandControl.
     **/
    private static final String COMMAND = "/blocca";
    private static final String DESCRIPTION = "Prima di iniziare permette di bloccare una casella del tavoliere (max 9)";
    private static final int ARGUMENT_COUNT = 1;
    private static final BlockCommandControl INSTANCE = new BlockCommandControl();

    /**
     * Constructor for the class BlockCommandControl.
     */
    private BlockCommandControl() { }

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
     * @return INSTANCE The instance of HelpCommandControl
     */
    public static BlockCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        if(MainControl.getMatch() != null) {
            CommunicateErrorsBoundary.printMatchNotNull();
            return CommandStatus.FAILED;
        }

        if(args.length != 1) {
            CommunicateErrorsBoundary.printInvalidArguments();
            return CommandStatus.FAILED;
        }

        Coordinate blockedCoordinate = Coordinate.toCoordinate(args[0]);

        MainControl.getBoard().blockTile(blockedCoordinate);
        CommunicateInteractionMessagesBoundary.printBlockedTile(blockedCoordinate);

        return CommandStatus.SUCCESSFUL;
    }
}
