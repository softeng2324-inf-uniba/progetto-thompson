package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.error.ExcessBlockedTile;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import it.uniba.app.Thompson.game.error.PawnBlocked;
import it.uniba.app.Thompson.game.error.TileAlreadyBlocked;
import it.uniba.app.Thompson.game.error.TileIsOccupied;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;

/**
 * {@literal << Control >>}
 * Class to manage the command block.
 */
public final class BlockCommandC extends CommandC {

    /**
     * Attributes of the class BlockCommandC.
     **/
    private static final String COMMAND = "/blocca";
    private static final String DESCRIPTION = "Prima di iniziare permette di bloccare una casella del tavoliere"
            + "(max 9)";
    private static final int ARGUMENT_COUNT = 1;
    private static final BlockCommandC INSTANCE = new BlockCommandC();

    /**
     * Constructor for the class BlockCommandC.
     */
    private BlockCommandC() { }

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
     * @return INSTANCE The instance of HelpCommandC
     */
    public static BlockCommandC getInstance() {
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

        if (MainControl.getMatch() != null) {
            CommunicateErrorB.printMatchNotNull();
            return CommandStatus.FAILED;
        }

        if (args.length != 1) {
            CommunicateErrorB.printInvalidArguments();
            return CommandStatus.FAILED;
        }

        RegexMoveC regexMoveC = new RegexMoveC();

        if (!regexMoveC.controlInputBlock(args[0])) {
            CommunicateErrorB.printCoordinateNotValid();
            return CommandStatus.FAILED;
        }

        Coordinate blockedCoordinate;
        try {
            blockedCoordinate = Coordinate.toCoordinate(args[0]);

        } catch (InvalidCoordinate e) {
            CommunicateErrorB.printCoordinateNotValid();
            return CommandStatus.FAILED;
        }

        BoardE board = MainControl.getBoard();

        try {
            board.blockTile(blockedCoordinate);
            MainControl.setBoard(board);

            CommunicateInteractionMessageB.printBlockedTile(blockedCoordinate.toBoardString());
            PrintBoardB.printBoard(board);

            return CommandStatus.SUCCESSFUL;
        } catch (TileAlreadyBlocked e) {
            CommunicateErrorB.printTileAlreadyBlocked();

            return CommandStatus.FAILED;
        } catch (ExcessBlockedTile e) {
            CommunicateErrorB.printTooManyInvalidTiles();

            return CommandStatus.FAILED;
        } catch (PawnBlocked e) {
            CommunicateErrorB.printInvalidTileToBlock();

            return CommandStatus.FAILED;
        } catch (TileIsOccupied e) {
            CommunicateErrorB.printTileOccupied();

            return CommandStatus.FAILED;
        } catch (InvalidCoordinate e) {
            CommunicateErrorB.printCoordinateNotValid();

            return CommandStatus.FAILED;
        }
    }
}
