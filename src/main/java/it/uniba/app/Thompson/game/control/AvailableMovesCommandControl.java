package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.entity.Match;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command available moves.
 */
public final class AvailableMovesCommandControl extends CommandControl {

    /**
     * Attributes of the class AvailableMovesCommandControl.
     */
    private static final String COMMAND = "/qualimosse";
    private static final String DESCRIPTION = "Stampa le mosse disponibili del giocatore corrente per ogni pedina.";
    private static final int ARGUMENT_COUNT = 0;
    private static final AvailableMovesCommandControl INSTANCE = new AvailableMovesCommandControl();

    /**
     * Constructor for the class AvailableMovesCommandControl.
     */
    private AvailableMovesCommandControl() { }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of the AvailableMovesCommandControl.
     */
    public static AvailableMovesCommandControl getInstance() {
        return INSTANCE;
    }

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
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command execution
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        if (MainControl.getMatch() == null) {
            CommunicateErrorsBoundary.printSuggestMatchInit();
        } else {
            Match match = MainControl.getMatch();
            Board currentBoard = match.getBoard();
            int[][] mask = VerifyMovesControl.verifyMovesAllPawns(currentBoard, match.getCurrentTurn());

            CommunicateInteractionMessagesBoundary.printTitle("MOSSE DISPONIBILI PER IL GIOCATORE 1");
            PrintBoardBoundary.printBoard(currentBoard, mask);
        }
        return CommandStatus.SUCCESSFUL;
    }
}
