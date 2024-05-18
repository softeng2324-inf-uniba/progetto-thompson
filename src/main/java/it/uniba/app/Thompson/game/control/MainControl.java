package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.UserInputBoundary;
import it.uniba.app.Thompson.game.boundary.WelcomeBannerBoundary;
import it.uniba.app.Thompson.game.util.CommandStatus;
import java.util.HashMap;

/**
 * << Control >>
 * Main control class for the game.
 */
public final class MainControl {
    /**
     * Constructor for MainControl.
     */
    private MainControl() { }
    /**
     * Initialize commands.
     * @return The available commands.
     */
    private static HashMap<String, CommandControl> initCommands() {
        HashMap<String, CommandControl> commands =  new HashMap<>();

        commands.put(HelpCommandControl.getInstance().getCommand(), HelpCommandControl.getInstance());
        commands.put(ExitCommandControl.getInstance().getCommand(), ExitCommandControl.getInstance());
        return commands;
    }

    /**
     * Initialize valid arguments.
     * @return The valid arguments.
     */
    private static HashMap<String, CommandControl> initArgumentCommands() {
        HashMap<String, CommandControl> commands = new HashMap<>();
        commands.putAll(addAliasesCommands(HelpCommandControl.getInstance()));

        return commands;
    }

    /**
     * Initialize all aliases for a valid argument.
     * @param commandControl Command linked to the argument.
     * @return A map of the aliases of the argument.
     */
    private static HashMap<String, CommandControl> addAliasesCommands(final CommandControl commandControl) {
        HashMap<String, CommandControl> commands =  new HashMap<>();

        for (String a: commandControl.getAliases()) {
            commands.put(a, commandControl);
        }

        return commands;
    }

    /**
     * Finds command in the map availableCommands and executes it.
     * @param command Command to find and execute.
     * @param availableCommands Map of the available commands.
     * @return The status of the system after the execution of the command.
     */
    private static CommandStatus findAndExecuteCommand(final String command,
                                                       final HashMap<String, CommandControl> availableCommands) {
        if (availableCommands.containsKey(command)) {
            return availableCommands.get(command).executeCommand();
        }
        throw new Error();
    }

    /**
     * Executes all the arguments in the args array.
     * @param args Array of all the arguments.
     * @param commands Map of all the valid arguments.
     */
    private static void executeArgumentsCommands(final String[] args, final HashMap<String, CommandControl> commands) {
        for (String a : args) {
            try {
                findAndExecuteCommand(a, commands);
            } catch (Error e) {
                /* TODO:
                 * create a constant for this
                 * create a method in CommunicateErrors to print this message;
                 */
                System.out.println(a + " is not a valid argument.");
            }
        }

    }

    /**
     * Start main control.
     * Start the main control loop.
     */
    public static void startMainControl(final String[] args) {
        CommandStatus status = CommandStatus.SUCCESSFUL;
        HashMap<String, CommandControl> availableCommands = initCommands();

        WelcomeBannerBoundary banner = new WelcomeBannerBoundary();
        banner.printBanner();

        executeArgumentsCommands(args, initArgumentCommands());

        while (status != CommandStatus.SHUTDOWN) {
            String command = UserInputBoundary.getInput();
            try {
                status = findAndExecuteCommand(command, availableCommands);
            } catch (Error e) {
                /* TODO:
                 * create a constant for this
                 * create a method in CommunicateErrors to print this message;
                 */
                System.out.println(command + " is not a valid command.");
            }
        }
    }
}
