package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.CommunicateErrorsBoundary;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.boundary.WelcomeBannerBoundary;
import it.uniba.app.Thompson.game.entity.Match;
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
        HashMap<String, CommandControl> commands =  new HashMap<>();

        commands.put(HelpCommandControl.getInstance().getCommand(), HelpCommandControl.getInstance());
        commands.put(ExitCommandControl.getInstance().getCommand(), ExitCommandControl.getInstance());
        commands.put(PlayCommandControl.getInstance().getCommand(), PlayCommandControl.getInstance());
        commands.put(QuitCommandControl.getInstance().getCommand(), QuitCommandControl.getInstance());
        commands.put(VoidCommandControl.getInstance().getCommand(), VoidCommandControl.getInstance());
        commands.put(BoardCommandControl.getInstance().getCommand(), BoardCommandControl.getInstance());

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
        return match;
    }

    /**
     * Method removeMatch, sets the current match to null, terminating it.
     */
    public static void removeMatch() {
        match = null;
    }

    /**
     * Method findAndExecuteCommand, finds command in the map availableCommands and executes it.
     * @param command Command to find and execute
     * @param availableCommands Map of the available commands
     * @return Returns the status of the system after the execution of the command.
     */
    private static CommandStatus findAndExecuteCommand(final String command,
                                                       final HashMap<String, CommandControl> availableCommands) {
        if (availableCommands.containsKey(command)) {
            return availableCommands.get(command).executeCommand();
        }
        throw new Error();
    }

    /**
     * Method executeArgumentsCommands, executes all the arguments in the args array.
     * @param args Array of all the arguments
     * @param commands Map of all the valid arguments
     */
    private static void executeArgumentsCommands(final String[] args, final HashMap<String, CommandControl> commands) {
        for (String a : args) {
            try {
                findAndExecuteCommand(a, commands);
            } catch (Error e) {
                CommunicateErrorsBoundary.printInvalidArgument();
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

        WelcomeBannerBoundary banner = new WelcomeBannerBoundary();
        banner.printBanner();

        executeArgumentsCommands(args, initArgumentCommands());

        while (status != CommandStatus.SHUTDOWN) {
            String command = UserInputBoundary.getInput();
            try {
                status = findAndExecuteCommand(command, availableCommands);
            } catch (Error e) {
                CommunicateErrorsBoundary.printInvalidCommand();
            }
        }
    }
}
