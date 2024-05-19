package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.*;

/**
 * << Boundary >>
 * Class used to print available commands.
 */
public final class HelpBoundary {

    /**
     * Print available commands.
     */
    public static void printCommands(CommandControl[] commands) {
        for (CommandControl command : commands) {
            System.out.print(
                " - " + command.getCommand() + " : " + command.getDescription() + "\n"
            );
        }
    }

    private HelpBoundary() { }
}
