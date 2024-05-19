package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.CommandControl;

/**
 * {@literal << Boundary >>}
 * Class to communicate available commands.
 */
public final class HelpBoundary {

    /**
     * Constructor for the class HelpBoundary.
     */
    private HelpBoundary() { }

    /**
     * Method printCommands, prints to stdout the available commands.
     * @param commands The array of commands that will be printed
     */
    public static void printCommands(CommandControl[] commands) {
        for (CommandControl command : commands) {
            System.out.print(
                " - " + command.getCommand() + " : " + command.getDescription() + "\n"
            );
        }
    }
}
