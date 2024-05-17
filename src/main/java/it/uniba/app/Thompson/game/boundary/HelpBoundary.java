package it.uniba.app.Thompson.game.boundary;
import it.uniba.app.Thompson.game.control.HelpCommandControl;

/**
 * << Boundary >>
 * Class used to print available commands.
 */
public final class HelpBoundary {

    /**
     * Print available commands.
     */
    public static void printCommands() {
        System.out.println(
            "COMANDI DISPONIBILI \n"
            + " - " + HelpCommandControl.getInstance().getCommand() + " : "
                    + HelpCommandControl.getInstance().getDescription() + "\n"
        );
    }

    private HelpBoundary() { }
}
