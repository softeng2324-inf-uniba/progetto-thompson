package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.boundary.WelcomeBannerBoundary;
import it.uniba.app.Thompson.game.boundary.PrintBoardBoundary;
import it.uniba.app.Thompson.game.entity.Board;
import it.uniba.app.Thompson.game.entity.Match;
import it.uniba.app.Thompson.game.entity.Move;
import it.uniba.app.Thompson.game.error.CommandNotFoundError;
import it.uniba.app.Thompson.game.error.InvalidArgumentsError;
import it.uniba.app.Thompson.game.util.CommandStatus;
import it.uniba.app.Thompson.game.util.Coordinate;
import it.uniba.app.Thompson.game.util.PawnFigure;
import java.util.Arrays;
import java.util.HashMap;

/**
 * {@literal << Control >>}
 * Class to manage the flow of the program.
 */
public final class MainControl {

    /**
     * Attributes of the class MainControl.
     */
    private static Match match;
    private static Board board = new Board(true);

    /**
     * Constructor for the class MainControl.
     */
    private MainControl() { }

    /**
     * Method initCommands.
     * @return commands The map of the available commands
     */
    private static HashMap<String, CommandControl> initCommands() {
        HashMap<String, CommandControl> commands = new HashMap<>();

        commands.put(HelpCommandControl.getInstance().getCommand(), HelpCommandControl.getInstance());
        commands.put(ExitCommandControl.getInstance().getCommand(), ExitCommandControl.getInstance());
        commands.put(PlayCommandControl.getInstance().getCommand(), PlayCommandControl.getInstance());
        commands.put(QuitCommandControl.getInstance().getCommand(), QuitCommandControl.getInstance());
        commands.put(VoidCommandControl.getInstance().getCommand(), VoidCommandControl.getInstance());
        commands.put(BoardCommandControl.getInstance().getCommand(), BoardCommandControl.getInstance());
        commands.put(AvailableMovesCommandControl.getInstance().getCommand(),
                     AvailableMovesCommandControl.getInstance());
        commands.put(MovesCommandControl.getInstance().getCommand(), MovesCommandControl.getInstance());
        commands.put(BlockCommandControl.getInstance().getCommand(), BlockCommandControl.getInstance());
        commands.put(TimeCommandControl.getInstance().getCommand(), TimeCommandControl.getInstance());
        return commands;
    }

    /**
     * Method initArgumentCommands.
     * @return commands The map of the valid arguments
     */
    private static HashMap<String, CommandControl> initArgumentCommands() {
        HashMap<String, CommandControl> commands = new HashMap<>();
        commands.putAll(addAliasesCommands(HelpCommandControl.getInstance()));

        return commands;
    }

    /**
     * Method switchTurn.
     */
    public static void switchTurn() {
        match.switchTurn();
    }

    /**
     * Method addAliasesCommands.
     * @param commandControl Command linked to the argument
     * @return commands The map of the aliases of the argument
     */
    private static HashMap<String, CommandControl> addAliasesCommands(final CommandControl commandControl) {
        HashMap<String, CommandControl> commands =  new HashMap<>();

        for (String a: commandControl.getAliases()) {
            commands.put(a, commandControl);
        }

        return commands;
    }

    /**
     * Method initMatch.
     */
    public static void initMatch() {
        match = new Match(MainControl.getBoard());
    }

    /**
     * Method getMatch.
     * @return match The current match.
     */
    public static Match getMatch() {
        Match defensiveCopy = match;
        if (defensiveCopy != null) {
            defensiveCopy = new Match(match.getBoard(), match.getMoves(), match.getCurrentTurn());
        }
        return defensiveCopy;
    }

    /**
     * Method setMatchBoard.
     */
    public static void setMatchBoard() {
        match.setBoard(board);
    }

    /**
     * Method pushMove.
     * @param move The move to be pushed in the queue
     */
    public static void pushMoveQueue(final Move move) {
        match.pushMove(move);
    }

    /**
     * Method removeMatch, sets the current match to null, terminating it.
     */
    public static void removeMatch() {
        match = null;
    }

    /**
     * Method getBoard.
     * @return board The board of the match
     */
    public static Board getBoard() {
        Board defensiveCopy = board;
        if (defensiveCopy != null) {
            defensiveCopy = new Board(board);
        }
        return defensiveCopy;
    }

    /**
     * Method setBoard.
     * @param newBoard The new board of the match
     */
    public static void setBoard(final Board newBoard) {
        board = new Board(newBoard);
    }

    /**
     * Method findAndExecuteCommand, finds and executes the command.
     * @param commandStrings Array that contains command and other arguments
     * @param availableCommands The map of the available commands
     * @return Returns The status of the command
     * @throws CommandNotFoundError If the command is not found
     * @throws InvalidArgumentsError The command is followed by invalid number of arguments
     */
    private static CommandStatus findAndExecuteCommand(
        final String[] commandStrings,
        final HashMap<String, CommandControl> availableCommands
    ) throws CommandNotFoundError, InvalidArgumentsError {
        //First element of commandsStrings must be recognized command
        if (availableCommands.containsKey(commandStrings[0])) {
            CommandControl commandControl = availableCommands.get(commandStrings[0]);

            if (commandControl.getArgumentCount() != commandStrings.length - 1) {
                throw new InvalidArgumentsError();
            }

            return commandControl.executeCommand(Arrays.copyOfRange(commandStrings, 1, commandStrings.length));
        }
        throw new CommandNotFoundError();
    }

    /**
     * Method executeArgumentsCommands, executes all the arguments in the args array.
     * @param args Array of all the arguments
     * @param commands Map of all the valid arguments
     */
    private static void executeArgumentsCommands(final String[] args, final HashMap<String, CommandControl> commands) {
        for (String arg : args) {
            try {
                CommunicateInteractionMessagesBoundary.printNewLine();
                findAndExecuteCommand(new String[]{arg}, commands);
                CommunicateInteractionMessagesBoundary.printNewLine();
            } catch (CommandNotFoundError e) {
                CommunicateErrorsBoundary.printArgumentNotFound(arg);
            } catch (InvalidArgumentsError e) {
                CommunicateErrorsBoundary.printInvalidArguments();
            } catch (Error e) {
                CommunicateErrorsBoundary.printGenericError();
            }
        }
    }

    /**
     * Method startMainControl, starts main control, starts the main control loop.
     * @param args Array of all the arguments
     */
    public static void startMainControl(final String[] args) {
        HashMap<String, CommandControl> availableCommands = initCommands();
        CommandStatus status = CommandStatus.SUCCESSFUL;
        RegexMoveControl matcher = new RegexMoveControl();

        WelcomeBannerBoundary banner = new WelcomeBannerBoundary();
        banner.printBanner();

        executeArgumentsCommands(args, initArgumentCommands());

        while (status != CommandStatus.SHUTDOWN) {
            String[] commandStrings = UserInputBoundary.getCommandAndArguments();
            CommunicateInteractionMessagesBoundary.printNewLine();
            try {
                if (matcher.controlInputMovement(commandStrings[0]) && MainControl.getMatch() != null) {
                    String[] toConvert = commandStrings[0].split("-");
                    Coordinate from = Coordinate.toCoordinate(toConvert[0]);
                    Coordinate to = Coordinate.toCoordinate(toConvert[1]);
                    board.movePawn(from, to);
                    PrintBoardBoundary.printBoard(board);
                } else {
                    status = findAndExecuteCommand(commandStrings, availableCommands);
                }
                if (board.isBoardFull()) {
                    int wp = board.countPawns(PawnFigure.WHITE_PAWN);
                    int bp = board.countPawns(PawnFigure.BLACK_PAWN);
                    if (wp == bp) {
                        CommunicateInteractionMessagesBoundary.printDraw(bp, wp);
                    } else if (wp > bp) {
                        CommunicateInteractionMessagesBoundary.printWinner(PawnFigure.WHITE_PAWN, wp, bp);
                    } else {
                        CommunicateInteractionMessagesBoundary.printWinner(PawnFigure.BLACK_PAWN, bp, wp);
                    }
                    removeMatch();
                }
            } catch (CommandNotFoundError e) {
                CommunicateErrorsBoundary.printCommandNotFound();
            } catch (InvalidArgumentsError e) {
                CommunicateErrorsBoundary.printInvalidArguments();
            } catch (Error e) {
                CommunicateErrorsBoundary.printGenericError();
            }
        }
        CommunicateInteractionMessagesBoundary.printGoodbye();
    }
}
