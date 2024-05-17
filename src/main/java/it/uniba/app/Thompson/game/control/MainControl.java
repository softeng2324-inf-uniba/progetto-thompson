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

    /**
     * Start main control.
     * Start the main control loop.
     */
    public static void startMainControl() {
        CommandStatus status = CommandStatus.SUCCESSFUL;
        WelcomeBannerBoundary banner = new WelcomeBannerBoundary();
        banner.printBanner();
        HashMap<String, CommandControl> commands = initCommands();

        while (status != CommandStatus.SHUTDOWN) {
            String input = UserInputBoundary.getInput();
            if (commands.containsKey(input)) {
                status = commands.get(input).executeCommand();
            } else {
                /* TODO:
                 * create a constant for this create a method
                 * in CommunicateErrors to print this message;
                 */
                System.out.println(input + " is not a valid command.");
            }
        }
    }
}
