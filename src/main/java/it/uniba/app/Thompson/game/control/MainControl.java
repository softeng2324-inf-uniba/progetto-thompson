package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessageB;
import it.uniba.app.Thompson.game.boundary.PrintBoardB;
import it.uniba.app.Thompson.game.boundary.UserInputB;
import it.uniba.app.Thompson.game.boundary.WelcomeBannerB;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorB;
import it.uniba.app.Thompson.game.entity.BoardE;
import it.uniba.app.Thompson.game.entity.MatchE;
import it.uniba.app.Thompson.game.entity.MoveE;
import it.uniba.app.Thompson.game.error.InvalidCoordinate;
import it.uniba.app.Thompson.game.error.InvalidMove;
import it.uniba.app.Thompson.game.error.MatchNull;
import it.uniba.app.Thompson.game.error.CommandNotFound;
import it.uniba.app.Thompson.game.error.InvalidArguments;
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
    private static MatchE match;
    private static BoardE board = new BoardE(true);

    /**
     * Constructor for the class MainControl.
     */
    private MainControl() { }

    /**
     * Method initCommands.
     * @return commands The map of the available commands
     */
    private static HashMap<String, CommandC> initCommands() {
        HashMap<String, CommandC> commands = new HashMap<>();

        commands.put(HelpCommandC.getInstance().getCommand(), HelpCommandC.getInstance());
        commands.put(ExitCommandC.getInstance().getCommand(), ExitCommandC.getInstance());
        commands.put(PlayCommandC.getInstance().getCommand(), PlayCommandC.getInstance());
        commands.put(QuitCommandC.getInstance().getCommand(), QuitCommandC.getInstance());
        commands.put(VoidCommandC.getInstance().getCommand(), VoidCommandC.getInstance());
        commands.put(BoardCommandC.getInstance().getCommand(), BoardCommandC.getInstance());
        commands.put(AvailableMovesCommandC.getInstance().getCommand(),
                     AvailableMovesCommandC.getInstance());
        commands.put(MovesCommandC.getInstance().getCommand(), MovesCommandC.getInstance());
        commands.put(BlockCommandC.getInstance().getCommand(), BlockCommandC.getInstance());
        commands.put(TimeCommandC.getInstance().getCommand(), TimeCommandC.getInstance());
        return commands;
    }

    /**
     * Method initArgumentCommands.
     * @return commands The map of the valid arguments
     */
    private static HashMap<String, CommandC> initArgumentCommands() {
        HashMap<String, CommandC> commands = new HashMap<>();
        commands.putAll(addAliasesCommands(HelpCommandC.getInstance()));

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
    private static HashMap<String, CommandC> addAliasesCommands(final CommandC commandControl) {
        HashMap<String, CommandC> commands =  new HashMap<>();

        for (String a: commandControl.getAliases()) {
            commands.put(a, commandControl);
        }

        return commands;
    }

    /**
     * Method initMatch.
     */
    public static void initMatch() {
        match = new MatchE(MainControl.getBoard());
    }

    /**
     * Method getMatch.
     * @return match The current match.
     */
    public static MatchE getMatch() {
        MatchE defensiveCopy = match;
        if (defensiveCopy != null) {
            defensiveCopy = new MatchE(match.getBoard(), match.getMoves(), match.getCurrentTurn());
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
    public static void pushMoveQueue(final MoveE move) {
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
    public static BoardE getBoard() {
        BoardE defensiveCopy = board;
        if (defensiveCopy != null) {
            defensiveCopy = new BoardE(board);
        }
        return defensiveCopy;
    }

    /**
     * Method setBoard.
     * @param newBoard The new board of the match
     */
    public static void setBoard(final BoardE newBoard) {
        board = new BoardE(newBoard);
    }

    /**
     * Method findAndExecuteCommand, finds and executes the command.
     * @param commandStrings Array that contains command and other arguments
     * @param availableCommands The map of the available commands
     * @return Returns The status of the command
     * @throws CommandNotFound If the command is not found
     * @throws InvalidArguments The command is followed by invalid number of arguments
     */
    private static CommandStatus findAndExecuteCommand(
        final String[] commandStrings,
        final HashMap<String, CommandC> availableCommands
    ) throws CommandNotFound, InvalidArguments {
        //First element of commandsStrings must be recognized command
        if (availableCommands.containsKey(commandStrings[0])) {
            CommandC commandControl = availableCommands.get(commandStrings[0]);

            if (commandControl.getArgumentCount() != commandStrings.length - 1) {
                throw new InvalidArguments();
            }

            return commandControl.executeCommand(Arrays.copyOfRange(commandStrings, 1, commandStrings.length));
        }
        throw new CommandNotFound();
    }

    /**
     * Method executeArgumentsCommands, executes all the arguments in the args array.
     * @param args Array of all the arguments
     * @param commands Map of all the valid arguments
     */
    private static void executeArgumentsCommands(final String[] args, final HashMap<String, CommandC> commands) {
        for (String arg : args) {
            try {
                CommunicateInteractionMessageB.printNewLine();
                findAndExecuteCommand(new String[]{arg}, commands);
                CommunicateInteractionMessageB.printNewLine();
            } catch (CommandNotFound e) {
                CommunicateErrorB.printArgumentNotFound(arg);
            } catch (InvalidArguments e) {
                CommunicateErrorB.printInvalidArguments();
            } catch (Error e) {
                CommunicateErrorB.printGenericError();
            }
        }
    }

    /**
     * Method manageMove.
     * @param from Coordinate from of the move
     * @param to Coordinate to of the move
     */
    private static void manageMove(final Coordinate from, final Coordinate to) {
        BoardE b = match.getBoard();

        try {
            b.movePawn(from, to);

            pushMoveQueue(new MoveE(from, to));
            switchTurn();

            int[][] mask = VerifyMovesC.verifyMovesAllPawns(b, match.getCurrentTurn());
            if (VerifyMovesC.isMaskEmpty(mask)) {
                CommunicateInteractionMessageB.printSkippingTurn(match.getCurrentTurn());
                switchTurn();
            }

            match.setBoard(b);

            PrintBoardB.printBoard(b);
            if (match != null && b.isBoardFull()) {
                endMatch();
            }

        } catch (InvalidMove e) {
            CommunicateErrorB.printInvalidMove();
        }
    }

    /**
     * Method endMatch.
     */
    private static void endMatch() {
        BoardE b = match.getBoard();
        int whitePawnCount = b.countPawns(PawnFigure.WHITE_PAWN);
        int blackPawnCount = b.countPawns(PawnFigure.BLACK_PAWN);

        if (whitePawnCount == blackPawnCount) {
            CommunicateInteractionMessageB.printDraw(blackPawnCount, whitePawnCount);
        } else {
            CommunicateInteractionMessageB.printWinner(
                whitePawnCount > blackPawnCount ? PawnFigure.WHITE_PAWN : PawnFigure.BLACK_PAWN,
                Math.max(whitePawnCount, blackPawnCount),
                Math.min(whitePawnCount, blackPawnCount)
            );
        }

        removeMatch();
        setBoard(new BoardE(true));
    }

    /**
     * Method startMainControl, starts main control, starts the main control loop.
     * @param args Array of all the arguments
     */
    public static void startMainControl(final String[] args) {
        HashMap<String, CommandC> availableCommands = initCommands();
        CommandStatus status = CommandStatus.SUCCESSFUL;
        RegexMoveC matcher = new RegexMoveC();

        WelcomeBannerB banner = new WelcomeBannerB();
        banner.printBanner();

        executeArgumentsCommands(args, initArgumentCommands());

        while (status != CommandStatus.SHUTDOWN) {
            String[] commandStrings = UserInputB.getCommandAndArguments();
            CommunicateInteractionMessageB.printNewLine();
            try {
                if (commandStrings.length == 0) {
                    throw new CommandNotFound();
                }
                if (matcher.isGenericCoordinate(commandStrings[0])) {
                    if (match == null) {
                        throw new MatchNull();
                    }

                    if (!matcher.controlInputMovement(commandStrings[0])) {
                        throw new InvalidMove();
                    }

                   String[] toConvert = commandStrings[0].split("-");

                    try {
                        manageMove(Coordinate.toCoordinate(toConvert[0]), Coordinate.toCoordinate(toConvert[1]));
                    } catch (InvalidCoordinate e) {
                        CommunicateErrorB.printCoordinateNotValid();
                    }

                } else {
                    status = findAndExecuteCommand(commandStrings, availableCommands);
                }
            } catch (CommandNotFound e) {
                CommunicateErrorB.printCommandNotFound();
            } catch (InvalidArguments e) {
                CommunicateErrorB.printInvalidArguments();
            }  catch (MatchNull e) {
                CommunicateErrorB.printSuggestMatchInit();
            } catch (InvalidMove e) {
                CommunicateErrorB.printInvalidMove();
            } catch (Error e) {
                CommunicateErrorB.printGenericError();
            }
        }
        CommunicateInteractionMessageB.printGoodbye();
    }
}
