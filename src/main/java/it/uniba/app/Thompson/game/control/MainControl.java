package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.CommunicateInteractionMessagesBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.boundary.WelcomeBannerBoundary;
import it.uniba.app.Thompson.game.entity.Match;
import it.uniba.app.Thompson.game.error.CommandNotFoundError;
import it.uniba.app.Thompson.game.error.InvalidArgumentsError;
import it.uniba.app.Thompson.game.util.CommandStatus;
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
        match = new Match();
    }

    /**
     * Method getMatch.
     * @return match The current match.
     */
    public static Match getMatch() {
        Match defensiveCopy = match;
        if (defensiveCopy != null) {
            defensiveCopy = new Match(match.getBoard(), match.getMoves());
        }
        return defensiveCopy;
    }

    /**
     * Method removeMatch, sets the current match to null, terminating it.
     */
    public static void removeMatch() {
        match = null;
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

            return availableCommands.get(commandStrings[0]).executeCommand();
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
                status = findAndExecuteCommand(commandStrings, availableCommands);
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
