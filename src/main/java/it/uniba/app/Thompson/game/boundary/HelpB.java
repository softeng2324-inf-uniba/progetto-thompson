package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.CommandC;

/**
 * {@literal << Boundary >>}
 * Class to communicate available commands.
 */
public final class HelpB {

    /**
     * Constructor for the class HelpB.
     */
    private HelpB() { }

    /**
     * Method printCommands, prints to stdout the available commands.
     * @param extraCommand The extra command that will be printed
     * @param commands The array of commands that will be printed
     */
    public static void printCommands(final String extraCommand, final CommandC[] commands) {

        System.out.println(" - " + extraCommand);

        for (CommandC command : commands) {
            System.out.println(
                " - " + command.getCommand() + " : " + command.getDescription()
            );
        }
    }
}
