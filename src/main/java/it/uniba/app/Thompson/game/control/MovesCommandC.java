package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesB;
import it.uniba.app.Thompson.game.entity.MatchE;
import it.uniba.app.Thompson.game.error.InvalidArguments;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.entity.MoveE;
import java.util.Queue;

/**
 * {@literal << Control >>}
 * Class to manage the command moves.
 */
public final class MovesCommandC extends CommandC {

    /**
     * Attributes of the class MovesCommandC.
     */
    private static final String COMMAND = "/mosse";
    private static final String DESCRIPTION = "Stampa le mosse effettuate nella partita";
    private static final int ARGUMENT_COUNT = 0;
    private static final MovesCommandC INSTANCE = new MovesCommandC();

    /**
     * Constructor for the class MovesCommandC.
     */
    private MovesCommandC() { }

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
     * @return INSTANCE The instance of MovesCommandC
     */
    public static MovesCommandC getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command.
     */
    @Override
    public CommandStatus executeCommand(final String... args) throws InvalidArguments {
        if (getArgumentCount() != args.length) {
            throw new InvalidArguments();
        }

        if (MainControl.getMatch() == null) {
            CommunicateErrorsB.printSuggestMatchInit();
        } else {
            MatchE match = MainControl.getMatch();
            Queue<MoveE> moves = match.getMoves();
            String[] movesString = new String[moves.size()];

            int i = 0;
            for (MoveE move : moves) {
                try {
                    movesString[i] = move.toBoardString();
                } catch (InvalidCoordinate e) {
                    CommunicateErrorsB.printCoordinateNotValid();
                    return CommandStatus.FAILED;
                }
                i++;
            }

            CommunicateInteractionMessagesB.printMoves(movesString);
        }

        return CommandStatus.SUCCESSFUL;
    }
}
