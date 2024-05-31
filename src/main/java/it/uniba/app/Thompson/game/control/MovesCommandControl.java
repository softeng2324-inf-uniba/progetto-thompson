package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.entity.Match;
import it.uniba.app.Thompson.game.util.CommandStatus;

/**
 * {@literal << Control >>}
 * Class to manage the command moves.
 */
public final class MovesCommandControl extends CommandControl {

    /**
     * Attributes of the class MovesCommandControl.
     */
    private static final String COMMAND = "/mosse";
    private static final String DESCRIPTION = "Stampa le mosse effettuate nella partita";
    private static final int ARGUMENT_COUNT = 0;
    private static final MovesCommandControl INSTANCE = new MovesCommandControl();

    /**
     * Constructor for the class MovesCommandControl.
     */
    private MovesCommandControl() { }

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
     * @return INSTANCE The instance of MovesCommandControl
     */
    public static MovesCommandControl getInstance() {
        return INSTANCE;
    }

    /**
     * Method executeCommand.
     * Override of the executeCommand method of the abstract class CommandControl.
     * @return Returns the status of the command.
     */
    @Override
    CommandStatus executeCommand(final String... args) {
        if (MainControl.getMatch() == null) {
            CommunicateErrorsBoundary.printSuggestMatchInit();
        } else {
            Match match = MainControl.getMatch();

            CommunicateInteractionMessagesBoundary.printMoves(match.getMoves());
        }

        return CommandStatus.SUCCESSFUL;
    }
}
