package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsB;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.MatchE;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command available moves.
 */
public final class AvailableMovesCommandC extends CommandC {

    /**
     * Attributes of the class AvailableMovesCommandC.
     */
    private static final String COMMAND = "/qualimosse";
    private static final String DESCRIPTION = "Stampa le mosse disponibili del giocatore corrente per ogni pedina.";
    private static final int ARGUMENT_COUNT = 0;
    private static final AvailableMovesCommandC INSTANCE = new AvailableMovesCommandC();

    /**
     * Constructor for the class AvailableMovesCommandC.
     */
    private AvailableMovesCommandC() { }

    /**
     * Method getInstance.
     * @return INSTANCE The instance of the AvailableMovesCommandC.
     */
    public static AvailableMovesCommandC getInstance() {
        return INSTANCE;
    }

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
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandC.
     * @return Returns the status of the command execution
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        if (MainControl.getMatch() == null) {
            CommunicateErrorsB.printSuggestMatchInit();
        } else {
            MatchE match = MainControl.getMatch();
            BoardE currentBoard = match.getBoard();
            int[][] mask = VerifyMovesControl.verifyMovesAllPawns(currentBoard, match.getCurrentTurn());

            CommunicateInteractionMessagesB.printTitle("MOSSE DISPONIBILI PER IL GIOCATORE 1");
            PrintBoardB.printBoard(currentBoard, mask);
        }
        return CommandStatus.SUCCESSFUL;
    }
}
