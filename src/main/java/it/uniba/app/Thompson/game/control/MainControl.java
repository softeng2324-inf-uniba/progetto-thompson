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
     * @return the commands.
     */
    private static HashMap<String, CommandControl> initCommands() {
        HashMap<String, CommandControl> commands =  new HashMap<>();

        commands.put(HelpCommandControl.getInstance().getCommand(), HelpCommandControl.getInstance());

        return commands;
    }

    private static HashMap<String, CommandControl> initArgumentCommands() {
        HashMap<String, CommandControl> commands = new HashMap<>();
        commands.putAll(addAliasesCommands(HelpCommandControl.getInstance()));

        return commands;
    }

    private static HashMap<String, CommandControl> addAliasesCommands(final CommandControl commandControl) {
        HashMap<String, CommandControl> commands =  new HashMap<>();

        for (String a: commandControl.getAliases()) {
            commands.put(a, commandControl);
        }

        return commands;
    }

    private static CommandStatus findAndExecuteCommand(String command, HashMap<String, CommandControl> availableCommands) {
        if(availableCommands.containsKey(command)) {
            return availableCommands.get(command).executeCommand();
        }
        throw new Error();
    }

    private static void executeArgumentsCommands(String[] args, HashMap<String, CommandControl> commands) {
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
    public static void startMainControl(String[] args) {
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
