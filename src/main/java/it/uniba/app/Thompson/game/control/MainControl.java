package it.uniba.app.Thompson.game.control;
import it.uniba.app.Thompson.game.boundary.UserInput;
import it.uniba.app.Thompson.game.boundary.WelcomeBanner;
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
    private static HashMap<String, Command> initCommands() {
        HashMap<String, Command> commands = new HashMap<>();
        return commands;
    }
    /**
     * Start main control.
     * Start the main control loop.
     */
    public static void startMainControl() {
        CommandStatus status = CommandStatus.SUCCESSFUL;
        WelcomeBanner.printBanner();
        HashMap<String, Command> commands = initCommands();

        while (status != CommandStatus.FAILED || status != CommandStatus.SHUTDOWN) {
            String input = UserInput.getInput();
            if (commands.containsKey(input)) {
                status = commands.get(input).executeCommand();
            } else {
                //TODO: create a constant for this;
                //TODO: create a method in CommunicateErrors to print this message;
                System.out.println("Command not found");
            }
        }
    }
}
