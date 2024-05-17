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
    private static HashMap<String, Command> initCommands() {
        return new HashMap<String, Command>();
    }
    /**
     * Start main control.
     * Start the main control loop.
     */
    public static void startMainControl() {
        CommandStatus status = CommandStatus.SUCCESSFUL;
        WelcomeBannerBoundary.printBanner();
        HashMap<String, Command> commands = initCommands();

        while (status != CommandStatus.FAILED || status != CommandStatus.SHUTDOWN) {
            String input = UserInputBoundary.getInput();
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
